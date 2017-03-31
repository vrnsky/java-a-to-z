package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import repos.CarRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 30.03.2017
 *
 * This controller push to the client model depend on producer id.
 */

@WebServlet("/models")
public class Models extends HttpServlet {

    /**
     * Flush to client part models name depend on producer id.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be handled.
     * @throws IOException if i/o error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String producer = req.getParameter("producer");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String models = mapper.writeValueAsString(CarRepo.getInstance().getModelsByProducer(producer));
        writer.append(models);
        writer.flush();
    }
}

