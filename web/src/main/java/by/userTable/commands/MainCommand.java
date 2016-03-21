package by.userTable.commands;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Narek on 12/11/2015.
 */
public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return PageManager.getProperty("page.main");
    }
}
