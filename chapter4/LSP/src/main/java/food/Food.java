package food;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Model of food.
 */
public class Food {

    /**
     * Name of model.
     */
    private String name;

    /**
     * Time when was added.
     */
    private Calendar createTime;

    /**
     * Time when product will destroy.
     */
    private Calendar expairDate;

    /**
     * Price for product.
     */
    private double price;
    /**
     * Discount for product.
     */
    private int discount;

    /**
     * Helper object for more comfortable works with date.
     */
    private SimpleDateFormat dateFormat;

    /**
     * Create a new food model.
     * @param name of model.
     * @param createTime time when was added.
     * @param expairDate time when product will destroy.
     * @param price for this model of food.
     * @param discount for this model of food.
     */
    public Food(String name, Calendar createTime, Calendar expairDate, double price, int discount) {
        this.name = name;
        this.createTime = createTime;
        this.expairDate = expairDate;
        this.price = price;
        this.discount = discount;
        this.dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    }

    /**
     * Get a name of food model.
     * @return name of model.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get time when model was added.
     * @return creating time.
     */
    public Calendar getCreateTime() {
        return this.createTime;
    }

    /**
     * Get a time of destroying model.
     * @return time when product will destroy.
     */
    public Calendar getExpairDate() {
        return this.expairDate;
    }

    /**
     * Get a price for food.
     * @return price for model food.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get discount for this model.
     * @return
     */
    public int getDiscount() {
        return this.discount;
    }

    /**
     * Set a new discount.
     * @param discount size of new discount.
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Collect info about this model and return it.
     * @return info about this model.
     */
    @Override
    public String toString() {
        return String.format("Name:%s\nWas added: %s\nExpair date: %s\nPrice: %s\nDiscount: %s",this.name, getStringViewOfTime(this.createTime),
                            getStringViewOfTime(this.expairDate), this.price, this.discount);
    }

    /**
     * Return more comfortable date string.
     * @param calendar instance of calendar class.
     * @return string in format dd.MM.yyyy.
     */
    public String getStringViewOfTime(Calendar calendar) {
        dateFormat.setCalendar(calendar);
        return dateFormat.format(calendar.getTime());
    }

}
