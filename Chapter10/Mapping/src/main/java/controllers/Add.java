package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */

@WebServlet("/add")
public class Add extends HttpServlet {

    /**
     * Add new advert to the system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST could not be handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String producer = req.getParameter("producer");
        String model = req.getParameter("model");
        String body = req.getParameter("body");
        String price = req.getParameter("price");
    }
}
