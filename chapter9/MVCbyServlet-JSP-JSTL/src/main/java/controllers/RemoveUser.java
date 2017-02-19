package controllers;

import dao.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 19.02.2017
 *
 * This servlet provides remove function.
 */
@WebServlet("/remove")
public class RemoveUser extends HttpServlet {

    /**
     * Instance of repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * When user ask only page, we forward request and response to the jsp page.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("user", repo.getUserById(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("WEB-INF/views/remove.jsp").forward(req, resp);
    }

    /**
     * When user full form and push the button we need process data and remove user from system.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.valueOf(req.getParameter("id"));
        repo.removeUser(repo.getUserById(id));
        resp.sendRedirect(String.format("%s/index", req.getContextPath()));
    }
}
