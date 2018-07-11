package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Index page of the site.
 */
@Controller
public class IndexController {

    /**
     * Redirect user to the index page of site.
     * @return reference to the index page.
     */
    @GetMapping
    public String index() {
        return "index";
    }
}
