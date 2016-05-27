package ru.evrnsky.loops;

import ru.evrnsky.loops.Factorial;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test for Factorial.java
*/

public class FactorialTest
{
	/**
		Calculate not zero factorial
	*/
	@Test
	public void whenTryCalculateForNotZeroFactorialShouldGetFactorialOfNumber()
	{
		Factorial factorial = new Factorial();
		int expectedValue = 6;
		
		int actualValue = factorial.calculate(3);
		
		assertThat(expectedValue, is(actualValue));
	}
	
	/**
		Calculate zero factorial
	*/
	@Test
	public void whenTryCalculateZeroFactorialShouldGetOne()
	{
		Factorial factorial = new Factorial();
		int expectedValue = 1;
		
		int actualValue = factorial.calculate(0);
		
		assertThat(expectedValue,is(actualValue));
	}
}
