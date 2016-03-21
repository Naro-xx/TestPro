package by.userTable.controller;

import by.userTable.commands.Command;
import by.userTable.commands.CommandFactory;
import by.userTable.pool.ConnectionPool;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Narek on 12/11/2015.
 */
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    public Controller() {
        super();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        performAction(request, response);

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        performAction(request, response);
    }

    public void performAction(HttpServletRequest request,
                             HttpServletResponse response) throws IOException, ServletException {

        LOGGER.debug("start");
        CommandFactory client = new CommandFactory();
        Command command = client.defineCommand(request);
        try {
            String page;
            page = command.execute(request);
            if (page != null) {

                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher(page);
                requestDispatcher.forward(request, response);

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.releasePool();
    }
}
