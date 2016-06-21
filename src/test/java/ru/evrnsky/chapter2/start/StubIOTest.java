package ru.evrnsky.chapter2.start;

import org.junit.Test;
import org.omg.CORBA.LongHolder;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
	Unit test for StubIO.java
*/
public class StubIOTest {
	
	/**
		When get input data should return input data
	*/
	@Test
	public void whenGetInputDataShouldReturnInputData() {
		
		//Assign block
		String[] answer = new String[]{"Answer"};
		StubIO stubIO = new StubIO(answer);
		String expected = "Answer";
		
		//Act block
		String result = stubIO.ask("Type something: ");
		
		//Action block
		assertThat(result, is(expected));
	}
	
	/**
		When show data should show data
	*/
	@Test 
	public void whenShowAtOutSomeDataShouldReturnInfo(){
		
		//Assign block
		String[] answer = new String[]{"Answer"};
		StubIO stubIO = new StubIO(answer);
		String expected = "Answer\n";
		
		//Act block
		String result = stubIO.ask("Type something: ");
		stubIO.println(result);
		
		//Action block
		assertThat(stubIO.getOut(), is(expected));
	}

	/**
		When ask user about long and user entered correct input
		shoud accept this input	
	*/
	@Test
	public void whenAskUserAboutLongShouldGetLong() {

		//Assign block
		String[] answer = new String[]{"1"};
		StubIO stubIO = new StubIO(answer);
		long expected = 1L;

		//Act block
		long actual = stubIO.askForLong("Please enter a number");

		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When ask user about int and user enter int behind range
		Should throw exception
	*/
	@Test(expected = MenuOutException.class)
	public void whenAskUserAboutIntAndUserEnterIntBehindRangeShouldThrowException() {
		
		//Assign block
		String[] answer = new String[]{"150"};
		StubIO stubIO = new StubIO(answer);

		//Act & action block
		int actual = stubIO.ask("Some int", 0,10);
	}
}