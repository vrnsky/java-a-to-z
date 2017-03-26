package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
 * This servlet provide index page context.
 */
@WebServlet("/index")
public class Index extends HttpServlet {

    /**
     * Return to client list of all task, but by set only done parameter return only done task.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request for POST not could handled.
     * @throws IOException if an input or output error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String onlyDone = req.getParameter("onlydone");
        boolean sortTask =  false;
        if (onlyDone != null) {
            sortTask = Boolean.valueOf(onlyDone);
        }
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        writer.append(mapper.writeValueAsString(ItemRepository.getInstance().getAll(sortTask)));
        writer.flush();
    }
}
