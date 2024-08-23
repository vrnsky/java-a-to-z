package model;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Car detail allow us to describe any detail of car.
 *
 * @author vrnsky.
 * @version 0.1
 */
@Data
@NoArgsConstructor
@MappedSuperclass
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
