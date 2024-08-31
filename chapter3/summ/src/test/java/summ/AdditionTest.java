package summ;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for Addition.java.
 */
class AdditionTest {

    /**
     * When try to add two correct numbers should sum it and show result to user.
     */
    @Test
    void whenTryAdditionTwoCorrectNumbersShouldSummItAndShowUser() {

        //Assign block
        String[] answer = new String[]{"1", "2"};
        StubIO stubIO = new StubIO(answer);
        Addition addition = new Addition(stubIO);
        int expected = 3;

        //Act block
        int actual = addition.add();

        //Action block
        assertThat(actual, is(expected));
    }

    /**
     * When try to add one correct integer and one wrong integer,
     * should catch exception. At the real system io exception
     * handle by validator and user ask again about integer.
     */
    @Test
    void whenTryAdditionOneWrongIntAndOneCorrectShouldAskUserAboutCorrectData() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            //Assign block
            String[] answer = new String[]{"asd", "1"};
            StubIO stubIO = new StubIO(answer);
            Addition addition = new Addition(stubIO);

            //Act & action block
            addition.add();
        });
    }
}
