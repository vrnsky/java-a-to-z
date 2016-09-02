package food;

import org.joda.time.DateTime;

/**
 * Model of pear.
 * @see Food
 */
public class Pear extends Food {
    public Pear(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
