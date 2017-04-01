package start;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for validator class.
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.1
 * @since 01.04.2017
 */
public class ValidatorTest {


    /**
     * When validator print should check that works fine.
     */
    @Test
    public void whenValidatorPrintShouldCheckThatAllPrintln() {
        String[] answer = {"type something"};
        String expected = "written from validator";
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        validator.println(expected);
        assertThat(stubIO.getOut(), is(String.format("%s\n", expected)));
    }

    /**
     * When validator ask user about data should check that validator get data.
     */
    @Test
    public void whenValidatorAskUserAboutDataShouldCheckThatValidatorGetData() {
        String[] answer = {"I am from user"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        String actual = validator.ask("type something");
        assertThat(actual, is(answer[0]));
    }

    /**
     * When validator ask about long should check that all is ok.
     */
    @Test
    public void whenValidatorAskAboutLongShouldCheckThatAllIsOk() {
        String[] answer = {"2500"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        long value = validator.askForLong("type long");
        assertThat(value, is(Long.valueOf(answer[0])));
    }

    /**
     * When validator ask about double should check that all is ok.
     */
    @Test
    public void whenValidatorAskAboutDouleShouldCheckThatAllIsOk() {
        String[] answer = {"2.344"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        double value = validator.askForDouble("type double");
        assertThat(value, is(Double.valueOf(answer[0])));
    }

    /**
     * When ask user about number bounded in range should check that app works normal.
     */
    @Test
    public void whenAskUserAboutNumberBoundedInSomeRangeShouldCheckThatWorkFine() {
        String[] answer = {"5"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        int value = validator.ask("type", 0, 10);
        assertThat(value, is(Integer.valueOf(answer[0])));
    }

    /**
     * When ask user about number bounded in range but user type not number.
     * Should check that app informed about it.
     */
    @Test
    public void whenAksUserAboutNumberBoundedInRangeButUserTypeNotNumberShouldCheckInfo() {
        String[] answer = {"it is not number", "8"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        int value = validator.ask("number", 0, 10);
        assertThat(stubIO.getOut(), containsString("Dear user, please type a number"));
    }

    /**
     * When user ask about menu options, but user type wrong number options.
     * Should check that app informed about it.
     */
    @Test
    public void whenAskUserAboutMenuOptionButUserTypeAWrongNumber() {
        String[] answer = {"100", "8"};
        StubIO stubIO = new StubIO(answer);
        IO validator = new Validator(stubIO);
        int value = validator.ask("type a menu options", 0, 8);
        assertThat(stubIO.getOut(), containsString("Dear user, please choose correct options of menu"));
    }


}