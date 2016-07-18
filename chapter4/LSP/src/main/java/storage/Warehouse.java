package storage;

import food.Food;

/**
 * Created by Egor on 18.07.2016.
 */
public class Warehouse extends Storage {

    public Warehouse(int capacity) {
        super(capacity);
    }

    public Warehouse() {
        this(100);
    }

    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the warehouse:\n" + this.buffer.toString();
    }

}
