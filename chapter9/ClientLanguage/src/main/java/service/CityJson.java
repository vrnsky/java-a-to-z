package service;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GeoRepository;

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
 * @since 06.03.2017
 */
@WebServlet("/cities")
public class CityJson extends HttpServlet {

    /**
     * asd.
     * @param req asd.
     * @param resp ad.
     * @throws ServletException ad.
     * @throws IOException ad.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String country = req.getParameter("country");
        PrintWriter writer = resp.getWriter();
        List<String> cities = GeoRepository.getInstance().getCities(country);
        writer.append(mapper.writeValueAsString(cities));
        writer.flush();
    }
}
