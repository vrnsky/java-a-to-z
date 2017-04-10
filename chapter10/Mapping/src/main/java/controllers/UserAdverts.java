package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Advert;
import model.User;
import repos.AdvertRepo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 30.03.2017
 *
 * This controller ask repo about adverts created by user.
 * User object gets from session. Which at this moment must exist and contains user object as attribute.
 */
@WebServlet("/useradverts")
public class UserAdverts extends HttpServlet {


    /**
     * Return list of adverts which created by the current user.
     * @param req from client to server.
     * @param resp from server to client.
     * @throws ServletException if request could not be handled.
     * @throws IOException if i/o error detected.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Advert> adverts = AdvertRepo.getInstance().getAdvertsByUserId(user.getId());
        writer.append(mapper.writeValueAsString(adverts));
        writer.flush();

    }
}
