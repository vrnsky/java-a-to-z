package storage;

import food.Food;
import food.ReproductFood;

/**
 *
 */
public class ReproductWarehouse extends Storage {

    /**
     * It is temp at the warehouse. This warehouse need a special condition for save food.
     */
    protected int temperature;

    /**
     * Create a new reproduct warehouse with given capacity.
     * @param capacity count of food in warehouse.
     */
    public ReproductWarehouse(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor.
     */
    public ReproductWarehouse() {
        this(100);
    }

    /**
     * Check that food suitable for this adding to reproduct storage.
     * @param food instance of food which will check.
     * @return true if food suitable for warehouse, otherwise false
     */
    public boolean isSuitable(Food food) {
        ReproductFood reproductFood =  (ReproductFood)food;
        return reproductFood.getRecovery() && this.temperature < 25;
    }

    /**
     * Return info about content in warehouse.
     * @return info about food at the warehouse.
     */
    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the reproduct warehouse: \n" + this.buffer.toString();
    }

    /**
     * Set a new temperature at the warehouse.
     * @param temperature new value of temperature at the warehouse.
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Return current value of temperature at the warehouse.
     * @return value of temperature.
     */
    public int getTemperature() {
        return this.temperature;
    }
}
