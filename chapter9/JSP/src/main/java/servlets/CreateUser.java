package servlets;

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
 * @since 18.02.2017
 *
 * This servlet add new user to the system.
 */
@WebServlet("/create")
public class CreateUser extends HttpServlet {


    /**
     * Processing data from create.jsp and add user to the system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository repo = Repository.getInstance();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        repo.addUser(new User(name, surname, email));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
