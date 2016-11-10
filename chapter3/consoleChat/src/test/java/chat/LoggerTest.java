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
     * At this path exist all resources files.
     */
    private static final String RESOURCE_PATH = String.format("%s%s", FileUtils.getTempDirectoryPath(), "text.txt");

    /**
     * When try write some data log should check that it is saved.
     */
    @Test
    public void whenWriteSomeDataToLogShouldCheckThatItSaved() throws IOException {
        System.out.println(RESOURCE_PATH);
        Logger logger = null;
        Optional<Answerer> answerer;
        String expected = "Hello!";
        logger = new Logger(RESOURCE_PATH);
        logger.log("Hello!");
        answerer = Optional.of(new Answerer(RESOURCE_PATH));
        String actual = "";
        if(answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        }
        assertThat(actual, is(expected));
    }
}

