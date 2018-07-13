package controllers;

import dao.CarRepository;
import model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Creating a new advert in the system.
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
@RequestMapping(value = "/createadvert")
public class CreateAdvert {


    /**
     * Car repository which allow to add new car to the database.
     */
    @Autowired
    private CarRepository carRepo;

    /**
     * If user ask about only page let show it.
     * @return reference to the create advert page.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAddingPage() {
        return "createAdvert";
    }


    /**
     * Post a new advert to the system.
     * @param advert instance of advert class.
     * @return user to the index page.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String postAdvert(@ModelAttribute Advert advert) {
        System.out.println(advert.getTitle());
        System.out.println(advert.getSellCar().getColor()); //FIXME when user try to create advert
        return "index";
    }

}
