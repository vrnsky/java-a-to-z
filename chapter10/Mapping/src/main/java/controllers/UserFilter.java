package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import repos.AdvertRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 11.04.2017
 *
 * This controllers provide a user filtering function.
 */
@WebServlet("/userfilter")
public class UserFilter extends HttpServlet {

    /**
     * Ask about adverts and filter it, and return to client.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST could not be handled.
     * @throws IOException if an i/o error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        Map<String, Integer> parameters = new HashMap<>();
        parameters.put("producer_id", Integer.valueOf(req.getParameter("producer_id")));
        parameters.put("model_id", Integer.valueOf(req.getParameter("model_id")));
        parameters.put("body_id", Integer.valueOf(req.getParameter("body_id")));
        parameters.put("min", Integer.valueOf(req.getParameter("min")));
        parameters.put("max", Integer.valueOf(req.getParameter("max")));
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(AdvertRepo.getInstance().getAdvertsByCriteria(parameters)));
        writer.flush();
    }

}
