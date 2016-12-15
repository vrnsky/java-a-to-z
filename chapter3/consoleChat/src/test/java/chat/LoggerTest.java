package chat;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Logger.java.
 */
public class LoggerTest {

    /**
     * When try write some data log should check that it is saved.
     */
    @Test
    public void whenWriteSomeDataToLogShouldCheckThatItSaved() throws IOException {
        File temp = File.createTempFile("logger", ".txt");
        Logger logger = null;
        Optional<Answerer> answerer;
        String expected = "Hello!";
        logger = new Logger(temp.getAbsolutePath());
        logger.log(expected);
        answerer = Optional.of(new Answerer(temp.getAbsolutePath()));
        String actual = "";
        if(answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        }
        assertThat(actual, is(expected));
    }
}

