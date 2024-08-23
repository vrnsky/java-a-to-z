package ru.evrnsky.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * Unit test for Duplicator.java.
 * It test algorithm of removing duplicates from string array.
 */
class DuplicatorTest {
    /**
     * Try to delete duplicate.
     */
    @Test
    void whenPassToMethodDeleteDuplicatesShouldOnlyUniqueString() {
        Duplicator deleteDuplicator = new Duplicator();
        String[] values = new String[]{"A", "C", "C", "A", "B", "A"};
        String[] expectedValues = new String[]{"A", "C", "B"};

        String[] result = deleteDuplicator.removeDuplicates(values);

        Assertions.assertTrue(Arrays.deepEquals(expectedValues, result));
    }
}

