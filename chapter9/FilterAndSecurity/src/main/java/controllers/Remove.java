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
 * @since 02.03.2017
 *
 * This servlet provide remove function.
 */
@WebServlet("/remove")
public class Remove extends HttpServlet {

    /**
     * This method forward user to the jsp view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", Integer.valueOf(req.getParameter("id")));
        req.getRequestDispatcher("/WEB-INF/views/remove.jsp").forward(req, resp);
    }

    /**
     * This method processing form for remove user.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        ExtendedRepo.getInstance().removeUser(id);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
