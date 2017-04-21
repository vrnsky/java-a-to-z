package model;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 19.04.2017
 */
public class SorterTest {

    /**
     * When square should check that points sorted.
     * @throws Exception if some problems.
     */
    @Test
    public void whenSquareShouldCheckThatAllIsOk() throws Exception {
        Point one = new Point(1, 1);
        Point two = new Point(1, 2);
        Point three = new Point(2, 2);
        Point four = new Point(2, 1);
        List<Point> data = Arrays.asList(two, one, three, four);
        List<Point> actual = new Sorter(data).getSortedPoints();
        assertThat(actual, is(contains(one, two, three, four)));
    }

    /**
     * When square should check that points sorted.
     * @throws Exception if some problems.
     */
    @Test
    public void whenSquareShouldCheckThatPointSorted() throws Exception {
        Point one = new Point(1, 1);
        Point two = new Point(1, 2);
        Point three = new Point(2, 2);
        Point four = new Point(2, 1);
        List<Point> data = Arrays.asList(one, two, four, three);
        List<Point> actual = new Sorter(data).getSortedPoints();
        assertThat(actual, is(contains(one, two, three, four)));
    }
}