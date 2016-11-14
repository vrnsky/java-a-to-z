package arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for Rotate.java.
 * It test algorithm of rotating quad matrix on to 90 degrees.
 */
public class RotateTest {


    /**
     * when try rotate should check that matrix rotated.
     */
    @Test
    public final void whenWeTryRotateMatrixShouldRotatedMatrix() {
        Rotate rotater = new Rotate();
        final int[][] values = new int[][]{{1, 2}, {3, 4}};
        final int[][] expected = {{1, 3}, {2, 4}};

        int[][] result = rotater.rotate90(values);

        assertThat(Arrays.deepEquals(expected, result), is(true));
    }
}
