package chat;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
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
    public void whenTryGetARandomStringFromAnswerFileShouldReturnAStringFromFile() throws IOException, InterruptedException {
        Optional<Answerer> answerer;
        String expected = "Hello!";
        File temp = File.createTempFile("textemp", ".txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp)));
        writer.write(expected);
        writer.flush();
        writer.close();


        answerer = Optional.of(new Answerer(String.format("%s", temp.getAbsoluteFile())));
        String actual = "";
        if(answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        } else {
            System.out.println("Something wrong, please check the files");
        }

        assertThat(actual, is(expected));

    }
}
