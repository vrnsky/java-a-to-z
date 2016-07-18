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
     * Calculate how per cent product is old.
     * @param food product for calculation.
     * @return percent of product fitness.
     */
    private int calculateFitness(Food food) {
        Calendar calendar = food.getExpairDate();
        calendar.set(Calendar.HOUR,23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Calendar today = new GregorianCalendar();
        today.set(Calendar.HOUR, 23);
        today.set(Calendar.MINUTE,59);
        today.set(Calendar.SECOND, 59);

        long productLife = (calendar.getTimeInMillis() - food.getCreateTime().getTimeInMillis()) / TIME_IN_DAY;
        long productToday = (today.getTimeInMillis() - food.getCreateTime().getTimeInMillis()) / TIME_IN_DAY;
        long percent = (productToday * 100) / productLife;
        return (int)percent;
    }

    /**
     * Move food to trash or shop or warehouse.
     * @param food product for moving.
     */
    public void moveFood(Food food) {
        int percent = calculateFitness(food);
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
