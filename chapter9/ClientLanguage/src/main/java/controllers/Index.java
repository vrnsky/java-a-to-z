package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserRepository;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.03.2017
 */
@WebServlet("/index")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = UserRepository.getInstance().getAllUsers();
        writer.append(mapper.writeValueAsString(users));
        writer.flush();
    }
}
