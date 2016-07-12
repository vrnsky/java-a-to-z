package geometry;

import static java.lang.Math.*;

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
	public double firstSide, secondSide, thirdSide;

	/**
	 * Construct new triangle by three points.
	 * @param a first point.
	 * @param b second point.
     * @param c third point.
     */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Calculate a area of triangle.
	 * @return area of triangle.
     */
	public double area() {
		double result = 0.0;
		if(canExist()) {
			double halfPerimetr = (firstSide + secondSide + thirdSide) / 2;
			result = sqrt(halfPerimetr * (halfPerimetr - firstSide)* (halfPerimetr - secondSide) * (halfPerimetr - thirdSide));
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
		
		if(firstSide + secondSide > thirdSide) {
			result = true;
		} else if (firstSide + thirdSide > secondSide) {
			result = true;
		} else if (secondSide + thirdSide > firstSide) {
			result = true;
		}
		return result;
	}
}