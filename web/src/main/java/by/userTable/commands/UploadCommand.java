package by.userTable.commands;

import by.userTable.CsvUtil.CsvUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Narek on 12/12/2015.
 */
public class UploadCommand implements Command {


    public String execute(HttpServletRequest request) {
       String path= request.getServletContext().getRealPath("");
        request.setAttribute("message",path);
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> multiParts = upload.parseRequest(request);
            for (FileItem item : multiParts) {
                if (!item.isFormField()) {
                    String name = new File(item.getName()).getName();
                    String filePath=path + File.separator + name;
                    item.write(new File(filePath));
                    CsvUtil.getCsvUtil().UploadCsv(filePath);
                }
            }
            request.setAttribute("message", "Your file has been uploaded!");
        }
        catch (Exception e)
        {
            request.setAttribute("message", "File Upload Failed due to " + e);
        }

        return PageManager.getProperty("page.users");
    }
}
