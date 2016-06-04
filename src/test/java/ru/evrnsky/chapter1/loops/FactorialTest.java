package ru.evrnsky.chapter1.loops;

import ru.evrnsky.chapter1.loops.Factorial;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test for Factorial.java
*/

public class FactorialTest
{
	
	private Factorial factorial;
	
	/**
		This method call before execute each test
		Initialize instance of factorial
	*/
	@Before
	public void setUp()
	{
		factorial = new Factorial();
	}
	
	/**
		Calculate not zero factorial
	*/
	@Test
	public void whenTryCalculateForNotZeroFactorialShouldGetFactorialOfNumber()
	{
		//Assign block
		int expectedValue = 6;
		
		//Act block
		int actualValue = factorial.calculate(3);
		
		//Action block
		assertThat(expectedValue, is(actualValue));
	}
	
	/**
		Calculate zero factorial
	*/
	@Test
	public void whenTryCalculateZeroFactorialShouldGetOne()
	{
		//Assign block
		int expectedValue = 1;
		
		//Act block
		int actualValue = factorial.calculate(0);
		
		//Action block
		assertThat(expectedValue,is(actualValue));
	}
}
