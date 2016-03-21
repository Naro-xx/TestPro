package by.userTable.CsvUtil;

import by.userTable.pool.ConnectionPool;
import by.userTable.util.DAOUtils;
import by.userTable.util.DataBaseManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Narek on 12/10/2015.
 */
public class CsvUtil {
    private static final Logger LOGGER = Logger.getLogger(CsvUtil.class);
    private static CsvUtil csvUtil;
    public static synchronized CsvUtil getCsvUtil(){
        if (csvUtil==null){
            csvUtil=new CsvUtil();
        }
        return csvUtil;
    }
    public void UploadCsv(String path){
        PreparedStatement st = null;
        Connection connection = null;
        BufferedReader bf;
        try {
            bf=new BufferedReader(new FileReader(path));
            String line;
            while ((line=bf.readLine())!=null){
            String[] values=line.split(",");
                String sql="INSERT into user(name,surname,login,email,number)"+" values('"+values[0]+"','"+values[1]+"','"+values[2]+"','"+values[3]+"','"+values[4]+"')";
                connection= ConnectionPool.getInstance().getResource();
                st=connection.prepareStatement(sql);
                st.executeUpdate();
            }

        } catch (FileNotFoundException e) {
            LOGGER.fatal(e);

        } catch (IOException e) {
           LOGGER.fatal(e);

        } catch (SQLException e) {
            LOGGER.fatal(e);
        }finally {
            ConnectionPool.getInstance().returnResources(connection);
            DAOUtils.closeStatement(st);
        }
    }

}
