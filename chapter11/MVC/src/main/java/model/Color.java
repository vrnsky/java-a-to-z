package model;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Color of the car.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
@Entity @Table(name = "color")
public class Color extends CarDetail {
}
