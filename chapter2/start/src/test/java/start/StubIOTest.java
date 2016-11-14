package start;

import org.junit.Test;

import static org.junit.Assert.assertThat;
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
    public final void whenGetInputDataShouldReturnInputData() {
        String[] answer = new String[]{"Answer"};
        StubIO stubIO = new StubIO(answer);
        String expected = "Answer";

        String result = stubIO.ask("Type something: ");

        assertThat(result, is(expected));
    }

    /**
     * When try print something should check that it was printed.
     */
    @Test
    public final void whenShowAtOutSomeDataShouldReturnInfo() {
        String[] answer = new String[]{"Answer"};
        StubIO stubIO = new StubIO(answer);
        String expected = "Answer\n";

        String result = stubIO.ask("Type something: ");
        stubIO.println(result);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When ask user about long and fake user entered correct input
     * Should accept this input.
     */
    @Test
    public final void whenAskUserAboutLongShouldGetLong() {
        String[] answer = new String[]{"1"};
        StubIO stubIO = new StubIO(answer);
        long expected = 1L;

        long actual = stubIO.askForLong("Please enter a number");

        assertThat(actual, is(expected));
    }

    /**
     * Ask fake about integer and user input int number in range
     * Should throw runtime exception.
     */
    @Test(expected = MenuOutException.class)
    public final void whenAskUserAboutIntIfItWrongShouldThrowException() {
        String[] answer = new String[]{"150"};
        StubIO stubIO = new StubIO(answer);
        final int to = 10;

        int actual = stubIO.ask("Some int", 0, to);
    }
}
