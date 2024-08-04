package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for SimpleGenerator.java.
 */
class SimpleGeneratorTest {

    /**
     * When try generating string with correct counts of place for insert data
     * Should check that is string generates correct.
     */
    @Test
    void whenTryGenerateWithStringWithCorrectCountParamShouldCheckThatGenerateStringIsCorrect() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${name}!";
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("name", "Egor");
        String expected = "Hello, Egor!";

        //Action block
        String actual = generator.generate(template, dictionary);

        //Assert block
        assertThat(actual, is(expected));
    }


    /**
     * Check by give generator more values than in template.
     * Should check that generator throw exception.
     */
    @Test
    void whenTryGenerateStringWithWrongCountMoreValuesThenKeyShouldCheckThatAppThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Assign block
            Template generator = new SimpleGenerator();
            String template = "Hello, ${user}!";
            Map<String, String> dictionary = new HashMap<>();
            dictionary.put("user", "Java");
            dictionary.put("other", "Spring");
            dictionary.put("HTML", "html");
            String expected = "Hello, Java!";

            //Action block
            String actual = generator.generate(template, dictionary);

            //Assert block
            assertThat(actual, is(expected));
        });
    }

    /**
     * Check by give generator keys more than values.
     * Should check that generator throw exception.
     */
    @Test
    void whenTryGenerateStringWithWrongCountMoreKeysThatValuesShouldCheckThatAppThrowException() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${user}, ${first}, ${second}";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("user", "evrnsky");
        dictionary.put("first", "google");
        dictionary.put("third", "test");

        //Action block
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(template, dictionary));
    }

    /**
     * Check by give generator null as data.
     * Should check that app throw correct exception.
     */
    @Test
    void whenTryGenerateWithNullDataShouldCheckThatAppThrowException() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${user}";
        Map<String, String> data = null;

        //Action block
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(template, data));
    }

    /**
     * Check by give null string as template.
     * Should check that app throw correct exception.
     */
    @Test
    void whenTryGenerateStringGiveNullStringShouldCheckThatGeneratorWorksCorrect() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = null;
        Map<String, String> data = new HashMap<String, String>();
        data.put("one", "else");

        //Action block
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(template, data));

    }
}
