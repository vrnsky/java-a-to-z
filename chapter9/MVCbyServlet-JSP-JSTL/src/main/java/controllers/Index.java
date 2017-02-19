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
 * This servlet is index page of app.
 */
@WebServlet("/")
public class Index extends HttpServlet {


    /**
     * When user go to the root of app, this forward req and response to the jsp.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository repo =  Repository.getInstance();
        resp.setContentType("text/html");
        req.setAttribute("users", repo.getAllUsers());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }
}
