package models;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.01.2017
 *
 * Unit test for Square.java
 */
public class SquareTest {


    /**
     * Check that algorithm correct works with one island.
     */
    @Test
    public void whenCalculateSimpleArrayShouldCheckThatAllIsCorrect() {
        final int[][] values = new int[][]{{0, 0}, {0, 1}};
        Square square = new Square(values);
        List<Integer> actual = square.findOne();
        assertThat(actual, hasItem(1));
    }


    /**
     * Check that algorithm correct works with other data.
     */
    @Test
    public void whenCalculateMiddleArrayShouldCheckThatAllIsCorrect() {
        final int[][] values = new int[][]
                {
                        {0, 0, 1},
                        {0, 0, 1},
                        {0, 0, 1}
                };
        Square square = new Square(values);
        List<Integer> actual = square.findOne();
        assertThat(actual, hasItem(3));
    }

    /**
     * Check that algorithm correct works with complicated data.
     */
    @Test
    public void whenCalculateTwoIslandShouldCheckAllCorrectness() {
        final int[][] values = new int[][]{
                {0, 1, 0},
                {1, 0, 0},
                {1, 0, 0}
        };
        Square square = new Square(values);
        List<Integer> actual = square.findOne();
        assertThat(actual, hasItem(1));
        assertThat(actual, hasItem(2));
    }

}