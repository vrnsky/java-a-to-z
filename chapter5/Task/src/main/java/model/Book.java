package model;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.09.2016
 */
public class Book {

    /**
     * Orders.
     */
    private Collection<Order> orders;

    /**
     * Create a new book with given param.
     * @param orders instance of collection interface.
     */
    public Book(Collection<Order> orders) {
        this.orders = orders;
    }

    /**
     * Describe how to compare in ascending order.
     */
    private static final Comparator<Float> ASC = (o1, o2) -> o1.compareTo(o2);

    /**
     * Describe how to compare in descending order.
     */
    private static final Comparator<Float> DESC = (o1,o2) -> o2.compareTo(o1);

    /**
     * Add to sell, buy maps orders. At this place use TreeMap because it contains data
     * at sorted order.
     */
    public void calculate() {
        Map<Float, Order> sell = new TreeMap<Float, Order>(DESC);
        Map<Float, Order> buy = new TreeMap<Float, Order>(ASC);
        for(Order order : orders) {
            this.add(order.getType() == Order.Type.BUY ? buy : sell, order);
        }
        this.show(sell, buy);
    }

    /**
     * If given order already contains at map, price will addition with given order.
     * Otherwise order just add to map.
     * @param map instance of map interface.
     * @param order for adding.
     */
    public void add(Map<Float, Order> map, Order order) {
        Order find = map.get(order.getPrice());
        if(find != null) {
            map.put(find.getPrice(), new Order(find.getBook(), find.getType(), find.getPrice(), find.getVolume() + order.getVolume(), find.getId()));
        } else {
            map.put(order.getPrice(), order);
        }
    }

    /**
     * Showing order book.
     * @param sell map for adding order which sell.
     * @param buy map for adding order which buy.
     */
    public void show(Map<Float, Order> sell, Map<Float, Order> buy) {
        StringBuilder builder = new StringBuilder();
        for(Order order : sell.values()) {
            builder.append(String.format("\t\t%5s %7s\n", order.getPrice(), order.getVolume()));
        }
        for(Order order : buy.values()) {
            builder.append(String.format("%7s %5s\n", order.getVolume(), order.getPrice()));
        }
        System.out.println(builder);
    }
}