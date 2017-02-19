package controllers;

import dao.Repository;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 19.02.2017
 *
 * This servlet provides edit function.
 */

@WebServlet("/edit")
public class EditUser extends HttpServlet {


    /**
     * When user ask the page, servlet forward request and response to the jsp.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with data exchange.
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("user", Repository.getInstance().getUserById(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(req, resp);
    }

    /**
     * When user full form and push the button we need process form and edit data at the db.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Repository.getInstance().editUser(new User(id, name, surname, email));
        resp.sendRedirect(String.format("%s/index", req.getContextPath()));
    }
}
