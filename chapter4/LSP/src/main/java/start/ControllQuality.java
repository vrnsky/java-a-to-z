package start;

import food.Food;
import storage.Shop;
import storage.Trash;
import storage.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Controller for products. It moving food between trash, shop and warehouse. Also this set discount for product.
 */
public class ControllQuality {

    /**
     * Millisecond in one day.
     */
    private static final int TIME_IN_DAY = 1000 * 3600 * 24;

    /**
     * Instance of shop.
     */
    private Shop shop;
    /**
     * Instance of warehouse.
     */
    private Warehouse warehouse;

    /**
     * Instance of trash.
     */
    private Trash trash;

    /**
     * Create a new controller.
     */
    public ControllQuality() {
        this.shop = new Shop();
        this.warehouse = new Warehouse();
        this.trash = new Trash();
    }




    /**
     * Move food to trash or shop or warehouse.
     * @param food product for moving.
     */
    public void moveFood(Food food) {
        int percent = food.calculateFitness();
        if(percent < 25) {
            warehouse.addFood(food);
        } else if (percent > 25 && percent < 75) {
            shop.addFood(food);
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(20);
            shop.addFood(food);
        } else {
            trash.addFood(food);
        }
    }

    /**
     * Get instance of warehouse.
     * @return warehouse object.
     */
    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    /**
     * Get instance of shop.
     * @return shop object.
     */
    public Shop getShop() {
        return this.shop;
    }

    /**
     * Get instance of trash.
     * @return trash object.
     */
    public Trash getTrash() {
        return this.trash;
    }

}
