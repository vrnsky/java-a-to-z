package ru.evrnsky.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Unit test for MenuCalculator.java.
 * It test all functionality from class.
 */
class MenuCalculatorTest {

    /**
     * Count of all action.
     */
    private final int actions = 4;

    /**
     * When try to execute addition should check that operation works correct.
     */
    @Test
    void whenTryExecuteAdditionShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"1.0", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
        menuCalculator.fillActions();
        String expected = "0.0 + 1.0 = 1.0\n";
        final int command = 0;

        menuCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute deduct should check that operation works correct.
     */
    @Test
    void whenTryExecuteDeductShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"2.5", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
        menuCalculator.fillActions();
        String expected = "0.0 - 2.5 = -2.5\n";
        final int command = 1;

        menuCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute multiply operation should check that operation works correct.
     */
    @Test
    void whenTryExecuteMultiplyShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"2", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
        menuCalculator.fillActions();
        String expected = String.format("%s + %s = %s\n%s * %s = %s\n",
                                      0.0, 2.0, 2.0, 2.0, 2.0, 4.0);
        final int firstCommand = 0;
        final int secondCommand = 2;

        menuCalculator.select(firstCommand);
        menuCalculator.select(secondCommand);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute divide should check that is work correct.
     */
    @Test
    void whenTryExecuteDivideShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"100", "2", "y"};
        StubIO stubIo = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIo, actions);
        menuCalculator.fillActions();
        String expected = String.format("%s + %s = %s\n%s / %s = %s\n",
                                0.0, 100.0, 100.0, 100.0, 2.0, 50.0);
        final int firstCommand = 0;
        final int secondCommand = 3;

        menuCalculator.select(firstCommand);
        menuCalculator.select(secondCommand);

        assertThat(stubIo.getOut(), is(expected));
    }

    /**
     * When try div by zero should check that app throw exception.
     */
    @Test
    void whenTryExecuteDivideByZeroShouldCheckThatAppThrowException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            String[] answer = new String[]{"100", "0.0", "y"};
            StubIO stubIO = new StubIO(answer);
            MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
            menuCalculator.fillActions();
            String expected = String.format("%s + %s = %s\n%s / %s = %s\n",
                    0.0, 100.0, 100.0, 100.0, 2.0, 50.0);
            final int firstCommand = 0;
            final int secondCommand = 3;

            menuCalculator.select(firstCommand);
            menuCalculator.select(secondCommand);

            assertThat(stubIO.getOut(), is(expected));
        });
    }

}
