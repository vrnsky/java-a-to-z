package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *  Unit test for SimpleGenerator.java.
 */
public class SimpleGeneratorTest {

    /**
     * When try generate string with correct counts of place for insert data
     * Should check that is string generates correct.
     */
    @Test
    public void whenTryGenerateWithStringWithCorrectCountParamShouldCheckThatGenerateStringIsCorrect() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${name}!";
        String[] data = new String[]{"Egor"};
        String expected =  "Hello, Egor!";

        //Action block
        String actual = generator.generate(template, data);

        //Assert block
        assertThat(actual, is(expected));
    }


    /**
     * Check by give generator more values than in template.
     * Should check that generator throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGenerateStringWithWrongCountMoreValuesThenKeyShouldCheckThatAppThrowException() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${user}!";
        String[] data = new String[]{"Java", "Spring", "HTML"};

        //Action block
        String actual = generator.generate(template, data);
    }

    /**
     * Check by give generator keys more than values.
     * Should check that generator throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGenerateStringWithWrongCountMoreKeysThatValuesShouldCheckThatAppThrowException() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${user}, ${first}, ${second}";
        String[] data = new String[]{"evrnsky"};

        //Action block
        String actual = generator.generate(template, data);
    }

    /**
     * Check by give generator null as data.
     * Should check that app throw correct exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGenerateWithNullDataShouldCheckThatAppThrowException() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = "Hello, ${user}";
        String[] data = null;

        //Action block
        String actual = generator.generate(template, data);
    }

    /**
     * Check by give null string as template.
     * Should check that app throw correct exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGenerateStringGiveNullStringShouldCheckThatGeneratorWorksCorrect() {

        //Assign block
        Template generator = new SimpleGenerator();
        String template = null;
        String[] data = new String[]{"test"};

        //Action block
        String actual = generator.generate(template, data);

    }
}
