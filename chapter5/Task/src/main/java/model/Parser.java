package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 14.09.2016
 * Non standard parsing of xml file. By default xml file valid.
 * Parse add-delete order operation from xml file.
 */
public class Parser {

    /**
     * Keys it is unique string for each order book.
     * Values are combination of order id and order.
     */
    private Map<String, HashMap<Integer, Order>> orders = new HashMap<>();

    /**
     * Load xml string from file to memory and adding to the orders map.
     * @throws IOException if some problem with file.
     * @throws ExecutionException if some problem with thread.
     * @throws InterruptedException if some problem with thread.
     */
    public void load() throws IOException, ExecutionException, InterruptedException {
        try (BufferedReader reader = new BufferedReader(new FileReader("F:\\orders.xml"))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("<A")) {
                    Order order = parse(line, true);
                    HashMap<Integer, Order> list = orders.get(order.getBook());
                    if (list == null) {
                        list = new HashMap<>();
                        orders.put(order.getBook(), list);
                    }
                    list.put(order.getId(), order);
                } else if (line.startsWith("<D")) {
                    Order order = parse(line, false);
                    orders.get(order.getBook()).remove(order.getId());
                }
            }
            Splitter splitter = new Splitter(orders);
            splitter.match();
        }
    }

    /**
     * Parsing xml string from file and create order object.
     * @param line from xml file.
     * @param add flag which mean that order should be add to the map, otherwise remove.
     * @return order object.
     */
    public Order parse(String line, boolean add) {
        String[] values = new String[5];
        int position = -1;
        int current = 0;
        boolean start = false;
        for (int index = 0; index < line.length(); index++) {
            if (line.charAt(index) == '\"') {
                if (start) {
                    values[current++] = line.substring(position + 1, index);
                    start = false;
                } else {
                    start = true;
                }
                position = index;
            }
        }
        Order order = null;
        if (add) {
            order = new Order(values[0], "SELL".equals(values[1]) ? Order.Type.SELL : Order.Type.BUY,
                        Float.parseFloat(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
        } else {
            order = new Order(values[0], Order.Type.BUY, 0f, 0, Integer.parseInt(values[1]));
        }
        return order;
    }

}
