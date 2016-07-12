package loops;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 *  Unit test of Factorial.java.
 *  It test algorithm of calculating factorial for integer numbers.
 */
public class FactorialTest {

	/**
	 * Instance of testing class.
	 */
	private Factorial factorial;

	/**
	 * Init instance of testing class at this place
	 * for reduce size of code int tests.
	 */
	@Before
	public void setUp()
	{
		factorial = new Factorial();
	}

	/**
	 * When try calculate factorial for no-zero integer
	 * should get from factorial object factorial of given integer.
	 */
	@Test
	public void whenTryCalculateForNotZeroFactorialShouldGetFactorialOfNumber() {
		//Assign block
		int expectedValue = 6;
		
		//Act block
		int actualValue = factorial.calculate(3);
		
		//Action block
		assertThat(expectedValue, is(actualValue));
	}

	/**
	 * When try calculate factorial for zero
	 * Should check that factorial object return one/.
	 */
	@Test
	public void whenTryCalculateZeroFactorialShouldGetOne() {
		//Assign block
		int expectedValue = 1;
		
		//Act block
		int actualValue = factorial.calculate(0);
		
		//Action block
		assertThat(expectedValue,is(actualValue));
	}
}
