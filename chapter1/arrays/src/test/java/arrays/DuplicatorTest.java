package arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Unit test for Duplicator.java.
 * It test algorithm of removing duplicates from string array.
 */
public class DuplicatorTest {
    /**
     * Try to delete duplicate.
     */
    @Test
    public final void whenPassToMethodDeleteDuplicatesShouldOnlyUniqueString() {
        Duplicator deleteDuplicator = new Duplicator();
        String[] values = new String[]{"A", "C", "C", "A", "B", "A"};
        String[] expectedValues = new String[]{"A", "C", "B"};

        String[] result = deleteDuplicator.removeDuplicates(values);

        assertThat(result, is(expectedValues));
    }
}

