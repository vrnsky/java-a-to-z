package geometry;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test for Point.java.
 * It test algorithm of calculate distance between two points.
 */
public class PointTest {
	/**
	 * When create two and point and calculate distance between its
	 * Should check that actual distance and expected distance are equals
	 */
	@Test
	public void whenCreateTwoPointsAndCalculateDistanceShouldGetDistanceBetweenIts() {
		Point firstPoint = new Point(4.0, 0.0);
		Point secondPoint = new Point(8.0, 3.0);
		final double expectedDistance = 5.0;
		final double delta = 0.01;

		double distance = firstPoint.distanceTo(secondPoint);
		

		assertThat(expectedDistance, closeTo(distance, delta));
	}
}