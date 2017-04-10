package controllers;

import model.Advert;
import model.Car;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import repos.AdvertRepo;
import repos.CarRepo;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 30.03.2017
 *
 * This servlet add new advert to the system.
 */
@WebServlet("/newadvert")
public class Adverter extends HttpServlet  {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(Adverter.class);

    /**
     * Contains data which collected from the form.
     */
    private static final ConcurrentMap<String, String> FORM = new ConcurrentHashMap<String, String>();

    /**
     * Forward request to the view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for post could not be handled.
     * @throws IOException if io error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(String.format("%s/add.html", req.getContextPath())).forward(req, resp);
    }

    /**
     * Collect data from form and processing it, and at the end add new advert.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST could not be handled.
     * @throws IOException if an i/o error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext context = this.getServletConfig().getServletContext();
            File repo = (File) context.getAttribute("javax.servlet.context.dir");
            factory.setRepository(repo);
            ServletFileUpload upload = new ServletFileUpload(factory);
            HttpSession session = req.getSession();
            try {
                List<FileItem> items = upload.parseRequest(req);
                fillMapFromParsedRequest((User) session.getAttribute("user"), items);
                FORM.clear();
            } catch (FileUploadException fue) {
                LOG.log(Level.ERROR, fue.getMessage(), fue);
            }

        }
    }

    /**
     * Process data collecting at the post method and adding new advert.
     * @param user instance of user class.
     * @param items data from client part of app.
     */
    private void fillMapFromParsedRequest(User user, List<FileItem> items) {
        for (FileItem item: items) {
            LOG.log(Level.INFO, String.format("Field:%s | Value:%s", item.getFieldName(), item.getString()));
            if (item.isFormField()) {
                FORM.put(item.getFieldName(), item.getString());
            } else {
                FORM.put("fileUrl", item.getString());
            }
        }
        int modelId = Integer.valueOf(FORM.get("model"));
        int producerId = Integer.valueOf(FORM.get("producer"));
        int bodyId = Integer.valueOf(FORM.get("body"));
        long price = Long.valueOf("price");
        Car car = CarRepo.getInstance().getCarByParam(modelId, producerId, bodyId).get(0);
        Advert advert = new Advert(car, user, price);
        AdvertRepo.getInstance().add(advert);
    }
}
