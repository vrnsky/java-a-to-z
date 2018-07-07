package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is hello controller. It get from user request name and return page which greeting user.
 * @author vrnsky.
 * @version 0.1
 */
@Controller
public class HelloController {

    /**
     * It is method which get data from user such as name, and put to Spring model.
     * @param name data from user.
     * @param model Spring object which hold attribute.
     * @return string representation of view.
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "world", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
