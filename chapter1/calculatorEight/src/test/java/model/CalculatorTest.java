package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Calculator.java
 */
public class CalculatorTest {

    /**
     * Instance of Calculator API.
     */
    private Calculator calc;

    /**
     * Before each test JUnit call this method.
     * Use it for init all need variables.
     */
    @Before
    public void setUp() {
        calc = new Calculator();
    }

    /**
     * When try sum two integer should check that calculator return correct value.
     */
    @Test
    public void whenTryCalculateSumShouldCheckThatCalculatorCorrectCalculate() {

        //Assign block
        int expected = 2;

        //Action block
        int actual = calc.execute((a,b) -> a + b, 1, 1);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try deduct one integer from other integer should check that calculator return correct value.
     */
    @Test
    public void whenTryCalculateDeductShouldCheckThatCalculatorCorrectCalculate() {

        //Assign bock
        int expected = 1;

        //Action block
        int actual = calc.execute((a, b) -> a-b, 100, 99);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try multiply two integers should check that calculator return correct value.
     */
    @Test
    public void whenTryCalculateMultiplyShouldCheckThatCalculatorCorrectCalculate() {

        //Assign block
        int expected = 100;

        //Action block
        int actual = calc.execute((a, b) -> a * b, 10,10);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try div one integer by other not null integer should check that calculator return correct value.
     */
    @Test
    public void whenTryCalculateDivShouldCheckThatCalculatorGiveCorrectResult() {

        //Assign block
        int expected = 6;

        //Action block
        int actual = calc.execute((a, b) -> a / b, 12, 2);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When user try div by zero should check that throw arithmetic exception.
     */
    @Test(expected = ArithmeticException.class)
    public void whenTryDivByZeroShouldCheckThatCalculatorThrowCorrectException() {

        //Assign block
        int expected = -1;

        //Action block
        int actual = calc.execute((a,b) -> a/b, 10,0);
    }

}
