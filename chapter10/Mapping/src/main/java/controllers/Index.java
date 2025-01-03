package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Advert;
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
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); //If some fields of entity is not fill, mapper was fail.
        List<Advert> adverts = AdvertRepo.getInstance().getAdvertsByUserId(1);
        writer.append(mapper.writeValueAsString(adverts));
        writer.flush();
    }

    /**
     * Execute search for adverts with given params.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could for POST could not be handled.
     * @throws IOException if io error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        String producer = req.getParameter("producer");
        String model = req.getParameter("model");
        String body = req.getParameter("body");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        List<Advert> adverts = AdvertRepo.getInstance().getAdvertsByParam(producer, model, body);
        writer.append(mapper.writeValueAsString(adverts));
        writer.flush();
    }
}
