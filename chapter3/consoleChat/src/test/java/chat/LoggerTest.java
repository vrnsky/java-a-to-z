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
    private static final String RESOURCE_PATH = String.format("%s%s%s", FileUtils.getTempDirectoryPath(), File.separator, "text.txt");

    /**
     * When try write some data log should check that it is saved.
     */
    @Test
    public void whenWriteSomeDataToLogShouldCheckThatItSaved() {

        //Assign block
        Logger logger = null;
        Optional<Answerer> answerer = Optional.empty();
        String expected = "Hello!";
        try {
            logger = new Logger(RESOURCE_PATH);

            //Act block
            logger.log("Hello!");
            answerer = Optional.of(new Answerer(RESOURCE_PATH));
        } catch (IOException exp) {
            exp.printStackTrace();
        }


        String actual = "";
        if(answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        }

        //Assert block
        assertThat(actual, is(expected));
    }
}

