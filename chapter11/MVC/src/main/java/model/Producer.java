package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


/**
 * Producer of the car such as audi, bmw or lada.
 */
@NoArgsConstructor
@Entity
@Table(name = "producer")
public class Producer extends CarDetail {
}
