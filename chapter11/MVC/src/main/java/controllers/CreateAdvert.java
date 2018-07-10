package controllers;

import dao.CarRepository;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Creating a new advert in the system.
 *
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
public class CreateAdvert {


    /**
     * Car repository which allow to add new car to the database.
     */
    @Autowired
    private CarRepository carRepo;

    /**
     * If user ask about only page let show it.
     *
     * @return reference to the create advert page.
     */
    @RequestMapping(value = "/createadvert", method = RequestMethod.GET)
    public String getAddingPage() {
        return "createAdvert";
    }


    /**
     * Add a new car to the system.
     * @param car instance of car.
     * @return user to the index page.mvn c
     */
    @RequestMapping(value = "/createadvert", method = RequestMethod.POST)
    public String addAdvert(@ModelAttribute Car car) {
        return "index";
    }


}
