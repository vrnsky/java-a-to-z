package ru.evrnsky.chapter1.geometry;

import ru.evrnsky.chapter1.geometry.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
*	Unit test for Triangle.java
*/
public class TriangleTest
{
	
	/**
		Create a correct triangle and calculate it area
	*/
	@Test
	public void whenCreateCorrectTriangleShouldGetItsArea()
	{
		//Assign block
		Triangle goodTriangle = new Triangle(new Point(4.0,0.0), new Point(8.0,3.0), new Point(5.0,8.0));
		double expectedArea = 14.49;
		
		//Act block
		double actualArea = goodTriangle.area();
		
		//Action block
		assertThat(expectedArea, closeTo(actualArea,0.01));
		
		
	}
	
	/**
		Create a wrong triangle and try to calculate it area
	*/
	@Test
	public void whenCreateBadTriangleShouldGetZero()
	{
		//Assign block
		Triangle badTriangle = new Triangle(new Point(0.0,0.0), new Point(0.0, 0.0), new Point(0.0,0.0));
		double expectedArea = 0.0;
		
		//Act block
		double actualArea = badTriangle.area();
		
		//Action block
		assertThat(expectedArea, closeTo(actualArea,0.01));
		
	}
}