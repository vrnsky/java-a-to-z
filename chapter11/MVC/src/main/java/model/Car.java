package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Implementation of car in real life.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
public class Car {

    /***
     * Body of the car.
     */
    @Getter @Setter
    private CarDetail body;

    /**
     * Color of the car.
     */
    @Getter @Setter
    private CarDetail color;

    /**
     * Gearbox of the car such as mechanic or automat.
     */
    @Getter @Setter
    private CarDetail gearbox;

    /**
     * Producer such audi, bmw or another.
     */
    @Getter @Setter
    private CarDetail producer;

    /**
     * Model of the car such as a4, x4 or granta.
     */
    @Getter @Setter
    private CarDetail model;


}
