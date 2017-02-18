package servlets;

import dao.Repository;
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
 * This servler provide function remove user from system.
 */
@WebServlet("/remove")
public class RemoveUser extends HttpServlet {

    /**
     * Instance of repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * If user go this servlet by get request, it must forward request to the remove.jsp.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("remove.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Processing data from form at the remove.jsp and remove user from database.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        repo.removeUser(repo.getUserById(id));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
