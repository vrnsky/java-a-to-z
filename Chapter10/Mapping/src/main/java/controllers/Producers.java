package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky
 * @version 0.1.
 * @since 29.3.17
 *
 * This servlet return all producers from the database.
 */
@WebServlet("/producers")
public class Producers extends HttpServlet {

    /**
     * Return all producers exist at the system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST could not be handled.
     * @throws IOException if an input or output error detected
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String producers = mapper.writeValueAsString(""/*CarRepository.getInstance().getAllProducers()*/);
        writer.append(producers);
        writer.flush();
    }
}
