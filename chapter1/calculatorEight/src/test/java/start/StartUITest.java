package start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 01.04.2017
 *
 * Unit test for user interface.
 */
public class StartUITest {

    /**
     * Try to sum.
     */
    @Test
    public void whenTrySumTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"+", "1", "1", "y"};
        StubIO stubIO  = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "1 + 1 = 2\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * Deduct.
     */
    @Test
    public void whenTryDeductTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"-", "100", "99", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "100 - 99 = 1\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * Try to multiply.
     */
    @Test
    public void whenTryMultiplyTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"*", "6", "6", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "6 * 6 = 36\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try divide.
     */
    @Test
    public void whenTryDivideTwoIntegerShouldCheckThatInUIPrintCorrectResult() {
        String[] answer = new String[]{"/", "32", "8", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "32 / 8 = 4\n";

        starter.init();

        assertThat(stubIO.getOut(), is(expected));
    }
}
