package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represent advert in real world.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
public class Advert {

    /**
     * Unique per user id.
     */
    @Getter @Setter
    private int id;

    /**
     * Title of avert such as "sell dream car".
     */
    @Getter @Setter
    private String title;

    /**
     * Car for selling.
     */
    @Getter @Setter
    private Car sellCar;

    /**
     * Cost of car.
     */
    @Getter @Setter
    private double price;

    /***
     * Author of this advert.
     */
    @Getter @Setter
    private User author;

}
