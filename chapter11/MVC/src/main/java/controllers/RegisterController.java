package controllers;

import dao.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Register a new user to the application.
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
public class RegisterController {

    /**
     * Instance of user repository for adding and getting new user from database.
     */
    @Autowired
    private UserRepository userRepo;

    /**
     * Get register page, if it get query.
     * @return return to the register page.
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "register";
    }

    /**
     * Adding new user to the application.
     * @param user object.
     * @return reference to index page.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        this.userRepo.add(user);
        return "index";
    }
}
