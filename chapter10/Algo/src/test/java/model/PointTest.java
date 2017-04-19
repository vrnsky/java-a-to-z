package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky.
 * @version 0.1
 * @since 19.04.2017
 *
 * This unit test for point.
 */
public class PointTest {

    /**
     * When try crate a point should check that all is ok.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryCreateAPointShouldCheckThatAllIsOk() throws Exception {
        assertThat(new Point(1, 2), is(notNullValue()));
    }

    /**
     * When try get x should check that point return correct data.
     * @throws Exception if some problem was happened.
     */
    @Test
    public void whenTryGetXShouldCheckThatPointReturnCorrectData() throws Exception {
        Point point = new Point(1, 2);
        assertThat(point.getX(), is((1)));
    }

    /**
     * When try get y should check that point return correct data.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryGetYShouldCheckThatPointReturnCorrectData() throws Exception {
        Point point = new Point(1, 2);
        assertThat(point.getY(), is((2)));
    }


}