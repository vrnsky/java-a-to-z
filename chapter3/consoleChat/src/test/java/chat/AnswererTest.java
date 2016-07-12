package chat;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.IOException;

/**
 * Unit test for Answerer.java - it is return a random string from file.
 */
public class AnswererTest {

    /**
     * When try get a random string from from file should get random string from file
     * Attention method can throw null pointer exception if file was not found for avoid it use absolute path.
     */
    @Test
    public void whenTryGetARandomStringFromAnswerFileShouldReturnAStringFromFile() {

        //Assign block
        Answerer answerer = null;
        String expected = "Hello!";
        try {
            answerer = new Answerer("F:\\java-a-to-z\\iml\\reply.txt");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //Act block
        String actual = answerer.getRandomString();

        //Action block
        assertThat(actual, is(expected));

    }
}
