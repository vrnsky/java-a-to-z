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
 * @since 05.03.2017
 *
 * This servlet provide add role function to the system.
 */
@WebServlet("/add_role")
public class AddRole extends HttpServlet {

    /**
     * This method execute forwarding request to the jsp view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add_role.jsp").forward(req, resp);
    }

    /**
     * This method proccessing data from form and add it to the database.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("role");
        ExtendedRepo.getInstance().addRole(roleName);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
