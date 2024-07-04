package ru.evrnsky.geometry;

import static java.lang.Math.sqrt;

/**
 * Model of triangle, which made from three points.
 */
public class Triangle {

    /**
     * Point of triangle.
     */
    private Point a, b, c;

    /**
     * Sides of triangle.
     */
    private double firstSide, secondSide, thirdSide;

    /**
     * Construct new triangle by three points.
     * @param pa first point.
     * @param pb second point.
     * @param pc third point.
     */
    public Triangle(Point pa, Point pb, Point pc) {
        this.a = pa;
        this.b = pb;
        this.c = pc;
    }

    /**
     * Calculate a area of triangle.
     * @return area of triangle.
     */
    public double area() {
        double result = 0.0;
        if (canExist()) {
            double halfPerimetr = (firstSide + secondSide + thirdSide) / 2;
            result = sqrt(halfPerimetr * (halfPerimetr - firstSide) * (halfPerimetr - secondSide) * (halfPerimetr - thirdSide));
        }
        return result;
    }

    /**
     * Check that this triangle may exist. Check follow next rule:
     * One of side must be bigger that sum of two other.
     * @return true if this triangle may exist, otherwise false
     */
    private boolean canExist() {
        boolean result = false;
        firstSide = a.distanceTo(b);
        secondSide = b.distanceTo(c);
        thirdSide = c.distanceTo(a);

        if (firstSide + secondSide > thirdSide) {
            result = true;
        } else if (firstSide + thirdSide > secondSide) {
            result = true;
        } else if (secondSide + thirdSide > firstSide) {
            result = true;
        }
        return result;
    }

    /**
     * Return fist side of triangle.
     * @return first side of triangle.
     */
    public double getFirstSide() {
        this.canExist();
        return firstSide;
    }

    /**
     * Return second side of triangle.
     * @return second side of triangle.
     */
    public double getSecondSide() {
        this.canExist();
        return secondSide;
    }

    /**
     * Return third side of triangle.
     * @return third side of triangle.
     */
    public double getThirdSide() {
        this.canExist();
        return thirdSide;
    }
}