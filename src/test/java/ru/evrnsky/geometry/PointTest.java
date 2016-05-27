package ru.evrnsky.geometry;

import ru.evrnsky.geometry.Point;
import static java.lang.Math.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


/**
* 	Unit test for Point.java
*   Compute distance between two points
*/
public class PointTest
{
	
	@Test
	public void whenCreateTwoPointsAndCalculateDistanceShouldGetDistanceBetweenIts()
	{
		//Assign block
		Point firstPoint = new Point(4.0, 0.0);
		Point secondPoint = new Point(8.0,3.0);
		double expectedDistance = 5.0;
		
		//Act block
		double distance = firstPoint.distanceTo(secondPoint);
		
		//Action block
		assertThat(expectedDistance, closeTo(distance, 0.01));
		
		
		
	}
}