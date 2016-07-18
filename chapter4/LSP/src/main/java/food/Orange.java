package food;

import java.util.Calendar;

/**
 * Model of orange.
 * @see Food
 */
public class Orange extends Food {
    public Orange(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
