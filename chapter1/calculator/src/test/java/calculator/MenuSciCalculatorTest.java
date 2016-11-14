package calculator;

import org.junit.Test;
import start.StubIO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for science calculator.
 */
public class MenuSciCalculatorTest {

    /**
     * Count of all actions.
     */
    private final int actions = 8;

    /**
     * When try execute sin should check correct.
     */
    @Test
    public void whenTryExecuteSinShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"0.0", "n"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, actions);
        menuSciCalculator.fillActions();
        String expected = "cos(0.0) = 1.0\n";
        final int command = 4;

        menuSciCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute cos should check correct.
     */
    @Test
    public void whenTryExecuteCosShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"0", "n"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, actions);
        menuSciCalculator.fillActions();
        String expected = "sin(0.0) = 0.0\n";
        final int command = 5;

        menuSciCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute log should check correct.
     */
    @Test
    public void whenTryExecuteLogShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"100.0", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, actions);
        menuSciCalculator.fillActions();
        String expected = "log10(100.0) = 2.0\n";
        final int command = 6;

        menuSciCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute abs should check correct.
     */
    @Test
    public void whenTryExecuteAbsShouldCheckThatIsWorkCorrect() {
        String[] answer = new String[]{"-2.5", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, actions);
        menuSciCalculator.fillActions();
        String expected = "abs(-2.5) = 2.5\n";
        final int command = 7;

        menuSciCalculator.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }
}
