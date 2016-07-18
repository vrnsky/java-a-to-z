package food;

import java.util.Calendar;

/**
 * Model of avocado fruit.
 * @see Food
 */
public class Avocado extends Food {

    public Avocado(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        super(name, createTime, expairDate, price, discount);
    }
}
