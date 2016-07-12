package geometry;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test for Triangle.java
 * It test algorithm of calculate area of triangle.
 */
public class TriangleTest {

	/**
	 * When create a correct triangle object should get it area
	 * and check that actual result and expected result are equals.
	 */
	@Test
	public void whenCreateCorrectTriangleShouldGetItsArea() {

		//Assign block
		Triangle goodTriangle = new Triangle(new Point(4.0,0.0), new Point(8.0,3.0), new Point(5.0,8.0));
		double expectedArea = 14.49;
		
		//Act block
		double actualArea = goodTriangle.area();
		
		//Action block
		assertThat(expectedArea, closeTo(actualArea,0.01));
	}

	/**
	 * When try get are of bad triangle object, bad means that not may exist
	 * Should check that algorithm return 0.0 - it is means that triangle not exist.
	 */
	@Test
	public void whenCreateBadTriangleShouldGetZero() {
		//Assign block
		Triangle badTriangle = new Triangle(new Point(0.0,0.0), new Point(0.0, 0.0), new Point(0.0,0.0));
		double expectedArea = 0.0;
		
		//Act block
		double actualArea = badTriangle.area();
		
		//Action block
		assertThat(expectedArea, closeTo(actualArea,0.01));
	}
}