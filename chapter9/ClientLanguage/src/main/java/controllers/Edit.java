package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserRepository;
import model.Address;
import model.User;
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
 * @since 15.03.2017
 * <p>
 * This servlet provide edit function.
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {


    /**
     * When user only ask a page for edit should get it.
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(UserRepository.getInstance().getAllUsers()));
        writer.flush();
    }


    /**
     * Process data from form and edit user at the database.
     * @param req  from client to server.
     * @param resp from server to client.
     * @throws ServletException if problem with concurrency.
     * @throws IOException      if problem with data exchange.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String cvFile = UserRepository.getInstance().getUserById(id).getCvFileLink();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        UserRepository.getInstance().editUser(new User(id, email, password, cvFile, new Address(country, city)));
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}
