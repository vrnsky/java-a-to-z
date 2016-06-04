package ru.evrnsky.chapter1.task;

import org.junit.Before;
import org.junit.Test;
import ru.evrnsky.chapter1.task.Substring;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test for ru/evrnsky/task/Substring.java
*/
public class SubstringTest
{
	private Substring substr;

	/**
	 * JUnit call this method before each test. Use this for initialization
	 * Initialize instance of substring
	 */
	@Before
	public void setUp()
	{
		substr = new Substring();
	}

	/**
		Call isSubtring method from instance of Subtring class with correct parameters should return true
	*/
	@Test
	public void whenCallIsSubstringMethodFromSubtringAndPassTwoCorrectStringShouldReturnTrue()
	{
		//Assign block
		String fullString = "Hello";
		String partString = "el";
		boolean expected = true;

		//Act block
		boolean result = substr.isSubstring(fullString, partString);

		//Action block
		assertThat(result, is(expected));
	}
	
	/**
		Call isSubtring method from instance of Subtrung class with wrong parameters should return false
	*/
	@Test
	public void whenCallIsSubtringMethodFromSubstringAndWrongArgumentShouldReturnFalse()
	{
		//Assign block
		String fullString = "Bad string";
		String partString = "q";
		boolean expected = false;

		//Act block
		boolean result = substr.isSubstring(fullString, partString);

		//Action block
		assertThat(result, is(expected));
	}
}