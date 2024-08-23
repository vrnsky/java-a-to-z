package model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Gearbox of the car.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
@Entity
@Table(name = "gearbox")
public class Gearbox extends CarDetail {
}
