package start;

import food.ReproductFood;
import storage.Storage;

/**
 * Controller for reproduct food.
 */
public class ControlQualityReproduct extends ControllQuality {

    /**
     * Move food to reproduct warehouse if food suitable for reproduct warehouse.
     * @param food product for moving.
     */
    public void moveFood(ReproductFood food) {
        for(Storage storage : super.storages) {
            if(storage != null && storage.isSuitable(food)) {
                storage.addFood(food);
            }
        }
    }
}
