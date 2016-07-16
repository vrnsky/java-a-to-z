package calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import start.StubIO;


/**
 * Unit test for MenuCalculator.java.
 * It test all functionality from class.
 */
public class MenuCalculatorTest {

    private final static int ACTIONS = 4;

    /**
     * When try execute addition should check that operation works correct.
     */
    @Test
    public void whenTryExecuteAdditionShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"1.0", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, ACTIONS);
        menuCalculator.fillActions();
        String expected = "0.0 + 1.0 = 1.0\n";

        //Action block
        menuCalculator.select(0);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute deduct should check that operation works correct.
     */
    @Test
    public void whenTryExecuteDeductShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"2.5", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, ACTIONS);
        menuCalculator.fillActions();
        String expected = "0.0 - 2.5 = -2.5\n";

        //Action block
        menuCalculator.select(1);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute multiply operation should check that operation works correct.
     */
    @Test
    public void whenTryExecuteMultiplyShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"2","2","y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, ACTIONS);
        menuCalculator.fillActions();
        String expected = "0.0 + 2.0 = 2.0\n" +
                          "2.0 * 2.0 = 4.0\n";

        //Action block
        menuCalculator.select(0);
        menuCalculator.select(2);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try execute divide should check that is work correct.
     */
    @Test
    public void whenTryExecuteDivideShouldCheckThatIsWorkCorrect() {

        //Assign block
        String[] answer = new String[]{"100", "2", "y"};
        StubIO stubIo = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIo, ACTIONS);
        menuCalculator.fillActions();
        String expected = "0.0 + 100.0 = 100.0\n" +
                          "100.0 / 2.0 = 50.0\n";

        //Action block
        menuCalculator.select(0);
        menuCalculator.select(3);

        //Assert block
        assertThat(stubIo.getOut(), is(expected));
    }

    /**
     * When try div by zero should check that app throw exception.
     */
    @Test(expected = ArithmeticException.class)
    public void whenTryExecuteDivideByZeroShouldCheckThatAppThrowException() {

        //Assign block
        String[] answer = new String[]{"100", "0.0", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator(), stubIO, ACTIONS);
        menuCalculator.fillActions();
        String expected = "0.0 + 100.0 = 100.0\n" +
                          "100.0 / 2.0 = 50.0\n";

        //Action block
        menuCalculator.select(0);
        menuCalculator.select(3);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

}
