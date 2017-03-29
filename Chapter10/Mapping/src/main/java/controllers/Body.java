package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.CarInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */
@WebServlet("/body")
public class Body extends HttpServlet {

    /**
     * Return all car body as json string.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for GET could not be handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        List<CarInfo> bodies = new ArrayList<>();/*CarRepository.getInstance().getAllBodies() */
        writer.append(mapper.writeValueAsString(bodies));
        writer.flush();
    }
}
