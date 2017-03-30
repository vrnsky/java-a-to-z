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

@WebServlet("/models")
public class Models extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String producer = req.getParameter("producer");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String models = mapper.writeValueAsString(CarRepo.getInstance().getModelsByProducer(producer));
        writer.append(models);
        writer.flush();
    }
}

