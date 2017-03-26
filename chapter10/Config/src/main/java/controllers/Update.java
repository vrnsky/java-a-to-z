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
 *
 * This servlet provide edit function.
 */
@WebServlet("/update")
public class Update extends HttpServlet {

    /**
     * Return item with given id in json string.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for GET could not handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        int id = Integer.valueOf(req.getParameter("id"));
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        writer.append(mapper.writeValueAsString(ItemRepository.getInstance().getById(id)));
        writer.flush();
    }

    /**
     * Collect data from the request and update item.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST could not handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String description = req.getParameter("description");
        boolean done = Boolean.valueOf(req.getParameter("done"));
        Item item = ItemRepository.getInstance().getById(id);
        item.setDesc(description);
        item.setDone(done);
        ItemRepository.getInstance().editItem(item);
    }
}

