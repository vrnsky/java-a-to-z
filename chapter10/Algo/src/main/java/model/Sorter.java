package model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author evrnsky.
 * @version 0.1
 * @since 19.04.2017
 */
public class Sorter {

    /**
     * List of all point which need sorting.
     */
    private List<Point> points;

    /**
     * Create a new sorter.
     * @param points instance of list of point.
     */
    public Sorter(List<Point> points) {
        this.points = points;
    }

    /**
     * Return already sorted version of list.
     * @return set of sorted list.
     */
    public Set<Point> getSortedPoints() {
       return new TreeSet<>(points);
    }
}
