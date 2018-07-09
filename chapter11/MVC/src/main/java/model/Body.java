package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Body car representation.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
public class Body {

    /**
     * Unique number for this.
     */
    @Getter @Setter
    private int id;

    /**
     * Type of body car such as sedan, hatchbak, crossover, jeep.
     */
    @Getter @Setter
    private String type;
}
