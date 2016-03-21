package by.userTable.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Narek on 12/10/2015.
 */
public class DataBaseManager {
    private static final Logger LOGGER = Logger
            .getLogger(DataBaseManager.class);
    private static final ResourceBundle DB_BUNDLE = ResourceBundle
            .getBundle("database");

    public Connection getConnection(Properties properties) {
        Connection connection ;
        try {
            connection = DriverManager.getConnection(
                    DB_BUNDLE.getString("db_path"), properties);
        } catch (SQLException e) {
            LOGGER.fatal("SQLException: " + e);
            throw new ExceptionInInitializerError();
        }

        return connection;
    }
}
