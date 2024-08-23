package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Model of the car such as a4, q7, granta.
 */
@NoArgsConstructor @Entity
@Table(name = "model")
public class Model extends CarDetail {
}
