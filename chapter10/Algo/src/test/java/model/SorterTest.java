package model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 19.04.2017
 */
public class SorterTest {

    /**
     * When try create sorter should check that is not null.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryCreateSorterShouldCheckThatIsNotNull() throws Exception {
        assertThat(new Sorter(new ArrayList<>()), is(notNullValue()));
    }

    /**
     * When try sort should check that points sorted.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTrySortPointShouldCheckThatPointSortedFromSmallToBig() throws Exception {
        Point one = new Point(-5, -5);
        Point two = new Point(-5, 5);
        Point three = new Point(5, 5);
        Point four = new Point(5, -5);
        Point[] points = new Point[]{two, three, four, one};
        Set<Point> actual = new Sorter(Arrays.asList(points)).getSortedPoints();
        Iterator<Point> iterator = actual.iterator();
        Point first = iterator.next();
        assertThat(first.getX(), is(-5));
        assertThat(first.getY(), is(-5));
    }
}