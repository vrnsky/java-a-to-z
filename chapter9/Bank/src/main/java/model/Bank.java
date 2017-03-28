package model;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;


/**
 * @author evrnsky
 * @version 0.1
 * @since 22.03.2017
 *
 * This is model of bank, provide init and calculate functions.
 */
public class Bank {

    /**
     * One hour in milliseconds.
     */
    private static final long HOUR = 3600 * 1000;

    /**
     * Current date.
     */
    private static final LocalDateTime NOW = new LocalDateTime();

    /**
     * Current date with set hour to the 8 a.m.
     */
    private static final DateTime START = new DateTime(NOW.getYear(), NOW.getMonthOfYear(), NOW.getDayOfMonth(), 8, 0, 0, 0);

    /**
     * Current date with set hour to the 20 p.m.
     */
    private static final DateTime FINISH = new DateTime(NOW.getYear(), NOW.getMonthOfYear(), NOW.getDayOfMonth(), 20, 0, 0, 0);

    /**
     * List of client.
     */
    private List<Client> clients;

    /**
     * Create a new bank with from list of visitors.
     * @param clients list of clients.
     */
    public Bank(List<Client> clients) {
        this.clients = new ArrayList<>();
        this.clients.addAll(clients);
    }

    /**
     * Calculate in which time every client was at the bank.
     * @return map with time and count of clients.
     */
    public Map<String, List<Client>> calculate() {
        Map<String, List<Client>> map = this.getMap();
        long startLong = START.getMillis();
        long finishLong = FINISH.getMillis();
        for (long hour = startLong; hour < finishLong; hour += HOUR) {
            String key = String.format("%s - %s", new DateTime(hour).getHourOfDay(), new DateTime(hour + HOUR).getHourOfDay());
            for (Client client : this.clients) {
                if (arriveAt(client, hour) && leftAt(client, hour)) {
                    map.get(key).add(client);
                } else if (arriveAt(client, hour) && !leftAt(client, hour)) {
                    long hourCopy = hour;
                    while (hourCopy < client.getTimeOut()) {
                        String anotherKey = String.format("%s - %s", new DateTime(hourCopy).getHourOfDay(), new DateTime(hourCopy + HOUR).getHourOfDay());
                        map.get(anotherKey).add(client);
                        hourCopy += HOUR;
                    }
                }
            }
        }
        return map;
    }

    /**
     * Return true if client arrive at bank between given hour and next hour.
     * @param client instance of client class.
     * @param time start hour.
     * @return true if client arrive at given hour and next hour, otherwise false.
     */
    private boolean arriveAt(Client client, long time) {
        return new Interval(new DateTime(time), new DateTime(time + HOUR)).contains(client.getTimeIn());
    }

    /**
     * Return true if client has left bank between given hour and next hour.
     * @param client instance of client class.
     * @param time start hour.
     * @return true if client has left bank between hour and next hour.
     */
    private boolean leftAt(Client client, long time) {
        return new Interval(new DateTime(time), new DateTime(time + HOUR)).contains(client.getTimeOut());
    }

    /**
     * Fill map by hour and new list.
     * @return map filled by hours and lists.
     */
    private Map<String, List<Client>> getMap() {
        Map<String, List<Client>> map = new LinkedHashMap<>();
        for (long hour = START.getMillis(); hour < FINISH.getMillis(); hour += HOUR) {
            String key = String.format("%s - %s", new DateTime(hour).getHourOfDay(), new DateTime(hour + HOUR).getHourOfDay());
            map.put(key, new ArrayList<>());
        }
        return map;
    }
}
