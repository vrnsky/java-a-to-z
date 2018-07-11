package model;


import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Gearbox of the car.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
@Entity @Table(name = "gearbox")
public class Gearbox extends CarDetail {
}
