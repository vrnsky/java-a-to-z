package ru.evrnsky.geometry;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test for Point.java.
 * It test algorithm of calculate distance between two points.
 */
class PointTest {
	/**
	 * When create two and point and calculate distance between its.
	 * Should check that actual distance and expected distance are equals.
	 */
	@Test
	void whenCreateTwoPointsAndCalculateDistanceShouldGetDistanceBetweenIts() {
		Point firstPoint = new Point(4.0, 0.0);
		Point secondPoint = new Point(8.0, 3.0);
		final double expectedDistance = 5.0;
		final double delta = 0.01;

		double distance = firstPoint.distanceTo(secondPoint);
		assertThat(expectedDistance, closeTo(distance, delta));
	}

	/**
	 * When try get x and y should check that data return correct.
	 */
	@Test
	void whenTryGetXAndYShouldCheckThatAllIsOk() {
		Point point = new Point(1.2, 2.3);
		assertThat(point.getX(), is(closeTo(1.2, 0.01)));
		assertThat(point.getY(), is(closeTo(2.3, 0.01)));
	}
}