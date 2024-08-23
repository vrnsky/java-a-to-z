package model;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;


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