package model;

import java.util.List;

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
     * First point.
     */
    private Point one;

    /**
     * Second point.
     */
    private Point two;

    /**
     * Third point.
     */
    private Point three;

    /**
     * Four point.
     */
    private Point four;

    /**
     * Create a new sorter.
     * @param points instance of list of point.
     */
    public Sorter(List<Point> points) {
        this.points = points;
        this.one = points.get(0);
        this.two = points.get(1);
        this.three = points.get(2);
        this.four = points.get(3);
    }

    /**
     * Return sorted points.
     * @return list of sorted points.
     */
    public List<Point> getSortedPoints() {
        if (orientationOf(one, two, three) < 0) {
            if (orientationOf(one, three, four) < 0) {
                return this.points;
            } else if (orientationOf(one, two, four) < 0) {
                swap(3, 2);
            } else {
                swap(0, 3);
            }
        } else if (orientationOf(one, three, four) < 0) {
            if (orientationOf(one, two, four) < 0) {
                swap(1, 2);
            } else {
                swap(0, 1);
            }
        } else {
            swap(0, 2);
        }
        return this.points;
    }

    /**
     * Calculate that three points counter clockwise and if it is return negative value.
     * @param one of the point.
     * @param two of the point.
     * @param three of the point.
     * @return negative value if that points counter clockwise, positive if point already clockwise.
     */
    private int orientationOf(Point one, Point two, Point three) {
        return gaussSquare(one, two) + gaussSquare(two, three) + gaussSquare(three, one);
    }

    /**
     * Return gauss square.
     * @param one of the point.
     * @param two of the point.
     * @return gauss square.
     */
    private int gaussSquare(Point one, Point two) {
        return one.getX() * two.getY() - one.getY() * two.getX();
    }

    /**
     * Swap points at the list.
     * @param one index of first point.
     * @param two index of second point.
     */
    private void swap(int one, int two) {
        Point tmp = this.points.get(one);
        this.points.set(one, this.points.get(two));
        this.points.set(two, tmp);

    }
}
