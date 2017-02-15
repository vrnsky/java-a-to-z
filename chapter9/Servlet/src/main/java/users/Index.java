package users;

import database.Repository;
import models.User;

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
 * @since 15.02.2017
 *
 * This is index servlet. Show all user at the system.
 * And give user links to edit and remove users.
 */
public class Index extends HttpServlet {

    /**
     * Instance of user repository.
     */
    private Repository repo = Repository.getInstance();

    /**
     * When client only ask a page.
     * Show user table with users at the system and give links to perform edit or remove operations.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<User> users = repo.getAllUsers();
        String context = req.getContextPath();
        PrintWriter writer = resp.getWriter();
        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Index page</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append("<table border = '1'>");
        writer.append("<tr><td>ID</td><td>Name</td><td>Surname</td><td>Email</td><td>Operations</td>");
        for (User user : users) {
            String editUrl = String.format("<a href=%s/edit?id=%s>Edit</a>", context, user.getId());
            String removeUrl = String.format("<a href=%s/remove?id=%s>Remove</a>", context, user.getId());
            writer.append("<tr>");
            writer.append(String.format("<td>%s</td>", user.getId()));
            writer.append(String.format("<td>%s</td>", user.getName()));
            writer.append(String.format("<td>%s</td>", user.getSurname()));
            writer.append(String.format("<td>%s</td>", user.getEmail()));
            writer.append(String.format("<td>%s<br />", editUrl));
            writer.append(String.format("%s</td>", removeUrl));
            writer.append("</tr>");
        }
        writer.append("</table>");
        writer.append(String.format("<a href='%s'>Add new user</a>", context + "/create"));
        writer.append("</body>");
        writer.append("</html>");
        writer.flush();
    }
}
