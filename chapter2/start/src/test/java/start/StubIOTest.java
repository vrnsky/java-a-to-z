package start;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for StubIO.java
 * It must give us fake input from user.
 */
public class StubIOTest {

	/**
	 * When ask fake user about some string
	 * Should check that input return string from answer array.
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
	 * When try print something should check that it was printed.
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
	 * When ask user about long and fake user entered correct input
	 * Should accept this input.
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
	 * When ask fake user about integer number and user input integer number behind range
	 * Should throw runtime expception.
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