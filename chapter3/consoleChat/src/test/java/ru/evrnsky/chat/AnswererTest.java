package ru.evrnsky.chat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Unit test for Answerer.java - it is return a random string from file.
 */
public class AnswererTest {

    /**
     * When try get a random string from from file should get random string from file.
     * Attention method can throw null pointer exception if file was not found for avoid it use absolute path.
     *
     * @throws IOException          if i/o error detected.
     * @throws InterruptedException if some problem with threads.
     */
    @Test
    public void whenTryGetARandomStringFromAnswerFileShouldReturnAStringFromFile() throws IOException, InterruptedException {
        Optional<Answerer> answerer;
        String expected = "Hello!";

        answerer = Optional.of(new Answerer(AnswererTest.class.getClassLoader().getResourceAsStream("one.txt")));
        String actual = "";
        if (answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        } else {
            System.out.println("Something wrong, please check the files");
        }

        assertThat(actual, is(expected));
    }

    /**
     * When answer try to read not exist file should check that app throw exception.
     *
     * @throws Exception instance of exception.
     */
    @Test(expected = NullPointerException.class)
    public void whenAnswererTryToReadNotExistFileShouldCheckThatAppThrownException() throws Exception {
        Answerer answerer = new Answerer(AnswererTest.class.getClassLoader().getResourceAsStream("abs.txt"));
    }

    /**
     * When answerer created and ready to work should check that all data saved at the answerer.
     *
     * @throws IOException if something wrong with io system.
     */
    @Test
    public void whenAnswererCreatedAndReadyToWorkShouldCheckThatAllDataSavedAtTheAnswerer() throws IOException {
        String expected = "Hello!\nHello, ${username}!\nAt this night we have noticed!";
        Optional<Answerer> answerer = Optional.of(new Answerer(AnswererTest.class.getClassLoader().getResourceAsStream("answers.txt")));
        List<String> actual = null;
        if (answerer.isPresent()) {
            actual = answerer.get().getAllStrings();
        } else {
            System.out.println("Something wrong, please check the files");
        }
        String[] splitExpected = expected.split("\n");
        int index = 0;
        for (String str : actual) {
            assertThat(str, is(splitExpected[index++]));
        }
    }
}
