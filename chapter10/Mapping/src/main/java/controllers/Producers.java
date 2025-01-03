package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.CarInfo;
import repos.CarRepo;

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
 * <p>
 * This controllers push to the client producers of car.
 */

@WebServlet("/producers")
public class Producers extends HttpServlet {
    /**
     * Flush to client part of app json string about car producers.
     *
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be handled.
     * @throws IOException      if a/n error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        List<CarInfo> producers = CarRepo.getInstance().getAllProducers();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(producers));
        writer.flush();
    }
}

