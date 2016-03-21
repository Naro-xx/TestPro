package by.userTable.commands;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Narek on 12/11/2015.
 */
public class CommandFactory {
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);

    public Command defineCommand(HttpServletRequest request) {
        Command current = new EmptyCommand();
        String action = request.getParameter("page");
        boolean isMultipartRequest= ServletFileUpload.isMultipartContent(request);
        if (action == null || action.isEmpty()) {
            if(isMultipartRequest){
                current=new UploadCommand();
            }
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LOGGER.error(e);
        }
        return current;
    }
}
