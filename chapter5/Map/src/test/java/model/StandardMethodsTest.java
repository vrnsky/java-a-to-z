package model;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * Unit test for standard method of map interface.
 */
public class StandardMethodsTest {

    /**
     * Check that map replaces objects with same keys.
     */
    @Test
    public void checkThatMapReplaceObjectWithSameKeys() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        StandardMethods.main(new String[]{"a", "b"});
        assertThat(out.toString(), both(containsString("second")).and(not(containsString("first"))));
    }
}