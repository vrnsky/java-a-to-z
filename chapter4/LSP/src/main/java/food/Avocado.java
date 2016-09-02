package food;

import org.joda.time.DateTime;

/**
 * Model of avocado fruit.
 * @see Food
 */
public class Avocado extends Food {

    public Avocado(String name, DateTime createTime, DateTime expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
