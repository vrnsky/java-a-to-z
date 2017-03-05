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
 * This servlet provide remove role function.
 */
@WebServlet("/remove_role")
public class RemoveRole extends HttpServlet {

    /**
     * This method execute forwarding request to the jsp view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", ExtendedRepo.getInstance().getAllRoles());
        req.getRequestDispatcher("/WEB-INF/views/remove_role.jsp").forward(req, resp);
    }

    /**
     * This method processing data from form and remove from system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roleId = Integer.valueOf(req.getParameter("role"));
        ExtendedRepo.getInstance().removeRole(roleId);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
