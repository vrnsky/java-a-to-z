package food;

import org.joda.time.DateTime;

/**
 * Model of grape.
 * @see Food
 */
public class Grapes extends Food {

    public Grapes(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
