package ru.evrnsky.loops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test of Factorial.java.
 * It test algorithm of calculating factorial for integer numbers.
 */
class FactorialTest {

    /**
     * Instance of testing class.
     */
    private Factorial factorial;

    /**
     * Init instance of testing class at this place
     * for reduce size of code int tests.
     */
    @BeforeEach
    public void setUp() {
        factorial = new Factorial();
    }

    /**
     * When try calculate factorial for no-zero integer
     * should get from factorial object factorial of given integer.
     */
    @Test
    final void whenTryCalculateFactorialShouldFactorialOfNumber() {
        final int expectedValue = 6;
        final int testValue = 3;

        int actualValue = factorial.calculate(testValue);

        assertThat(expectedValue, is(actualValue));
    }

    /**
     * When try calculate factorial for zero
     * Should check that factorial object return one/.
     */
    @Test
    void whenTryCalculateZeroFactorialShouldGetOne() {
        final int expectedValue = 1;
        final int zero = 0;

        int actualValue = factorial.calculate(zero);

        assertThat(expectedValue, is(actualValue));
    }
}

