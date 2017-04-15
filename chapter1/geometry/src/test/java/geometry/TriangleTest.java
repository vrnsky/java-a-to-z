package geometry;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test for Triangle.java
 * It test algorithm of calculate area of triangle.
 */
public class TriangleTest {


    /**
     * Expected square of triangle.
     */
    private static final double EXPECTED = 14.49;

    /**
     * When create a correct triangle object should get it area
     * and check that actual result and expected result are equals.
     */
    @Test
    public void whenCreateCorrectTriangleShouldGetItsArea() {
        this.executeTest(new Point(4.0, 0.0),
                new Point(8.0, 3.0), new Point(5.0, 8.0), EXPECTED);
    }

    /**
     * When try create correct triangle with other sides should check that all is ok.
     */
    @Test
    public void whenCreateCorrectTriangleWithOtherSidesShouldCheckFinest() {
        this.executeTest(new Point(0.0, 0.0),
                new Point(0.0, 0.0), new Point(25.0, 0.0), 0.0);
    }

    /**
     * When try correct triangle with other side should that all is ok.
     */
    @Test
    public void whenCreateCorrectTriangleWithOtherSidesShouldCheckThatWorksFine() {
        this.executeTest(new Point(25.0, 0.0),
                new Point(0.0, 0.0), new Point(0.0, 0.0), 0.0);
    }

    /**
     * When try get are of bad triangle object, bad means that not may exist
     * Should check that algorithm return 0.0 - it is means that triangle not exist.
     */
    @Test
    public void whenCreateBadTriangleShouldGetZero() {
        this.executeTest(new Point(0.0, 0.0),
                new Point(0.0, 0.0), new Point(0.0, 0.0), 0.0);
    }

    /**
     * Execute test case.
     *
     * @param one      of triangle point.
     * @param two      of triangle point.
     * @param three    of triangle point.
     * @param expected of triangle square.
     */
    private void executeTest(Point one, Point two, Point three, double expected) {
        Triangle triangle = new Triangle(one, two, three);
        double actual = triangle.area();
        assertThat(actual, is(closeTo(expected, 0.01)));
    }
}