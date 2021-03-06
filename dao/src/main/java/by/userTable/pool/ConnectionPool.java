package by.userTable.pool;

import by.userTable.util.DataBaseManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Narek on 12/10/2015.
 */
public class ConnectionPool {
    private static final ResourceBundle DB_BUNDLE = ResourceBundle
            .getBundle("database");

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private final static Integer POOL_SIZE = new Integer(DB_BUNDLE.getString("pool_size"));
    private static ConnectionPool instance = null;
    private ArrayBlockingQueue<Connection> resources = new ArrayBlockingQueue<>(
            POOL_SIZE);
    private static AtomicBoolean create = new AtomicBoolean(false);
    private static ReentrantLock lock = new ReentrantLock();
    private boolean closePool;

    private ConnectionPool() {
        init();
    }

    private void init() {
        DataBaseManager dataBaseManager = new DataBaseManager();
        Properties properties = new Properties();
        properties.setProperty("user", DB_BUNDLE.getString("login"));
        properties.setProperty("password", DB_BUNDLE.getString("password"));
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection cn ;
                cn = dataBaseManager.getConnection(properties);
                resources.put(cn);
            }
        } catch (SQLException e) {
            LOGGER.fatal("SQLException", e);
        } catch (InterruptedException e) {
            LOGGER.fatal("InterruptedException", e);
        }
    }

    public static ConnectionPool getInstance() {
        if (!create.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    create.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getResource() {
        if (closePool) {
        }
        Connection res = null;
        try {
            res = resources.take();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return res;

    }

    public void returnResources(Connection res) {
        try {
            resources.put(res);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }

    public void releasePool() {
        final int timeUnit = 5;
        closePool = false;
        Iterator<Connection> iterator = resources.iterator();
        while (iterator.hasNext()) {
            try {
                iterator.next().close();
                TimeUnit.SECONDS.sleep(timeUnit);
            } catch (SQLException | InterruptedException e) {
                LOGGER.error("exception pool close" + e);
            }
            resources.clear();
        }
    }
}
