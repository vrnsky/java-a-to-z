package ru.evrnsky.calculator;

import org.junit.Test;
import ru.evrnsky.start.StubIO;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for CalcInit.java.
 * It test all opportunity from UI of Calculator.
 */
public class CalcInitTest {

    /**
     * When try execute addiction from calculator UI.
     * should check that calculator return correct result.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryAddTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult()
            throws Exception {
        String[] answer = new String[]{"0", "1.0", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "0.0 + 1.0 = 1.0\n";

        calcInit.start();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute deduct use calculator UI.
     * should check that calculator return correct result.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryDeductTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult()
            throws Exception {
        String[] answer = new String[]{"0", "100.0", "n", "1", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "100.0 - 1.0 = 99.0\n";

        calcInit.start();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute multiply should check that calculator return correct result.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryMultiplyTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult()
            throws Exception {
        String[] answer = new String[]{"0", "2.0", "n", "2", "10", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "2.0 * 10.0 = 20.0\n";

        calcInit.start();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try execute divide use calculator UI should check than calculator return correct result.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryDivideTwoDoubleUseCalculatorUIShouldCheckThatCorrectResult()
            throws Exception {
        String[] answer = new String[]{"0", "100.0", "n", "3", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        CalcInit calcInit = new CalcInit(stubIO);
        String expected = "100.0 / 2.0 = 50.0\n";

        calcInit.start();

        assertThat(stubIO.getOut(), containsString(expected));
    }

}
