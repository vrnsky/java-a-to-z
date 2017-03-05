package controllers;

import dao.ExtendedRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 24.02.2017
 *
 * This servlet provide edit function.
 */
@WebServlet(urlPatterns = "/edit")
public class Edit extends HttpServlet {

    /**
     * This method forward request from user to jsp view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", ExtendedRepo.getInstance().getAllRoles());
        req.setAttribute("user", ExtendedRepo.getInstance().getUserById(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }

    /**
     * This method processing form for edit user and redirect user to the main page.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roleNumber = 0;
        int id = Integer.valueOf(req.getParameter("id"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (role == null) {
            roleNumber = 2;
        } else {
            roleNumber = Integer.valueOf(req.getParameter("role"));
        }
        ExtendedRepo.getInstance().editUser(id, login, password, roleNumber);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
