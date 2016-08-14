package start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Egor on 13.08.2016.
 */
public class StartUITest {

    @Test
    public void whenTrySumTwoIntegerShouldCheckThatInUIPrintCorrectResult() {

        //Assign block
        String[] answer = new String[]{"+", "1", "1", "y"};
        StubIO stubIO  = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "1 + 1 = 2\n";

        //Action block
        starter.init();

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryDeductTwoIntegerShouldCheckThatInUIPrintCorrectResult() {

        //Assign block
        String[] answer = new String[]{"-", "100", "99", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "100 - 99 = 1\n";

        //Action block
        starter.init();

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryMultiplyTwoIntegerShouldCheckThatInUIPrintCorrectResult() {

        //Assign block
        String[] answer = new String[]{"*", "6", "6", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "6 * 6 = 36\n";

        //Action block
        starter.init();

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryDivideTwoIntegerShouldCheckThatInUIPrintCorrectResult() {

        //Assign block
        String[] answer = new String[]{"/", "32", "8", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI starter = new StartUI(stubIO);
        String expected = "32 / 8 = 4\n";

        //Action block
        starter.init();

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }
}
