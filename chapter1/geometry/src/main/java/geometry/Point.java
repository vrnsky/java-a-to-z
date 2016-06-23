package geometry;

import static java.lang.Math.*;

/**
*   Implementation of point in 2D
*/
public class Point
{
	public double x;
	public double y;
	
	/**
		@param: double x - coord for x position
				double y - coord for y position
	*/
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	*	Calculate distance between two points
	*	@param: Point point - finish point for computing
	* 	@return double distance - distance between this point and transmitted point
	*/
	public double distanceTo(Point point)
	{
		return abs(sqrt(pow(point.x - this.x, 2.0) + pow(point.y - this.y, 2.0)));
	}
}