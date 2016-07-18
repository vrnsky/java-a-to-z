package storage;

import food.Food;

/**
 * Created by Egor on 18.07.2016.
 */
public class Storage {

    private Food[] foods;
    private int position = 0;
    protected StringBuffer buffer;

    public Storage(int capacity) {
        this.foods = new Food[capacity];
        buffer = new StringBuffer();
    }

    public Storage() {
        this(100);
    }

    public void addFood(Food food) {
        this.foods[position++] = food;
    }

    protected void fillInfo() {
        buffer.setLength(0);
        for(Food food : foods) {
            if(food != null) {
                buffer.append(food.toString());
            }
        }
    }

}
