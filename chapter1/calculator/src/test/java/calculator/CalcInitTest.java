package calculator;

import org.junit.Test;
import start.StubIO;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for CalcInit.java.
 * It test all opportunity from UI of Calculator.
 */
public class CalcInitTest {

    /**
     * When try execute addiction from calculator UI should check that calculator return correct result.
     */
    @Test
    public void whenTryAddTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() throws Exception {

        //Assign block
        String[] answer = new String[]{"0","1.0","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "0.0 + 1.0 = 1.0\n";

        //Action block
        calcInit.start();

        //Assert block
        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute deduct use calculator UI should check that calculator return correct result.
     */
    @Test
    public void whenTryDeductTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() throws Exception {

        //Assign block
        String[] answer = new String[]{"0","100.0","n", "1", "1","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "100.0 - 1.0 = 99.0\n";

        //Action block
        calcInit.start();

        //Assert block
        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute multiply should check that calculator return correct result.
     */
    @Test
    public void whenTryMultiplyTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() throws Exception {

        //Assign block
        String[] answer = new String[]{"0", "2.0", "n", "2", "10","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "2.0 * 10.0 = 20.0\n";

        //Action block
        calcInit.start();

        //Assert block
        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute divide use calculator UI should check than calculator return correct result.
     */
    @Test
    public void whenTryDivideTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() throws Exception {

        //Assign block
        String[] answer = new String[]{"0", "100.0", "n", "3", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "100.0 / 2.0 = 50.0\n";

        //Action block
        calcInit.start();

        //Assert block
        assertThat(stubIO.getOut(), containsString(expected));
    }

}
