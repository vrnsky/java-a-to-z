package food;

import org.joda.time.DateTime;

/**
 * Model of avocado fruit.
 * @see Food
 */
public class Avocado extends Food {

    /**
     * Create a new food.
     * @param name @{inherit docs}.
     * @param createTime @{inherit docs}.
     * @param expairDate @{inherit docs}.
     * @param price @{inherit docs}.
     * @param discount @{inherit docs}.
     */
    public Avocado(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
