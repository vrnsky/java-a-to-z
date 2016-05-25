package ru.evrnsky.geometry;

import static java.lang.Math.*;

/**
	Implementation if triangle
*/
public class Triangle
{
	public Point a;
	public Point b;
	public Point c;
	
	public double firstSide;
	public double secondSide;
	public double thirdSide;
	
	/**
		@param: Point a - first node for triangle
				Point b - second node for triangle
				Point c - third node for triangle
	*/
	public Triangle(Point a, Point b, Point c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
		Calculate area for correct triangle, for wrong triangle return area is 0.0
		@return double area - area of correct triangle or 0.0 for wrong triangle
	*/
	public double area()
	{
		double result = 0.0;
		if(canExist())
		{
			double halfPerimetr = (firstSide + secondSide + thirdSide) / 2;
			result = sqrt(halfPerimetr * (halfPerimetr - firstSide)* (halfPerimetr - secondSide) * (halfPerimetr - thirdSide));
		}
		
		return result;
	}
	
	/*
		Check may exist triangle with this points
		@return boolean result - true if triangle may exist and otherwise false
	*/
	private boolean canExist()
	{
		boolean result = false;
		firstSide = a.distanceTo(b);
		secondSide = b.distanceTo(c);
		thirdSide = c.distanceTo(a);
		
		if(firstSide + secondSide > thirdSide)
			result = true;
		else if (firstSide + thirdSide > secondSide)
			result = true;
		else if (secondSide + thirdSide > firstSide)
			result = true;
		return result;
	}
	
	
}