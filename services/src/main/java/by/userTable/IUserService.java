package by.userTable;

import by.userTable.entity.User;

import java.util.List;

/**
 * Created by Narek on 12/11/2015.
 */
public interface IUserService {
    List<User> getUsers(String sortRow, String sortFlag, String countResult, String pageNumber);
    String[] getCountPages(String countResult, String pageNumber, String navBtn);
}
