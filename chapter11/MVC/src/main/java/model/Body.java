package model;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

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
