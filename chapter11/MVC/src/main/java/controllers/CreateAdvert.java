package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Creating a new advert in the system.
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
public class CreateAdvert {

    /**
     * If user ask about only page let show it.
     * @return reference to the create advert page.
     */
    @RequestMapping(value = "/createadvert", method = RequestMethod.GET)
    public String getAddingPage() {
        return "createAdvert";
    }


}
