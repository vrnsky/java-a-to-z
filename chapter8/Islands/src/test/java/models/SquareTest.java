package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.01.2017
 *
 * Unit test for Square.java
 */
class SquareTest {


    /**
     * Check that algorithm correct works with one island.
     */
    @Test
    void whenCalculateSimpleArrayShouldCheckThatAllIsCorrect() {
        final int[][] values = new int[][]{{0, 0}, {0, 1}};
        Square square = new Square(values);
        List<Integer> actual = square.findOne();
        assertThat(actual, hasItem(1));
    }


    /**
     * Check that algorithm correct works with other data.
     */
    @Test
    void whenCalculateMiddleArrayShouldCheckThatAllIsCorrect() {
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
    void whenCalculateTwoIslandShouldCheckAllCorrectness() {
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