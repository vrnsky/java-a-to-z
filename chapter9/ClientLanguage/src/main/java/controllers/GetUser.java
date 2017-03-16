package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This servlet return user by id.
 */
@WebServlet("/getuser")
public class GetUser extends HttpServlet {

    /**
     * Return user as json string.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with data concurrency.
     * @throws IOException if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.valueOf(req.getParameter("id"));
        writer.append(mapper.writeValueAsString(UserRepository.getInstance().getUserById(id)));
        writer.flush();
    }
}
