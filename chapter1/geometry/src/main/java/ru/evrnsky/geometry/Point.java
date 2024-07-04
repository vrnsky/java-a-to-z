package ru.evrnsky.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Representation of point in Decart coordinate system.
 */
public class Point {

    /**
     * Coordinate by x axis.
     */
    private double x;

    /**
     * Coordinate by y axis.
     */
    private double y;

    /**
     * Construct new point at the given coordinates.
     * @param px coordinate by x axis.
     * @param py coordinate by y axis.
     */
    public Point(double px, double py) {
        this.x = px;
        this.y = py;
    }

    /**
     * Calculate distance between two points.
     * @param point finish point for computing.
     * @return distance between this point and transmitted point.
     */
    public double distanceTo(Point point) {
        return abs(sqrt(pow(point.x - this.x, 2.0) + pow(point.y - this.y, 2.0)));
    }

    /**
     * Return x of this point.
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Return y of this point.
     * @return y.
     */
    public double getY() {
        return y;
    }
}