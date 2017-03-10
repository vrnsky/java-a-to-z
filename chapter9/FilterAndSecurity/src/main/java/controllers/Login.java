package controllers;

import dao.ExtendedRepo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.02.2017
 * <p>
 * This servlet provide login function.
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    /**
     * This method forward user to the jsp view.
     *
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    /**
     * This method processing form for login new user to the system.
     *
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ExtendedRepo repo = ExtendedRepo.getInstance();
        HttpSession session = req.getSession();
        User user = repo.getUser(login, password);
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Credintals is not valid!");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
