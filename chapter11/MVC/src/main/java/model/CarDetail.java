package model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Car detail allow us to describe any detail of car.
 *
 * @author vrnsky.
 * @version 0.1
 */
@NoArgsConstructor @MappedSuperclass @Data
public abstract class CarDetail {

    /**
     * Unique per detail number.
     */
    @Id
    @Column(name = "id")
    protected int id;

    /**
     * Description of the detail.
     */
    @Column(name = "name")
    protected String desc;
}
