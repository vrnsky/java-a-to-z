package calculator;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Calculator.java.
 * It check that API of calculator work correctly.
 * Correctly means that add, deduct, divide and multiply operation works clear.
 */
public class CalculatorTest {

    /**
     * Instance of API, from it will invoke all public method.
     */
    private Calculator calc;

    /**
     * Init instance of API, it is extract to this method for reduce code.
     */
    @Before
    public void setUp() {
        calc = new Calculator();
    }

    /**
     * When try add two doubles numbers should add two double.
     * and check that actual result and expected result are equals.
     */
    @Test
    public void whenAddTwoDoubleShouldGetSumOfIts() {
        final double first = 1.5;
        final double result = 1.5;

        calc.add(first);

        assertThat(calc.getResult(), is(result));
    }

    /**
     * When try deduct two double numbers should check that
     * actual result and expected result are equals.
     */
    @Test
    public void whenDeductTwoDoubleShouldGetDifferenceBetweenDigits() {
        final double first = 1.5;
        final double diff = -1.5;

        calc.deduct(first);

        assertThat(calc.getResult(), is(diff));
    }

    /**
     * When try multiply two double numbers should check
     * that actual result and expected result are equals.
     */
    @Test
    public void whenMultiplyTwoDoubleShouldGetResultOfMulti() {
        final double first = 5.0;
        final double multiply = 2.0;
        final double result = 10.0;

        calc.add(first);
        calc.multiply(multiply);

        assertThat(calc.getResult(), is(result));
    }

    /**
     * When try divide two double numbers should check
     * that actual result and expected result are equals.
     */
    @Test
    public void whenDivideTwoDoubleShouldGetResultOfDivision() {
        final double first = 100.0;
        final double divisor = 50.0;
        final double result = 2.0;

        calc.add(first);
        calc.div(divisor);

        assertThat(calc.getResult(), is(result));
    }

    /**
     * When try divide no-zero double number by zero should
     * check that algorithm change zero on one and return first double.
     */
    @Test(expected = ArithmeticException.class)
    public void whenDivideDoubleByZeroShouldReturnDividend() {
        final double first = 0.0;
        calc.div(first);
    }

    /**
     * When try calculate sinus should check that is correct.
     */
    @Test
    public void whenCalculateSinShouldCheckThatIsCorrect() {
        final double number = 0.0;
        calc.sin(number);
        assertThat(calc.getResult(), is(number));
    }

    /**
     * When try calculate cosinus should check that result is correct.
     */
    @Test
    public void whenCalculateCosShouldCheckThatIsCorrect() {
        final double number = 0.0;
        final double result = 1.0;
        calc.cos(number);
        assertThat(calc.getResult(), is(result));
    }

    /**
     * When try calculate decimal log should check that result is correct.
     */
    @Test
    public void whenCalculateDecimalLogShouldCheckThatResultIsCorrect() {
        final double number = 100.0;
        final double result = 2.0;
        calc.log(number);
        assertThat(calc.getResult(), is(result));
    }

    /**
     * When try calculate module for some number should check that result is correct.
     */
    @Test
    public void whenCalculateModuleForNumberShouldCheckThaResultIsCorrect() {
        final double number = -2.5;
        final double result = 2.5;
        calc.abs(number);
        assertThat(calc.getResult(), is(result));
    }
}
