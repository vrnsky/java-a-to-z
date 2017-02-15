package users;

import database.Repository;

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
 * This servlet provide remove function.
 */
public class RemoveUser extends HttpServlet {

    /**
     * Instance of user repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * When user ask only page. Show form with button to remove.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Remove user</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append("<p>Push button for remove user.</p>");
        writer.append(String.format("<form action='%s/remove' method=post>", req.getContextPath()));
        writer.append(String.format("<input type='hidden' name='id' value='%s'/>", Integer.valueOf(req.getParameter("id"))));
        writer.append("<input type='submit' value='Remove'/>");
        writer.append("</form>");
        writer.append("</body>");
        writer.append("</html>");
    }

    /**
     * Sending data to the server. Removing user from repository.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        repo.removeUser(repo.findUserById(id));
        resp.sendRedirect(String.format("%s/index", req.getContextPath()));
    }
}
