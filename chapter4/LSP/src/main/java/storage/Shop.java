package storage;

/**
 * Model of shop.
 */
public class Shop extends Storage {

    /**
     * Create a new shop with given capacity.
     * @param capacity count of good which may hold shop.
     */
    public Shop(int capacity) {
        super(capacity);
    }

    /**
     * Default constructor.
     */
    public Shop() {
        this(100);
    }

    /**
     * Show all foods in shop
     * @return string view of all food at the shop.
     */
    @Override
    public String toString() {
        super.fillInfo();
        return "At this moment at the shop:\n" + this.buffer.toString();
    }
}
