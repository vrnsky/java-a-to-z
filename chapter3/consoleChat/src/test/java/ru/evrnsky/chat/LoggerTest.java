package ru.evrnsky.chat;
import java.io.IOException;
import org.junit.Test;
import ru.evrnsky.chat.Answerer;
import ru.evrnsky.chat.Logger;

import java.io.File;
import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Unit test for Logger.java.
 */
public class LoggerTest {

    /**
     * When try write some data log should check that it is saved.
     * @throws IOException if i/o errors detected.
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
        if (answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        }
        assertThat(actual, is(expected));
    }

    /**
     * When try check that logger successful closed should check that all is ok.
     * @throws IOException if problem with creating temporary file.
     */
    @Test
    public void whenTryToCloseLoggerShouldCheckThatAllIsOk() throws IOException {
        File temp = File.createTempFile("logger", ".txt");
        Logger logger = new Logger(temp.getAbsolutePath());
        logger.close();
    }

    /**
     * When something was wrong and logger closed. should check that all is ok.
     * @throws IOException if io error detected.
     */
    @Test(expected = IOException.class)
    public void whenTryCloseLoggerButLoggerThrowExceptionShouldCheckThatAppThrowException() throws IOException {
        Logger logger = mock(Logger.class);
        doThrow(IOException.class).when(logger).close();
        logger.close();
    }

}

