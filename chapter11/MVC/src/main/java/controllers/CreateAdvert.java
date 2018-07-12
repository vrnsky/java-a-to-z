package controllers;

import dao.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Creating a new advert in the system.
 *
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
     * Create a new advert.
     * @param title of advert.
     * @param producer of the car.
     * @param model of the car.
     * @param body of the car.
     * @param color of the car.
     * @param gearbox of the car.
     * @param price in dollars.
     * @return to the index page.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addAdvert(@RequestParam String title, @RequestParam String producer,
                            @RequestParam String model, @RequestParam String body, @RequestParam String color,
                            @RequestParam String gearbox, @RequestParam String price) {
        carRepo.getCarByParameters(Integer.valueOf(producer), Integer.valueOf(model), Integer.valueOf(body), Integer.valueOf(gearbox),
                Integer.valueOf(color));
        return "index";
    }


}
