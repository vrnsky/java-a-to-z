package ru.evrnsky.start;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for StubIO.java
 * It must give us fake input from user.
 */
class StubIOTest {

    /**
     * When ask fake user about some string
     * Should check that input return string from answer array.
     */
    @Test
    void whenGetInputDataShouldReturnInputData() {
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
    void whenShowAtOutSomeDataShouldReturnInfo() {
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
    void whenAskUserAboutLongShouldGetLong() {
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
    @Test
    void whenAskUserAboutIntIfItWrongShouldThrowException() {
        String[] answer = new String[]{"150"};
        StubIO stubIO = new StubIO(answer);
        final int to = 10;

        Assertions.assertThrows(MenuOutException.class, () -> stubIO.ask("Some int", 0, to));
    }
}
