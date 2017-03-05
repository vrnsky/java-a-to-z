package controllers;

import dao.ExtendedRepo;
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
 * @since 02.03.2017
 *
 * This servlet provide adding new user to the system.
 */
@WebServlet("/create")
public class Create extends HttpServlet {


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
        req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
    }

    /**
     * This method processing form for create new user.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        ExtendedRepo.getInstance().addUser(new User(login, password, role));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
