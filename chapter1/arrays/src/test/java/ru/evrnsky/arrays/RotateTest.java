package ru.evrnsky.arrays;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Unit test for Rotate.java.
 * It testing algorithm of rotating quad matrix on to 90 degrees.
 */
class RotateTest {


    /**
     * when try rotate should check that matrix rotated.
     */
    @Test
    void whenWeTryRotateMatrixShouldRotatedMatrix() {
        Rotate rotater = new Rotate();
        final int[][] values = new int[][]{{1, 2}, {3, 4}};
        final int[][] expected = {{1, 3}, {2, 4}};

        int[][] result = rotater.rotate90(values);

        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }
}
