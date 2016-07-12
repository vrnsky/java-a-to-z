package summ;

import org.junit.Test;
import start.StubIO;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test for Addition.java.
 */
public class AdditionTest {

    /**
     * When try add two correct numbers should sum it and show result to user.
     */
    @Test
    public void whenTryAdditionTwoCorrectNumbersShouldSummItAndShowUser() {

        //Assign block
        String[] answer = new String[]{"1","2"};
        StubIO stubIO = new StubIO(answer);
        Addition addition = new Addition(stubIO);
        int expected = 3;

        //Act block
        int actual = addition.add();

        //Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try add one correct integer and one wrong integer,
     * should catch exception. At the real system io exception
     * handle by validator and user ask again about integer.
     */
    @Test(expected = NumberFormatException.class)
    public void whenTryAdditionOneWrongIntAndOneCorrectShouldAskUserAboutCorrectData() {

        //Assign block
        String[] answer = new String[]{"asd", "1"};
        StubIO stubIO = new StubIO(answer);
        Addition addition = new Addition(stubIO);

        //Act & action block
        addition.add();

    }
}
