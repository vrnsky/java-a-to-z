package chat;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Logger.java.
 */
public class LoggerTest {

    /**
     * At this path exist all resources files.
     */
    private static final String RESOURCE_PATH = "F:\\java-a-to-z\\iml\\test.txt";

    /**
     * When try write some data log should check that it is saved.
     */
    @Test
    public void whenWriteSomeDataToLogShouldCheckThatItSaved() {

        //Assign block
        Logger logger = null;
        Answerer answerer = null;
        try {
            logger = new Logger(RESOURCE_PATH);

            //Act block
            logger.log("Hello!");
            answerer = new Answerer(RESOURCE_PATH);
            String expected = "Hello!";
            String actual = answerer.getRandomString();

            //Action block
            assertThat(actual, is(expected));
        } catch(IOException exp) {
            exp.printStackTrace();
        }
    }
}
