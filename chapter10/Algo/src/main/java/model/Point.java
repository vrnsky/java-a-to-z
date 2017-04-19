package model;

/**
 * @author evrnsky.
 * @version 0.1
 * @since 19.04.2017
 */
public class Point implements Comparable<Point> {

    /**
     * x coordinate.
     */
    private int x;

    /**
     * y coordinate.
     */
    private int y;

    /**
     * Unique per point sorting key.
     */
    private int sortKey;

    /**
     * Constructor of point.
     * @param x of coordinate.
     * @param y of coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.sortKey = 10000 * x + y * 100;
    }

    /**
     * Return x of this point.
     * @return x of this point.
     */
    public int getX() {
        return x;
    }

    /**
     * Return y of this point.
     * @return y of this point.
     */
    public int getY() {
        return y;
    }

    /**
     * Describe how to compare two points.
     * @param o instance of other point for checking.
     * @return 0 if object are equals, 1 if this greater that other, and -1 if this less that given point.
     */
    @Override
    public int compareTo(Point o) {
        int result = -1;
        if (this.sortKey > o.sortKey) {
            result = 1;
        } else if (this.sortKey == o.sortKey) {
            result = 0;
        } else if (this.sortKey < o.sortKey) {
            result = -1;
        }

        return result;
    }

    /**
     * Return string representation of point.
     * @return string representation of number.
     */
    @Override
    public String toString() {
        return String.format("X:%s, Y:%s", this.x, this.y);
    }
}
