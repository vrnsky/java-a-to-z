package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;
import repository.ItemRepository;

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
 * @since 26.03.2017
 */
@WebServlet("/create")
public class Create extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String description = req.getParameter("desc");
        Item item = new Item(description);
        ItemRepository.getInstance().addItem(item);
        writer.append(mapper.writeValueAsString(item));
        writer.flush();
    }
}
