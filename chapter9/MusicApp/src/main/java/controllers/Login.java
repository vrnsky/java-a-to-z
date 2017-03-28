package controllers;

import model.User;
import repository.UserRepo;

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
 * @since 28.03.2017
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = UserRepo.getInstance().getUserByCredits(login, password);
        if (user != null) {
            session.setAttribute("user", user);
        } else {
            resp.sendRedirect(String.format("%s/login.html", req.getContextPath()));
        }
    }
}
