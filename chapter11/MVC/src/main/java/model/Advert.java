package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Represent advert in real world.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor @Data
public class Advert {

    /**
     * Unique per user id.
     */

    private int id;

    /**
     * Title of avert such as "sell dream car".
     */
    private String title;

    /**
     * Car for selling.
     */
     private Car sellCar;

    /***
     * Author of this advert.
     */
    private User author;

    /**
     * Create a new advert with given car.
     * @param car instance of car class.
     */
    @Autowired
    public Advert(Car car) {
        this.sellCar = car;
    }

}
