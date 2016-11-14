package calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import start.StubIO;


/**
 * Unit test for MenuCalculator.java.
 * It test all functionality from class.
 */
public class MenuCalculatorTest {

    /**
     * Count of all action.
     */
    private final int actions = 4;

    /**
     * When try execute addition should check that operation works correct.
     */
    @Test
    public void whenTryExecuteAdditionShouldCheckThatIsWorkCorrect() {
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
    public void whenTryExecuteDeductShouldCheckThatIsWorkCorrect() {
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
    public void whenTryExecuteMultiplyShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"2", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
        menuCalculator.fillActions();
        String expected = "0.0 + 2.0 = 2.0\n"
                           +
                          "2.0 * 2.0 = 4.0\n";
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
    public void whenTryExecuteDivideShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"100", "2", "y"};
        StubIO stubIo = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIo, actions);
        menuCalculator.fillActions();
        String expected = "0.0 + 100.0 = 100.0\n"
                           +
                          "100.0 / 2.0 = 50.0\n";

        final int firstCommand = 0;
        final int secondCommand = 3;

        menuCalculator.select(firstCommand);
        menuCalculator.select(secondCommand);

        assertThat(stubIo.getOut(), is(expected));
    }

    /**
     * When try div by zero should check that app throw exception.
     */
    @Test(expected = ArithmeticException.class)
    public void whenTryExecuteDivideByZeroShouldCheckThatAppThrowException() {
        String[] answer = new String[]{"100", "0.0", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, actions);
        menuCalculator.fillActions();
        String expected = "0.0 + 100.0 = 100.0\n"
                          +
                          "100.0 / 2.0 = 50.0\n";
        final int firstCommand = 0;
        final int secondCommand = 3;

        menuCalculator.select(firstCommand);
        menuCalculator.select(secondCommand);

        assertThat(stubIO.getOut(), is(expected));
    }

}
