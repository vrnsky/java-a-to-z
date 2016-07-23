package storage;

import food.Food;
import food.ReproductFood;

/**
 * Model for storage.
 */
abstract public class Storage implements Suitable {

    /**
     * All product hold at this array.
     */
    private Food[] foods;

    private ReproductFood[] reproductFoods;
    /**
     * It uses for correct adding new food.
     */
    private int foodPosition = 0;

    /**
     * It uses for correct adding new reproductable food.
     */
    private int reproductPosition = 0;

    /**
     * It uses for collect data and return it to user.
     */
    protected StringBuffer buffer;

    /**
     * Create a new storage with given capacity.
     * @param capacity count of products which may hold storage.
     */
    public Storage(int capacity) {
        this.foods = new Food[capacity];
        this.reproductFoods = new ReproductFood[capacity];
        buffer = new StringBuffer();
    }

    /**
     * Default constructor.
     */
    public Storage() {
        this(100);
    }


    /**
     * Add new food to the food array.
     * @param food child of Food class.
     */
    public void addFood(Food food) {
        if(this.isSuitable(food)) {
            this.foods[foodPosition++] = food;
        }
    }

    /**
     * Add a new reproduct food to this storage.
     * @param food model of reproduct food.
     */
    public void addFood(ReproductFood food) {
        if(this.isSuitable(food)) {
            this.reproductFoods[reproductPosition++] = food;
        }
    }


    /**
     * Check that food suitable for storage.
     * @param food model of food which will check
     * @return true if food suitable for this storage.
     */
    public boolean isSuitable(Food food) {
        return food.calculateFitness() < 100;
    }

    /**
     * Check that reproduct food suitable for this check
     * @param food model of food which will check.
     * @return true if food suitable for this storage.
     */
    public boolean isSuitable(ReproductFood food) { return food.calculateFitness() < 100;};
    /**
     * Collect info about product at the storage.
     */
    protected void fillInfo() {
        buffer.setLength(0);
        for(Food food : foods) {
            if(food != null) {
                buffer.append(food.toString());
            }
        }
    }

    protected void fillInfoAboutRecovery() {
        buffer.setLength(0);
        for(ReproductFood food : reproductFoods) {
            if(food != null) {
                buffer.append(food.toString());
            }
        }
    }

}
