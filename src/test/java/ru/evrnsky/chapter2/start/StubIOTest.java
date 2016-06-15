package ru.evrnsky.chapter2.start;

import org.junit.Test;
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
}