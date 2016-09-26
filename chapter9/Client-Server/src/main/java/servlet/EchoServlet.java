package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.09.2016
 * Hello world, Servlet!
 */
public class EchoServlet extends HttpServlet {

    /**
     * This method call each time when user ask about only this servlet.
     * @param req from user.
     * @param resp to user.
     * @throws ServletException if something wrong.
     * @throws IOException if something wrong.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello, World!");
        writer.flush();
    }

}
