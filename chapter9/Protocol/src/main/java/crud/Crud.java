package crud;

import repo.User;
import repo.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 31.01.2017
 *
 * Create, read by id, update and delete servlet.
 */
public class Crud extends HttpServlet {

    /**
     * User repository.
     */
    private UserRepo repository;

    /**
     * Default constructor.
     */
    public Crud() {
        this.repository = new UserRepo();
    }


    /**
     * HTTP request get return page with all controllers at the system.
     * @param req request from client.
     * @param resp response from server.
     * @throws ServletException if problem with servlet.
     * @throws IOException if problem with response writer.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<User> users = this.repository.getAllUsers();
        if (users.size() > 0) {
            for (User user : users) {
                writer.append(String.format("%s\n", user.toString()));
            }
            writer.flush();
        } else {
            writer.append("At this moment system have zero controllers.");
            writer.flush();
        }
        writer.close();
    }

    /**
     * Adding new user to the system.
     * @param req request from client for adding new user.
     * @param resp response from client.
     * @throws ServletException if problem with servlet.
     * @throws IOException if problem with response.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        this.repository.addUser(new User(name, surname, email));
    }

    /**КУ
     * Request to edit user which already in system.
     * @param req request from client.
     * @param resp response from server.
     * @throws ServletException if some problem with servlet.
     * @throws IOException if some problem with io operations.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        this.repository.editUser(id, name, surname, email);
    }

    /**
     * Delete user from system.
     * @param req request from client.
     * @param resp response from server.
     * @throws ServletException if some problem with servlet.
     * @throws IOException if some problem with io operations.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        this.repository.removeUser(id);
    }

}
