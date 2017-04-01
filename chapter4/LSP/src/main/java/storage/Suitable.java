package storage;

import food.Food;

/**
 * Interface which say that product is suitable for concrete storage.
 */
public interface Suitable {

    /**
     * Define suitable for food current storage implementation.
     * @param food instance of food class.
     * @return true if suitable, otherwise false.
     */
    boolean isSuitable(Food food);
}
