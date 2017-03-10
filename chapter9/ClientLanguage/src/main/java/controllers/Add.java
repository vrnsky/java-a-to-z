package controllers;

import model.Address;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.03.2017
 */
@WebServlet("/add")
public class Add extends HttpServlet {

    private Logger LOG = Logger.getLogger(Add.class);
    private String email;
    private String password;
    private String country;
    private String city;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            this.email = req.getParameter("email");
            this.password = req.getParameter("password");
            this.country = req.getParameter("country");
            this.city = req.getParameter("city");
            if (ServletFileUpload.isMultipartContent(req)) {
                this.loadFile(req);
            }
            User user = new User(-1, email, password, "", new Address(country, city));
            resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));


    }

    private void loadFile(HttpServletRequest req) {
        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(req);
            LOG.log(Level.INFO, String.format("File save at: %s", repository.toString()));
            LOG.log(Level.INFO, items.get(0));
        } catch (FileUploadException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }

}
