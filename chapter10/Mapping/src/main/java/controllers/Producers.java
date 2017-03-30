package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.CarInfo;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import repos.CarRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 30.03.2017
 */

@WebServlet("/producers")
public class Producers extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Producers.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        List<CarInfo> producers = CarRepo.getInstance().getAllProducers();
        LOG.log(Level.INFO, String.format("System load %s producers from database", producers.size()));
        writer.append(mapper.writeValueAsString(producers));
        writer.flush();
    }
}

