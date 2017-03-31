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
 * This controllers push to the client bodies of car.
 */
@WebServlet("/body")
public class Body extends HttpServlet {

    /**
     * Return bodies of the car.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be handled.
     * @throws IOException if i/o detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(CarRepo.getInstance().getAllBodies()));
        writer.flush();
    }
}
