package controllers;

import dao.ExtendedRepo;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.02.2017
 *
 * This is main page of app.
 */
@WebServlet("/")
public class UserTable extends HttpServlet {


    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(UserTable.class);

    /**
     * Forward user to the main page of app.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = ExtendedRepo.getInstance().getAllUsers();
        log.info("{} users loaded", users.size());
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}
