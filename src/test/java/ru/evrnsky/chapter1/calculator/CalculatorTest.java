package ru.evrnsky.chapter1.calculator;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import ru.evrnsky.chapter1.calculator.Calculator;

/**
* Unit testing of calculator class
*/

public class CalculatorTest
{
	private Calculator calc;
	
	@Before
	public void setUp()
	{
		calc = new Calculator();
	}

	@Test
	public void whenAddTwoDoubleShouldGetSumOfIts()
	{
		//Assign block
		double first = 1.5;
		double second = 1.3;
		double summ = 2.8;
		
		//Act block
		calc.add(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(summ));
	}
	
	@Test
	public void whenSubstructTwoDoubleShouldGetDiffernceBetweenDigits()
	{
		//Assign block
		double first = 2.5;
		double second = 1.5;
		double diff = 1.0;
		
		//Act block
		calc.substruct(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(diff));
	}
	
	@Test
	public void whenMultiplyTwoDoubleShouldGetResultOfMulti()
	{
		//Assign block
		double first = 1.0;
		double second = 2.0;
		double multiply = 2.0;
		
		//Act block
		calc.multiply(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(multiply));
	}
	
	@Test
	public void whenDivideTwoDoubleShouldGetResultOfDivision()
	{
		//Assign block
		double first = 5.1;
		double second = 1.7;
		double division = 3.0;
		
		//Act block
		calc.div(first, second);
		
		//Action block
		assertThat(calc.getResult(), is(division));
	}
	
	@Test
	public void whenDivideDoubleByZeroShouldReturnDividend()
	{
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
