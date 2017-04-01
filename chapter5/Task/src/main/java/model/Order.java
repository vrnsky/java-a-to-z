package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 */
public class Order {

    /**
     * Type of operation.
     */
    public enum Type {
        /**
         * Sell operation.
         */
        SELL,
        /**
         * Buy operation.
         */
        BUY
    }

    /**
     * Unique string for each book.
     */
    private String book;

    /**
     * Operation of order.
     */
    private Type operation;

    /**
     * Price for current order.
     */
    private float price;

    /**
     * Volume of ladder.
     */
    private int volume;

    /**
     * Unique number for each order.
     */
    private int id;

    /**
     * Create a new order with given params.
     * @param book unique string for each book.
     * @param operation determine buy or sell.
     * @param price of ladder.
     * @param volume of ladder.
     * @param id unique number for each order.
     */
    public Order(String book, Type operation, float price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     * Compare two objects if object is equals return true, otherwise false.
     * @param o object for comparing.
     * @return true if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this == o) {
            equals = false;
        }
        if (o == null || getClass() != o.getClass()) {
            equals = false;
        }

        Order order = null;
        if (o != null) {
            order = (Order) o;
            equals = id == order.id;
        }

        return equals;

    }

    /**
     * Return id of each order as hashcode.
     * @return id of this order.
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Return book for this order.
     * @return book which contains this order.
     */
    public String getBook() {
        return book;
    }

    /**
     * Id of order.
     * @return id of order.
     */
    public int getId() {
        return id;
    }

    /**
     * Return type of order.
     * @return type of order.
     */
    public Order.Type getType() {
        return this.operation;
    }

    /**
     * Return price for this order.
     * @return price for this order.
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Return volume for this order.
     * @return volume for this order.
     */
    public int getVolume() {
        return this.volume;
    }
}