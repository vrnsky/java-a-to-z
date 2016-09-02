package food;

import org.joda.time.DateTime;

/**
 * Model of orange.
 * @see Food
 */
public class Orange extends Food {
    public Orange(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
