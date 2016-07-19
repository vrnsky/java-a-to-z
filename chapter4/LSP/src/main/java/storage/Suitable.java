package storage;

import food.Food;

/**
 * Interface which say that product is suitable for concrete storage
 */
public interface Suitable {

    boolean isSuitable(Food food);
}
