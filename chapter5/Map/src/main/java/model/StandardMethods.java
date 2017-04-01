package model;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Check of putting.
 */
public class StandardMethods {

    /**
     * App start.
     * @param args keys.
     */
    public static void main(String[] args) {
        new StandardMethods().start();
    }

    /**
     * Main program.
     */
    private void start() {
        User yegor = new User("Yegor", 0, new GregorianCalendar(1996, 10, 1));
        User people = new User("Yegor", 0, new GregorianCalendar(1996, 10, 1));

        Map<User, String> map = new HashMap<>();
        map.put(yegor, "first");
        map.put(people, "second");

        System.out.println(map);
    }
}
