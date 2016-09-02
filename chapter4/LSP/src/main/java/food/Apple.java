package food;

import org.joda.time.DateTime;

/**
 * Model of apple.
 * @see Food
 */
public class Apple extends Food {

    public Apple(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
