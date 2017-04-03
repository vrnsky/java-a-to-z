package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Advert;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import repos.AdvertRepo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 30.03.2017
 * This servlet load all adverts from database and flush it to client part of app.
 */
@WebServlet("/index")
public class Index extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Index.class);

    /**
     * Return all advert in json string.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for GET could not be handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); //FIXME when add file url
        List<Advert> adverts = AdvertRepo.getInstance().getAdvertsByUserId(1);
        writer.append(mapper.writeValueAsString(adverts));
        writer.flush();
    }
}
