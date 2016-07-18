package food;

import java.util.Calendar;

/**
 * Model of fruit cherry.
 * @see Food
 */
public class Cherry extends Food {

    public Cherry(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
