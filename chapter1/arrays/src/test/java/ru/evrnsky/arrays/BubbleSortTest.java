package ru.evrnsky.arrays;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for BubbleSort.java.
 * It test implementation of bubble sort algorithm.
 */
class BubbleSortTest {
    /**
     * try to sort by ascending.
     */
    @Test
    void whenPassInSortMethodArrayShouldSortByAscending() {
        BubbleSort sorter = new BubbleSort();
        final int[] randomArray = new int[]{5, 3, 2, 4, 6, 1, 7};
        final int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7};

        sorter.sort(randomArray);

        assertThat(randomArray, is(expectedArray));
    }
}
