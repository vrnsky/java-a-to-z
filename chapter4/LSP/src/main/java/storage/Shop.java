package storage;

import food.Food;

/**
 * Created by Egor on 18.07.2016.
 */
public class Shop extends Storage {

    public Shop(int capacity) {
        super(capacity);
    }

    public Shop() {
        this(100);
    }

    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the shop:\n" + this.buffer.toString();
    }
}
