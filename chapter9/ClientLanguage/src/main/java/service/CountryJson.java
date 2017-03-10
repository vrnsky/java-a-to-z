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
@WebServlet("/country")
public class CountryJson extends HttpServlet {


    /**
     * adasds.
     * @param req ad.
     * @param resp ad.
     * @throws ServletException ad.
     * @throws IOException ad.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        List<String> countries = GeoRepository.getInstance().getCountries();
        writer.append(mapper.writeValueAsString(countries));
        writer.flush();
    }



}
