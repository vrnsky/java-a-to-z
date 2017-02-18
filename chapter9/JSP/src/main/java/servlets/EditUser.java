package servlets;

import dao.Repository;
import models.User;

import javax.servlet.RequestDispatcher;
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
 * This servler provide function edit for user which already in system.
 */
@WebServlet("/edit")
public class EditUser extends HttpServlet {

    /**
     * Instance of repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * If user go to this, it redirect to the edit.jsp for editing.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Processing data from form at the edit.jsp and edit data in the database.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository repo = Repository.getInstance();
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        repo.editUser(new User(id, name, surname, email));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
