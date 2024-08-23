package ru.evrnsky.start;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 01.04.2017
 *
 * Unit test for user interface.
 */
class StartUITest {

    /**
     * Try to sum.
     */
    @Test
    void whenTrySumTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"+", "1", "1", "y"};
        StubIO stubIO  = new StubIO(answer);
        ru.evrnsky.start.StartUI starter = new ru.evrnsky.start.StartUI(stubIO);
        String expected = "1 + 1 = 2\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * Deduct.
     */
    @Test
    void whenTryDeductTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"-", "100", "99", "y"};
        StubIO stubIO = new StubIO(answer);
        ru.evrnsky.start.StartUI starter = new ru.evrnsky.start.StartUI(stubIO);
        String expected = "100 - 99 = 1\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * Try to multiply.
     */
    @Test
    void whenTryMultiplyTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"*", "6", "6", "y"};
        StubIO stubIO = new StubIO(answer);
        ru.evrnsky.start.StartUI starter = new ru.evrnsky.start.StartUI(stubIO);
        String expected = "6 * 6 = 36\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try divide.
     */
    @Test
    void whenTryDivideTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"/", "32", "8", "y"};
        StubIO stubIO = new StubIO(answer);
        ru.evrnsky.start.StartUI starter = new StartUI(stubIO);
        String expected = "32 / 8 = 4\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }
}
