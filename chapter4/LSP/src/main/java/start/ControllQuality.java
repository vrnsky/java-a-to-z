package start;

import food.Food;
import storage.Storage;
/**
 * Controller for products. It moving food between trash, shop and warehouse. Also this set discount for product.
 */
public class ControllQuality {

    /**
     * May hold all various of storage such as trash, shop and warehouse.
     */
    private Storage[] storages;

    /**
     * It uses for determine correct position of new storage in storages array.
     */
    private int position = 0;

    /**
     * Create a new controller.
     * @param capacity of storages.
     */
    public ControllQuality(int capacity) {
        this.storages = new Storage[capacity];
    }

    /**
     * Default constructor.
     */
    public ControllQuality() {
        this(100);
    }

    /**
     * Add a new storage to controller.
     * @param storage instance of storage class.
     */
    public void addStorage(Storage storage) {
        storages[position++] = storage;
    }

    /**
     * Return storage at the index position.
     * @param index position of storage.
     * @return storage at the index position in storages array.
     */
    public Storage getStorage(int index) {
        return storages[index];
    }



    /**
     * Move food to trash or shop or warehouse.
     * @param food product for moving.
     */
    public void moveFood(Food food) {
        for (int index = 0; index < storages.length; index++) {
            if (storages[index] != null) {
                if (storages[index].isSuitable(food)) {
                    storages[index].addFood(food);
                    break;
                }

            }
        }
    }
}
