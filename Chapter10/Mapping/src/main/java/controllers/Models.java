package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky(vrnsky on the protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 */
@WebServlet("/models")
public class Models extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String producer = req.getParameter("producer");
        List<Car> models = new ArrayList<>(); /* CarRepository.getInstance().getCarsByProducer(String producerName)) */
        writer.append(mapper.writeValueAsString(models));
        writer.flush();

    }
}
