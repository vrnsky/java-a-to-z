package ru.evrnsky.geometry;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Unit test for Maxside.java.
 * It test algorithm of find max side int triangle.
 */
class MaxsideTest {

    /**
     * Delta of error.
     */
    private static final double DELTA = 0.01;

    /**
     * Expected max side of triangle.
     */
    private static final double EXPECTED_MAX = 8.06d;

    /**
     * When give to max side correct object triangle
     * Should check that max side return correct length of side.
     */
    @Test
    void whenGiveMaxsideObjectCorrectTriangleShouldGetLengthOfMaxSideInTriangle() {
        this.executeTest(new Point(4.0, 0.0),
                new Point(8.0, 3.0), new Point(5.0, 8.0), EXPECTED_MAX);
    }

    /**
     * When try get max side should check that max side return correct answer.
     * It test check that second side also may be max side of triange.
     */
    @Test
    void whenTryGetMaxSideShouldCheckThatMaxSideReturnCorrectAnswer() {
        this.executeTest(new Point(8.0, 3.0),
                new Point(4.0, 0.0),
                new Point(5.0, 8.0), EXPECTED_MAX);
    }

    /**
     * When try get max side should check that max side return correct side.
     */
    @Test
    void whenTryGetMaxSideShouldCheckThatMaxSideReturnCorrectSide() {
        this.executeTest(new Point(5.0, 8.0), new Point(8.0, 3.0), new Point(4.0, 0.0), EXPECTED_MAX);
    }



    /**
     * When give to max side bad object triangle
     * Should that max side return 0.0 - which means that triangle not exist.
     */
    @Test
    void whenGiveMaxsideObjectWrongTriangleShouldGetZeroLength() {
       this.executeTest(new Point(0.0, 0.0),
               new Point(0.0, 3.0), new Point(0.0, 0.0), 0.0);
    }

    /**
     * For avoid duplication common logic placed at this place.
     * @param one of triangle point.
     * @param two of triangle point.
     * @param three of triangle point.
     * @param expected length of max side of triangle.
     */
    void executeTest(Point one, Point two, Point three, double expected) {
        Triangle triangle = new Triangle(one, two, three);
        Maxside maxside = new Maxside();
        double actual = maxside.max(triangle);
        Assertions.assertEquals(expected, actual, DELTA);
    }
}