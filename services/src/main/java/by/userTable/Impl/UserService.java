package by.userTable.Impl;

import by.userTable.IUserService;
import by.userTable.SQLEnum.SelectSQL;
import by.userTable.dao.IUserDao;
import by.userTable.entity.User;
import by.userTable.impl.UserDao;

import java.util.List;

/**
 * Created by Narek on 12/11/2015.
 */
public class UserService implements IUserService {
    private IUserDao iUserDao;

    public UserService() {
        iUserDao = new UserDao();
    }

    @Override
    public List<User> getUsers(String sortRow, String sortFlag, String countResult, String pageNumber) {
        if(sortFlag==null || sortRow==null){
            sortFlag="up";
            sortRow="name";
        }
        String parametor = sortRow.toUpperCase() + "_" + sortFlag.toUpperCase();
        String sql = SelectSQL.valueOf(parametor).getSQL();
        int countResultInt = Integer.parseInt(countResult);
        int startResult = (Integer.parseInt(pageNumber) - 1) * countResultInt;
        return iUserDao.getUsers(sql, countResultInt, startResult);

    }

    @Override
    public String[] getCountPages(String countResult, String pageNumber, String navBtn) {
        if(countResult==null) {
            countResult = "5";
        }
        if(pageNumber==null){
            pageNumber="1";
        }
        int countPages ;
        int countResultInt = Integer.parseInt(countResult);
        int countUser = iUserDao.getCountUser();
        if (countUser % countResultInt == 0) {
            countPages = countUser / countResultInt;
        } else {
            countPages = countUser / countResultInt + 1;
        }
        if ("<<".equals(navBtn))
            pageNumber = "1";
        else if ("<".equals(navBtn)) {
            int temp = Integer.parseInt(pageNumber) - 1;
            if (temp <= 0){
                pageNumber="1";
            }else{
                pageNumber = String.valueOf(temp);
            }
        } else if (">>".equals(navBtn))
            pageNumber =String.valueOf(countPages);
        else if (">".equals(navBtn)) {
            int temp = Integer.parseInt(pageNumber) + 1;
            if (temp >  countPages){
                pageNumber = String.valueOf(countPages);
            }
            else
                pageNumber = String.valueOf(temp);
        }

        String[] result = new String[3];
        result[0] = pageNumber;
        result[1] = String.valueOf(countPages);
        result[2] = countResult;
        return result;
    }

}



