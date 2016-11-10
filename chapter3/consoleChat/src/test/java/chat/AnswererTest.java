package chat;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Unit test for Answerer.java - it is return a random string from file.
 */
public class AnswererTest {

    /**
     * When try get a random string from from file should get random string from file.
     * Attention method can throw null pointer exception if file was not found for avoid it use absolute path.
     */
    @Test
    public void whenTryGetARandomStringFromAnswerFileShouldReturnAStringFromFile() throws IOException {
        Optional<Answerer> answerer;
        String expected = "Hello!";
        answerer = Optional.of(new Answerer(String.format("%s%s%s", FileUtils.getTempDirectoryPath(), File.separator, "text.txt")));

        String actual = "";
        if(answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        } else {
            System.out.println("Something wrong, please check the files");
        }

        assertThat(actual, is(expected));

    }
}
