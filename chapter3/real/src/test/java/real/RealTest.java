package real;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import start.StubIO;

/**
 * Unit test for Real.java
 */
public class RealTest {

    /**
     * When user input all data correct should execute main task of program
     * Find min in three double values
     */
    @Test
    public void whenUserInputCorrectAllDataShouldShowResultOfComputing() {

        //Assign block
        String[] answer = new String[] {"1.4", "1.54", "-1.77",""};
        StubIO stubIO = new StubIO(answer);
        Real real = new Real(stubIO);
        double expected = 1.4;

        //Act block
        double actual = real.getMin();

        //Action block
        assertThat(actual, is(expected));
    }

    /**
     * If user entered bad data should check that app say about it user
     * In real system exception handles and ask user about data again
     */
    @Test
    public void whenUserInputWrongShouldCheckThanAppThrowException() {

        //Assign block
        String[] answer = new String[] {"1.3","dd",""};
        StubIO stubIO = new StubIO(answer);
        Real real = new Real(stubIO);
        String expected = "You should enter a double number, nothing else!";

        //Act & action block
        real.getMin();

        //Action block
        assertThat(stubIO.getOut(), containsString(expected));

    }
}
