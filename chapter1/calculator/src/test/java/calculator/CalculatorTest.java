package calculator;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
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
	 * When try add two doubles numbers should add two double
	 * and check that actual result and expected result are equals.
	 */
	@Test
	public void whenAddTwoDoubleShouldGetSumOfIts() {
		//Assign block
		double first = 1.5;
		double result = 1.5;
		
		//Act block
		calc.add(first);
		
		//Action block
		assertThat(calc.getResult(), is(result));
	}

	/**
	 * When try deduct two double numbers should check that
	 * actual result and expected result are equals.
	 */
	@Test
	public void whenDeductTwoDoubleShouldGetDifferenceBetweenDigits() {
		//Assign block
		double first = 1.5;
		double diff = -1.5;
		
		//Act block
		calc.deduct(first);
		
		//Action block
		assertThat(calc.getResult(), is(diff));
	}

	/**
	 * When try multiply two double numbers should check
	 * that actual result and expected result are equals.
	 */
	@Test
	public void whenMultiplyTwoDoubleShouldGetResultOfMulti() {
		//Assign block
		double first = 5.0;
		double multiply = 2.0;
		double result = 10.0;

		//Act block
		calc.add(first);
		calc.multiply(multiply);
		
		//Action block
		assertThat(calc.getResult(), is(result));
	}

	/**
	 * When try divide two double numbers should check
	 * that actual result and expected result are equals.
	 */
	@Test
	public void whenDivideTwoDoubleShouldGetResultOfDivision() {
		//Assign block
		double first = 100.0;
		double divisor = 50.0;
		double result = 2.0;

		//Act block
		calc.add(first);
		calc.div(divisor);
		
		//Action block
		assertThat(calc.getResult(), is(result));
	}

	/**
	 * When try divide no-zero double number by zero should
	 * check that algorithm change zero on one and return first double.
	 */
	@Test(expected = ArithmeticException.class)
	public void whenDivideDoubleByZeroShouldReturnDividend() {
		//Assign block
		double first = 0.0;
		
		//Act block
		calc.div(first);
	}

	/**
	 * When try calculate sinus should check that is correct.
     */
	@Test
	public void whenCalculateSinShouldCheckThatIsCorrect() {
		//Assign block
		double number = 0.0;

		//Action block
		calc.sin(number);

		//Assert block
		assertThat(calc.getResult(),is(number));
	}

	/**
	 * When try calculate cosinus should check that result is correct.
     */
	@Test
	public void whenCalculateCosShouldCheckThatIsCorrect() {

		//Assign block
		double number = 0.0;

		//Action block
		calc.cos(number);

		//Assert block
		assertThat(calc.getResult(), is(1.0));
	}

	/**
	 * When try calculate decimal log should check that result is correct.
     */
	@Test
	public void whenCalculateDecimalLogShouldCheckThatResultIsCorrect() {

		//Assign block
		double number = 100.0;

		//Action block
		calc.log(number);

		//Assert block
		assertThat(calc.getResult(), is(10.));
	}

	/**
	 * When try calculate module for some number should check that result is correct.
     */
	@Test
	public void whenCalculateModuleForNumberShouldCheckThaResultIsCorrect() {

		//Assign number
		double number = -2.5;

		//Action block
		calc.abs(number);

		//Assert block
		assertThat(calc.getResult(), is(2.5));
	}
}
