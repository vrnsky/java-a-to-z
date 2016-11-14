package geometry;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test for Triangle.java
 * It test algorithm of calculate area of triangle.
 */
public class TriangleTest {

	/**
	 * Delta of error.
	 */
	private final double delta = 0.01;

	/**
	 * When create a correct triangle object should get it area
	 * and check that actual result and expected result are equals.
	 */
	@Test
	public void whenCreateCorrectTriangleShouldGetItsArea() {
		Triangle goodTriangle = new Triangle(new Point(4.0, 0.0),
				        new Point(8.0, 3.0), new Point(5.0, 8.0));
		final double expectedArea = 14.49;

		double actualArea = goodTriangle.area();

		assertThat(expectedArea, closeTo(actualArea, delta));
	}

	/**
	 * When try get are of bad triangle object, bad means that not may exist
	 * Should check that algorithm return 0.0 - it is means that triangle not exist.
	 */
	@Test
	public void whenCreateBadTriangleShouldGetZero() {
		Triangle badTriangle = new Triangle(new Point(0.0, 0.0),
				      new Point(0.0, 0.0), new Point(0.0, 0.0));
		final double expectedArea = 0.0;

		final double actualArea = badTriangle.area();

		assertThat(expectedArea, closeTo(actualArea, delta));
	}
}