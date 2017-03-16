package controllers;

import dao.UserRepository;
import model.Address;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.03.2017
 *
 * This servlet provide remove function
 *
 */
@WebServlet("/remove")
public class Remove extends HttpServlet {


    /**
     * Remove user from system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        UserRepository.getInstance().removeUser(new User(id, "", "", "", new Address("", "")));
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}
