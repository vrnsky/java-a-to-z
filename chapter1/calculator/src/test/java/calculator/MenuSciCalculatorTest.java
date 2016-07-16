package calculator;

import org.junit.Test;
import start.StubIO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Egor on 16.07.2016.
 */
public class MenuSciCalculatorTest {

    private static final int ACTIONS = 8;

    @Test
    public void whenTryExecuteSinShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"0.0","n"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, ACTIONS);
        menuSciCalculator.fillActions();
        String expected = "cos(0.0) = 1.0\n";

        //Action block
        menuSciCalculator.select(4);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryExecuteCosShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"0","n"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, ACTIONS);
        menuSciCalculator.fillActions();
        String expected = "sin(0.0) = 0.0\n";

        //Action block
        menuSciCalculator.select(5);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryExecuteLogShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"100.0","y"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, ACTIONS);
        menuSciCalculator.fillActions();
        String expected = "log10(100.0) = 2.0\n";

        //Action block
        menuSciCalculator.select(6);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    @Test
    public void whenTryExecuteAbsShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"-2.5","y"};
        StubIO stubIO = new StubIO(answer);
        MenuSciCalculator menuSciCalculator = new MenuSciCalculator(new Calculator(), stubIO, ACTIONS);
        menuSciCalculator.fillActions();
        String expected = "abs(-2.5) = 2.5\n";

        //Action block
        menuSciCalculator.select(7);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }
}
