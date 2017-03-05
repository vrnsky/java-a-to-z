package controllers;

import database.Repository;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 *
 * This servlet provide adding new user to the system.
 */
public class CreateUser extends HttpServlet {

    /**
     * Instance of user repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * When user only get page.
     * @param req from client.
     * @param resp from server.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String context = req.getContextPath();
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>");
        writer.append("<head>");
        writer.append("<title>Create new user</title>");
        writer.append("<meta charset=utf-8/>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append(String.format("<form action=%s/create method=post>", context));
        writer.append("Name: <input type='text' name='name'><br />");
        writer.append("Surname: <input type='text' name='surname'><br />");
        writer.append("Email: <input type='text' name='email'><br />");
        writer.append("<input type='submit' value='Submit'/>");
        writer.append("</form>");
        writer.append("</body>");
        writer.append("</html>");


    }

    /**
     * When user send some data to the server.
     * @param req from user.
     * @param resp to user from client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        User user = new User(name, surname, email);
        repo.addUser(user);
        resp.sendRedirect(String.format("%s/index", req.getContextPath()));
    }
}
