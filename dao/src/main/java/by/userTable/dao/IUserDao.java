package by.userTable.dao;

import by.userTable.entity.User;

import java.util.List;

/**
 * Created by Narek on 12/9/2015.
 */
public interface IUserDao {

    List<User> getUsers(String sql, int countResultInt, int startResult);
    int getCountUser();
}
