package by.userTable.commands;

import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Narek on 12/11/2015.
 */
public interface Command {
    String execute(HttpServletRequest request) throws FileUploadException;
}
