package parity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Unit test for ParityChecker.java.
 */
public class ParityCheckerTest {

    /**
     * When try give odd number to parity checker should check than parity check show user that is it odd.
     */
    @Test
    void whenTryGiveOddNumberToParityCheckerShouldShowUserItIsOdd() {

        //Assign block
        String[] answer = new String[]{"1"};
        StubIO stubIO = new StubIO(answer);
        ParityChecker parityChecker = new ParityChecker(stubIO);
        String expected = "It is odd";

        //Act block
        parityChecker.isEvenOrOdd();

        //Action block
        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try give even number to parity checker should check than parity check show user that it is even.
     */
    @Test
    void whenTryGiveEvenNumberToParityCheckerShouldShowUserItIsEven() {

        //Assign block
        String[] answer = new String[]{"2"};
        StubIO stubIO = new StubIO(answer);
        ParityChecker parityChecker = new ParityChecker(stubIO);
        String expected = "It is even";

        //Act block
        parityChecker.isEvenOrOdd();

        //Action block
        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When user type not number should check that app throw exception
     * in real io system, needs using validator instance which validate input.
     */
    @Test
    void whenUserTypeNotNumberShouldCheckThatAppThrowException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            //Assign block
            String[] answer = new String[]{"asd"};
            StubIO stubIO = new StubIO(answer);
            ParityChecker parityChecker = new ParityChecker(stubIO);
            String expected = "please type number";

            //Act block
            parityChecker.isEvenOrOdd();

            //Action block
            assertThat(stubIO.getOut(), containsString(expected));
        });
    }
}