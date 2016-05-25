package ru.evrnsky.geometry;

import ru.evrnsky.geometry.Maxside;
import org.junit.Test;
import static org.junit.Assert.*;

/**
	Unit test for Maxside.java
*/

public class MaxsideTest
{
	/**
	*	Testing of determine max side in correct triangle
	*/
	@Test
	public void whenGiveMaxsideObjectCorrectTriangleShouldGetLengthOfMaxSideInTriangle()
	{
		//Assign block
		Triangle goodTriangle = new Triangle(new Point(4.0,0.0), new Point(8.0,3.0), new Point(5.0,8.0));
		double expectedMax = 8.06;
		Maxside maxSide = new Maxside();
		
		//Act block
		double actualMax = maxSide.max(goodTriangle);
		
		//Action block
		assertEquals(expectedMax, actualMax, 0.01);
	}
	
	/**
	*	Testing of determine max side in bad triangle
	*/
	@Test
	public void whenGiveMaxsideObjectWrongTriangleShouldGetZeroLength()
	{
		//Assign block
		Triangle badTriangle = new Triangle(new Point(0.0,0.0), new Point(0.0,3.0), new Point(0.0,0.0));
		double expectedMax = 0.0;
		Maxside maxSide = new Maxside();
		
		//Act block
		double actualMax = maxSide.max(badTriangle);
		
		//Action block
		assertEquals(expectedMax, actualMax, 0.01);
	}
}