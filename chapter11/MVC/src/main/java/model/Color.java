package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


/**
 * Color of the car.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color extends CarDetail {
}
