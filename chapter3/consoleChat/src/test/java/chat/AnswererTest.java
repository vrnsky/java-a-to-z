package chat;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Unit test for Answerer.java - it is return a random string from file.
 */
public class AnswererTest {

    /**
     * When try get a random string from from file should get random string from file.
     * Attention method can throw null pointer exception if file was not found for avoid it use absolute path.
     * @throws IOException if i/o error detected.
     * @throws InterruptedException if some problem with threads.
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
        if (answerer.isPresent()) {
            actual = answerer.get().getRandomString();
        } else {
            System.out.println("Something wrong, please check the files");
        }

        assertThat(actual, is(expected));

    }
}
