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
 * Hello, World Servlet.
 */
public class EchoServlet extends HttpServlet {

    /**
     * This method call when user ask about only get page
     * @param req from user.
     * @param resp for user.
     * @throws ServletException if something was wrong with servlet.
     * @throws IOException if something was wrong with writer.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello, World!");
        writer.flush();
    }
}
