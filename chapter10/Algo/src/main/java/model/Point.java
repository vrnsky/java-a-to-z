package model;

/**
 * @author evrnsky.
 * @version 0.1
 * @since 19.04.2017
 */
public class Point {

    /**
     * x coordinate.
     */
    private int x;

    /**
     * y coordinate.
     */
    private int y;


    /**
     * Constructor of point.
     * @param x of coordinate.
     * @param y of coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
     * Return string representation of point.
     * @return string representation of number.
     */
    @Override
    public String toString() {
        return String.format("X:%s, Y:%s", this.x, this.y);
    }
}
