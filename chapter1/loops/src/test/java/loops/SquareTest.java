package loops;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;

/**
 * Unit test of Square.java.
 * It test calculate value of square function and test get string view of square function values.
 */
public class SquareTest {

	/**
	 * Instance of testing class.
	 */
	private Square goodFunction;

	/**
	 * It uses for reduce code in test
	 */
	@Before
	public void setUp() {
		goodFunction = new Square(4,3,1);
	}

	/**
	 * When calculate value of function should get value of function.
	 */
	@Test
	public void whenCalculateValueOfFunctionShouldGetValueOfFunctionInPoints() {
		//Assign block
		double expectedValue = 29.00;
		
		//Act block
		double actualValue = (double)goodFunction.calculate(2);
		
		//Action block
		assertThat(expectedValue, closeTo(actualValue, 0.01));
	}


	/**
	 * When try get string view of square function values with step
	 * Should get string with value of function across step.
	 */
	@Test
	public void whenNeedGetStringViewOfFunctionValueShouldReturnStringWithItsValue() {
		//Assign block
		String expectedString = "8 29 64 ";
		
		//Act block
		String actualString = goodFunction.getStringView(1,3,1);
		
		//Action block
		assertThat(expectedString, is(actualString));
	}
}