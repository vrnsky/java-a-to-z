package controllers;

import dao.UserRepository;
import model.Address;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.03.2017
 * <p>
 * Add new user to the system.
 */
@WebServlet("/add")
public class Add extends HttpServlet {

    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(Add.class.getSimpleName());

    /**
     * Important: Apache FileUpload grabs all data from form.
     * I make this for collect all field values and handle later.
     * After processing form this map will clear.
     */
    private ConcurrentMap<String, String> values = new ConcurrentHashMap<>();

    /**
     * Add new user to the system.
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cvFileLink = "";
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        values.put(name, value);
                        log.info(value);
                    } else {
                        cvFileLink = item.getName();
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        User user = new User(-1, this.values.get("email"), this.values.get("password"), cvFileLink, new Address(values.get("country"), values.get("city")));
        UserRepository.getInstance().addUser(user);
        this.values.clear();
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}


