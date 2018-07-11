package model;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Model of the car such as a4, q7, granta.
 */
@NoArgsConstructor @Entity @Table(name = "model")
public class Model extends CarDetail {
}
