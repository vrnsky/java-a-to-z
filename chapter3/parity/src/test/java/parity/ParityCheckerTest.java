package parity;

import org.junit.Test;
import start.StubIO;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

/**
 * Created by Egor on 02.07.2016.
 */
public class ParityCheckerTest {

    @Test
    public void whenTryGiveOddNumberToParityCheckerShouldShowUserItIsOdd() {
        String[] answer = new String[]{"1"};
        StubIO stubIO = new StubIO(answer);
        ParityChecker parityChecker = new ParityChecker(stubIO);
        String expected = "It is odd";
        parityChecker.isEvenOrOdd();

        assertThat(stubIO.getOut(),containsString(expected));
    }

    @Test
    public void whenTryGiveEvenNumberToParityCheckerShouldShowUserItIsEven() {
        String[] answer = new String[]{"2"};
        StubIO stubIO = new StubIO(answer);
        ParityChecker parityChecker = new ParityChecker(stubIO);
        String expected = "It is even";
        parityChecker.isEvenOrOdd();

        assertThat(stubIO.getOut(),containsString(expected));
    }
}

