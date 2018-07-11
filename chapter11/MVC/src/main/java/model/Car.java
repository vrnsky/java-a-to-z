package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Implementation of car in real life.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor @Data
@Entity @Table(name = "car")
public class Car {

    /**
     * Unique per all cars number.
     */
    @Id
    private int id;

    /***
     * Body of the car.
     */
    @ManyToOne(targetEntity = Body.class)
    private CarDetail body;

    /**
     * Color of the car.
     */
    @ManyToOne(targetEntity = Color.class)
    private CarDetail color;

    /**
     * Gearbox of the car such as mechanic or automat.
     */
    @ManyToOne(targetEntity = Gearbox.class)
    private CarDetail gearbox;

    /**
     * Producer such audi, bmw or another.
     */
    @ManyToOne(targetEntity = Producer.class)
    private CarDetail producer;

    /**
     * Model of the car such as a4, x4 or granta.
     */
    @ManyToOne(targetEntity = Model.class)
    private CarDetail model;


}
