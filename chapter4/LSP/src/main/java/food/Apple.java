package food;

import java.util.Calendar;

/**
 * Model of apple.
 * @see Food
 */
public class Apple extends Food {

    public Apple(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
