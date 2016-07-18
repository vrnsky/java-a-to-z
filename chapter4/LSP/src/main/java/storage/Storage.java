package storage;

import food.Food;

/**
 * Model for storage.
 */
public class Storage {

    /**
     * All product hold at this array.
     */
    private Food[] foods;
    /**
     * It uses for correct adding new food.
     */
    private int position = 0;

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
        this.foods[position++] = food;
    }

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

}
