package food;

import java.util.Calendar;

/**
 * Model of grape.
 * @see Food
 */
public class Grapes extends Food {

    public Grapes(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
