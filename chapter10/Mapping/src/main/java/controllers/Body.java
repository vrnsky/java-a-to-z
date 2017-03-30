package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import repos.CarRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 30.03.2017
 */
@WebServlet("/body")
public class Body extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(CarRepo.getInstance().getAllBodies()));
        writer.flush();
    }
}
