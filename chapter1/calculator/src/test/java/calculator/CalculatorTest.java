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
		double second = 1.3;
		double summ = 2.8;
		
		//Act block
		calc.add(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(summ));
	}

	/**
	 * When try deduct two double numbers should check that
	 * actual result and expected result are equals.
	 */
	@Test
	public void whenDeductTwoDoubleShouldGetDifferenceBetweenDigits() {
		//Assign block
		double first = 2.5;
		double second = 1.5;
		double diff = 1.0;
		
		//Act block
		calc.deduct(first, second);
		
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
		double first = 1.0;
		double second = 2.0;
		double multiply = 2.0;
		
		//Act block
		calc.multiply(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(multiply));
	}

	/**
	 * When try divide two double numbers should check
	 * that actual result and expected result are equals.
	 */
	@Test
	public void whenDivideTwoDoubleShouldGetResultOfDivision() {
		//Assign block
		double first = 5.1;
		double second = 1.7;
		double division = 3.0;
		
		//Act block
		calc.div(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(division));
	}

	/**
	 * When try divide no-zero double number by zero should
	 * check that algorithm change zero on one and return first double.
	 */
	@Test
	public void whenDivideDoubleByZeroShouldReturnDividend() {
		//Assign block
		double first = 1.0;
		double second = 0.0;
		double division = 1.0;
		
		//Act block
		calc.div(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(division));
	}
}
