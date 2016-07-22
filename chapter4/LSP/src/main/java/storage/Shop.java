package storage;

import food.Food;

/**
 * Model of shop.
 */
public class Shop extends Storage {

    /**
     * Create a new shop with given capacity.
     * @param capacity count of good which may hold shop.
     */
    public Shop(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor.
     */
    public Shop() {
        this(100);
    }

    /**
     * Check that food suitable for the shop
     * @param food model of food which will check
     * @return true if food suitable, otherwise false
     */
    @Override
    public boolean isSuitable(Food food) {
        int percent = food.calculateFitness();
        boolean result = false;
        if(percent > 25 && percent < 75) {
            result = true;
        } else if(percent > 75 && percent < 100) {
            food.setDiscount(20);
            result = true;
        }

        return result;
    }

    /**
     * Show all foods in shop
     * @return string view of all food at the shop.
     */
    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the shop:\n" + this.buffer.toString();
    }
}
