package ru.evrnsky.start;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for console input and output.
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 01.04.2017
 */
class ConsoleIOTest {

    /**
     * Depend on system.
     */
    private static final String SEPARATOR = System.getProperty("line.separator");

    /**
     * For type some data.
     */
    private final ByteArrayOutputStream console = new ByteArrayOutputStream();

    /**
     * Calls before each test for not use real console.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(console));

    }

    /**
     * When console io type something should check that show.
     */
    @Test
    void whenConsoleIOTypeSomethingShouldCheckThatShow() {
        String expected = "some data";
        ConsoleIO consoleIO = new ConsoleIO();
        consoleIO.println(expected);
        assertThat(console.toString(), is(String.format("%s%s", expected, SEPARATOR)));
    }

    /**
     * When IO ask user about some data should check that works fine.
     */
    @Test
    void whenIOAskUserAboutSomeDataShouldCheckThatWorksFine() {
        String expected = "get from user";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(expected.getBytes());
        System.setIn(new BufferedInputStream(inputStream));
        ConsoleIO consoleIO = new ConsoleIO();
        String actual = consoleIO.ask("type something");
        assertThat(actual, is(expected));
    }

    /**
     * When IO ask about number should check that works fine.
     */
    @Test
    void whenIOAskAboutNumberShouldCheckThatWorksFine() {
        String key = "5";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(key.getBytes());
        System.setIn(new BufferedInputStream(inputStream));
        IO console = new ConsoleIO();
        int value = console.ask("type a number", 0, 10);
        assertThat(value, is(5));
    }

    /**
     * When user type number that unbounded in given range app should throw exception.
     */
    @Test
    void whenIOAskAboutNumberOfOptionAndUserTypeWrong() {
        String key = "100";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(key.getBytes());
        System.setIn(new BufferedInputStream(inputStream));
        IO testConsole = new ConsoleIO();
        Assertions.assertThrows(MenuOutException.class, () ->  testConsole.ask("type", 0, 8));
    }

    /**
     * When io ask bout long should check that works fine.
     */
    @Test
    void whenIOAskAboutLongShouldCheckThatWorksFine() {
        String value = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
        System.setIn(new BufferedInputStream(inputStream));
        IO testConsole = new ConsoleIO();
        long actual = testConsole.askForLong("type a long");
        assertThat(actual, is(Long.valueOf(value)));
    }

    /**
     * When app ask about double should check that works fine.
     */
    @Test
    void whenIOAskAboutDoubleShouldCheckThatAllFine() {
        String value = "2.33";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
        System.setIn(new BufferedInputStream(inputStream));
        IO console = new ConsoleIO();
        double actual = console.askForDouble("type a double");
        assertThat(actual, is(closeTo(Double.valueOf(value), 0.00001)));
    }
}