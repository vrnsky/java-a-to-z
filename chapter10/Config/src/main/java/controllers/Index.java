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
 */
@WebServlet("/index")
public class Index extends HttpServlet {

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
