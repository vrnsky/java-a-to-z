package storage;

import food.Food;

/**
 * Model of warehouse.
 */
public class Warehouse extends Storage {

    /**
     * Create a new warehouse with given capacity
     * @param capacity count of products in warehouse
     */
    public Warehouse(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor.
     */
    public Warehouse() {
        this(100);
    }

    /**
     * Check that food suitable for warehouse
     * @param food model of food which will check
     * @return
     */
    @Override
    public boolean isSuitable(Food food) {
        return food.calculateFitness() < 25;
    }

    /**
     * Collect info and return it.
     * @return info about content at the warehouse.
     */
    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the warehouse:\n" + this.buffer.toString();
    }

}
