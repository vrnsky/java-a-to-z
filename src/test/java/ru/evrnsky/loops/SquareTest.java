package ru.evrnsky.loops;

import ru.evrnsky.loops.Square;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;

/**
	Unit test for Square.java
	
*/
public class SquareTest
{
	/**
		Create function and calculate it value in some point
	*/
	@Test
	public void whenCalculateValueOfFunctionShouldGetValueOfFunctionInPoints()
	{
		//Assign block
		Square goodFunction = new Square(4,3,1);
		double expectedValue = 29.00;
		
		//Act block
		double actualValue = (double)goodFunction.calculate(2);
		
		//Action block
		assertThat(expectedValue, closeTo(actualValue, 0.01));
	}
	
	
	/**
		Create function and get string view of it values in some points
	*/
	@Test
	public void whenNeedGetStringViewOfFunctionValueShouldReturnStringWithItsValue()
	{
		//Assign block
		Square goodFunction = new Square(4,3,1);
		String expectedString = "8 29 64 ";
		
		//Act block
		String actualString = goodFunction.getStringView(1,3,1);
		
		//Action block
		assertThat(expectedString, is(actualString));
	}
}