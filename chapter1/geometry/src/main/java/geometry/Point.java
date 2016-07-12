package geometry;

import static java.lang.Math.*;

/**
 * Representation of point in Decart coordinate system.
 */
public class Point {

	/**
	 * Coordinate by x axis.
	 */
	public double x;

	/**
	 * Coordinate by y axis.
	 */
	public double y;

	/**
	 * Construct new point at the given coordinates.
	 * @param x  coordinate by x axis.
	 * @param y  coordinate by y axis.
     */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	*	Calculate distance between two points.
	*	@param  point finish point for computing.
	* 	@return  distance between this point and transmitted point.
	*/
	public double distanceTo(Point point)
	{
		return abs(sqrt(pow(point.x - this.x, 2.0) + pow(point.y - this.y, 2.0)));
	}
}