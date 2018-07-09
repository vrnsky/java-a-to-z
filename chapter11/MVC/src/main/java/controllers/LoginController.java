package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Sign in controller, allow user to sign in system.
 * @author vrnsky.
 * @version 0.1.
 *
 */
@Controller
public class LoginController {

    /**
     * Instance of user repository.
     */
    @Autowired
    private UserRepository userRepo;


    /**
     * When user ask about get only page, without sending form.
     * @return redirect to login page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    /**
     * Get data from client side where user input data in form field.
     * @param email user data.
     * @param password user data.
     * @param modelMap for store user object.
     * @return redirect to the index page of site.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
        User user = this.userRepo.getUser(email, password);
        if (user == null) {
            modelMap.addAttribute("error", "User with given credentials not exist");
        } else {
            modelMap.addAttribute("user", user);
        }
        return "index";
    }
}
