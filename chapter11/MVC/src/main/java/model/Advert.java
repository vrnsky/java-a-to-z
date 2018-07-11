package model;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    /**
     * Cost of car.
     */
    private double price;

    /***
     * Author of this advert.
     */
    private User author;

}
