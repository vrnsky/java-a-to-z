package ru.evrnsky.loops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Unit test of Square.java.
 * Calculate value of square function, get string view of function values.
 */
public class SquareTest {

    /**
     * Instance of testing class.
     */
    private Square goodFunction;

    /**
     * It uses for reduce code in test.
     */
    @BeforeEach
    public final void setUp() {
        final int ax = 4;
        final int bx = 3;
        final int c = 1;
        goodFunction = new Square(ax, bx, c);
    }

    /**
     * When calculate value of function should get value of function.
     */
    @Test
    void whenCalculateFunctionShouldGetFuncValueInPoint() {
        final double expectedValue = 29.00;
        final int testValue = 2;
        final double error = 0.01;

        double actualValue = (double) goodFunction.calculate(testValue);

        assertThat(expectedValue, closeTo(actualValue, error));
    }


    /**
     * When try get string view of square function values with step
     * Should get string with value of function across step.
     */
    @Test
    void whenNeedStringViewOfFuncValueShouldStringWithValue() {
        final String expectedString = "8 29 64 ";
        final int ax = 1;
        final int bx = 3;
        final int c = 1;

        String actualString = goodFunction.getStringView(ax, bx, c);

        assertThat(expectedString, is(actualString));
    }
}
