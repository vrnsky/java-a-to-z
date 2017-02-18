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
 * This servlet provide edit function of user.
 * At this servlet generate form with current data.
 * And client may change data at the form.
 */
public class EditUser extends HttpServlet {

    /**
     * User repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * Call when user only get page.
     * @param req from client.
     * @param resp from server.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int id = Integer.valueOf(req.getParameter("id"));
        User user = repo.findUserById(id);
        String context = req.getContextPath();
        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Edit user</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append(String.format("<form action='%s' method=post>", context + "/edit"));
        writer.append(String.format("<input type='hidden' name='id' value='%s'/>", id));
        writer.append("Name: <input type='text' name='name' value='" + user.getName() + "'/><br />");
        writer.append("Surname: <input type='text' name='surname' value='" + user.getSurname() + "'/><br />");
        writer.append("Email: <input type='text' name='email' value='" + user.getEmail() + "'/><br />");
        writer.append("<input type='submit' value='Edit' />");
        writer.append("</form>");
        writer.append("</body>");
        writer.append("</html>");
    }

    /**
     *
     * @param req from client.
     * @param resp from server.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        User user = new User(id, name, surname, email);
        repo.editUser(user);
        resp.sendRedirect(String.format("%s/index", req.getContextPath()));
    }
}
