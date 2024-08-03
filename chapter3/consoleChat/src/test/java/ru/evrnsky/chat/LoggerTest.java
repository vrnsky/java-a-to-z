package ru.evrnsky.chat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.io.File;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Unit test for Logger.java.
 */
class LoggerTest {

    /**
     * When try writing some data log should check that it is saved.
     * @throws IOException if i/o errors detected.
     */
    @Test
    void whenWriteSomeDataToLogShouldCheckThatItSaved() throws IOException {
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
    void whenTryToCloseLoggerShouldCheckThatAllIsOk() throws IOException {
        File temp = File.createTempFile("logger", ".txt");
        Logger logger = new Logger(temp.getAbsolutePath());
        logger.close();
    }

    /**
     * When something was wrong and logger closed. should check that all is ok.
     * @throws IOException if io error detected.
     */
    @Test
    void whenTryCloseLoggerButLoggerThrowExceptionShouldCheckThatAppThrowException() {
        Assertions.assertThrows(IOException.class, () -> {
            Logger logger = mock(Logger.class);
            doThrow(IOException.class).when(logger).close();
            logger.close();
        });
    }

}

