package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Body car representation.
 *
 * @author vrnsky.
 * @version 0.1.
 */
@Entity
@Table(name = "body")
@NoArgsConstructor
public class Body extends CarDetail {

}
