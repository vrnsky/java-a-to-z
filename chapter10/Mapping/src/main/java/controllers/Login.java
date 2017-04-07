package controllers;

import model.User;
import repos.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 03.04.2017
 */

@WebServlet("/login")
public class Login extends HttpServlet {

    /**
     * Forward request to the view.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be handled.
     * @throws IOException if io error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(String.format("%s/login.html", req.getContextPath())).forward(req, resp);
    }

    /**
     * Login.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be hanled.
     * @throws IOException if io error detected.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = UserRepo.getInstance().getUserByCredits(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect(String.format("%s/adverts.html", req.getContextPath()));
        } else {
            session.setAttribute("error", "User with given credits not exist");
            req.getRequestDispatcher(String.format("%s/login.html", req.getContextPath()));
        }
    }
}