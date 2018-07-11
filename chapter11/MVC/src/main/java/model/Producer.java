package model;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Producer of the car such as audi, bmw or lada.
 */
@NoArgsConstructor
@Entity @Table(name = "producer")
public class Producer extends CarDetail {
}
