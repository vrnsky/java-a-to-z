package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represent advert in real world.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
public class Advert {

    /**
     * Unique per user id.
     */
    @Getter @Setter
    private int id;

    /**
     * Title of avert such as "sell dream car".
     */
    @Getter @Setter
    private String title;

}
