package by.userTable.impl;

import by.userTable.dao.IUserDao;
import by.userTable.entity.User;
import by.userTable.pool.ConnectionPool;
import by.userTable.util.DAOUtils;
import by.userTable.util.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Narek on 12/9/2015.
 */
public class UserDao implements IUserDao {
    private static final String SQL_QUERY_GET_USERS="SELECT * FROM user ";
    private static final String SQL_QUERY_GET_COUNT="SELECT COUNT(*) FROM user";
    public List<User> getUsers(String sql, int countResult, int startResult) {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet res;
        String query=SQL_QUERY_GET_USERS+sql+" LIMIT "+startResult+", "+countResult;
        List<User> users=new ArrayList<>();
        try {
            conn=ConnectionPool.getInstance().getResource();
            pr=conn.prepareStatement(query);
            res=pr.executeQuery();
            while (res.next()){
                User user=new User();
                user.setName(res.getString(1));
                user.setSurname(res.getString(2));
                user.setLogin(res.getString(3));
                user.setEmail(res.getString(4));
                user.setNumber( res.getLong(5));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOUtils.closeStatement(pr);
            ConnectionPool.getInstance().returnResources(conn);
        }
        return users;
    }

    @Override
    public int getCountUser() {
        Connection cn=null;
        PreparedStatement pr = null;
        ResultSet rs;
        int count = 0;
        try {
            cn= ConnectionPool.getInstance().getResource();
            pr=cn.prepareStatement(SQL_QUERY_GET_COUNT);
            rs=pr.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().returnResources(cn);
            DAOUtils.closeStatement(pr);
        }
        return count;
    }

}
