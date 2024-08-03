package ru.evrnsky.chat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Answerer.java - it is return a random string from file.
 */
class AnswererTest {

    /**
     * When try getting a random string from file should get random string from file.
     * Attention method can throw null pointer exception if file was not found for avoid it use absolute path.
     *
     * @throws IOException          if i/o error detected.
     * @throws InterruptedException if some problem with threads.
     */
    @Test
    void whenTryGetARandomStringFromAnswerFileShouldReturnAStringFromFile() throws IOException, InterruptedException {
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
     * @throws NullPointerException instance of exception.
     */
    @Test
    void whenAnswererTryToReadNotExistFileShouldCheckThatAppThrownException() {
        Assertions.assertThrows(NullPointerException.class, () ->  new Answerer(AnswererTest.class.getClassLoader().getResourceAsStream("abs.txt")));
    }

    /**
     * When answerer created and ready to work should check that all data saved at the answerer.
     *
     * @throws IOException if something wrong with io system.
     */
    @Test
    void whenAnswererCreatedAndReadyToWorkShouldCheckThatAllDataSavedAtTheAnswerer() throws IOException {
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
