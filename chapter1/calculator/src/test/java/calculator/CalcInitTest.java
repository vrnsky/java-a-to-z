package calculator;

import org.junit.Test;
import start.StubIO;

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
    public void whenTryAddTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() {

        //Assign block
        String[] answer = new String[]{"1.0","1.0","+","n","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "1.0 + 1.0 = 2.0\n";

        //Action block
        try {
            calcInit.start();
        } catch (Exception exp) {
           exp.printStackTrace();
        }
        String actual = stubIO.getOut();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try execute deduct use calculator UI should check that calculator return correct result.
     */
    @Test
    public void whenTryDeductTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() {

        //Assign block
        String[] answer = new String[]{"2.0", "1.0", "-", "n","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "2.0 - 1.0 = 1.0\n";

        //Action block
        try {
            calcInit.start();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        String actual = stubIO.getOut();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try execute multiply should check that calculator return correct result.
     */
    @Test
    public void whenTryMultiplyTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() {

        //Assign block
        String[] answer = new String[]{"0.5", "2.0", "*", "n", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "0.5 * 2.0 = 1.0\n";

        //Action block
        try {
            calcInit.start();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        String actual = stubIO.getOut();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try execute divide use calculator UI should check than calculator return correct result.
     */
    @Test
    public void whenTryDivideTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult() {

        //Assign block
        String[] answer = new String[]{"10.0", "2.0", "/", "n", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "10.0 / 2.0 = 5.0\n";

        //Action block
        try {
            calcInit.start();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        String actual = stubIO.getOut();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try execute some arithmetic operation with previous result should check that it works correct.
     */
    @Test
    public void whenTryReusePreviousResultShouldCheckThatItWorksCorrect() {

        //Assign block
        String[] answer = new String[]{"5.0", "2.0", "+", "y", "n", "3.5", "/", "n","y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "5.0 + 2.0 = 7.0\n" +
                          "7.0 / 3.5 = 2.0\n";

        //Action block
        try {
            calcInit.start();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        String actual = stubIO.getOut();

        //Assert block
        assertThat(actual, is(expected));
    }

}
