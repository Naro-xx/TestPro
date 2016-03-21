package by.userTable.commands;

import by.userTable.Impl.UserService;
import by.userTable.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Narek on 12/11/2015.
 */
public class UsersCommand implements Command {

    public String execute(HttpServletRequest request) {
        HttpSession sess=request.getSession(true);
        UserService userService= new UserService();
        String navBtn=request.getParameter("navBtn");
        String sortRow= request.getParameter("sortRow");
        String sortFlag=request.getParameter("sortFlag");
        String countResult= request.getParameter("countResult");
        String pageNumber=request.getParameter("currentPage");
        String noOFPages[]=userService.getCountPages(countResult,pageNumber,navBtn);
        List<User> users=userService.getUsers(sortRow,sortFlag,noOFPages[2],noOFPages[0]);
        request.getSession().setAttribute("countResult",noOFPages[2]);
        request.getSession().setAttribute("users",users);
        request.getSession().setAttribute("currentPage",noOFPages[0]);
        request.getSession().setAttribute("noOFPages",noOFPages[1]);



        return PageManager.getProperty("page.users");

    }
}
