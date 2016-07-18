package food;

import java.util.Calendar;

/**
 * Model of pear.
 * @see Food
 */
public class Pear extends Food {
    public Pear(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
