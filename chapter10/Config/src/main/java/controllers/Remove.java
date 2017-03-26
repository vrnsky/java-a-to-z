package controllers;

import repository.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 *
 * This servlet provide remove function from the items list.
 */
public class Remove extends HttpServlet {

    /**
     * Execute removing item from list and database.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST not could handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        ItemRepository.getInstance().remove(ItemRepository.getInstance().getById(id));
    }
}
