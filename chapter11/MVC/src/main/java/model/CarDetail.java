package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Car detail allow us to describe any detail of car.
 * @author vrnsky.
 * @version 0.1
 */
@NoArgsConstructor
public abstract class CarDetail {

    /**
     * Unique per detail number.
     */
    @Getter @Setter
    private int id;

    /**
     * Description of the detail.
     */
    @Getter @Setter
    private String desc;
}
