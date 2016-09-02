package food;

import org.joda.time.DateTime;

/**
 * Model of fruit cherry.
 * @see Food
 */
public class Cherry extends Food {

    public Cherry(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
