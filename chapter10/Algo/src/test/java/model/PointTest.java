package model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * @author evrnsky.
 * @version 0.1
 * @since 19.04.2017
 * <p>
 * This unit test for point.
 */
class PointTest {

    /**
     * When try crate a point should check that all is ok.
     */
    @Test
    void whenTryCreateAPointShouldCheckThatAllIsOk() {
        assertThat(new Point(1, 2), is(notNullValue()));
    }

    /**
     * When try get x should check that point return correct data.
     */
    @Test
    void whenTryGetXShouldCheckThatPointReturnCorrectData() {
        Point point = new Point(1, 2);
        assertThat(point.getX(), is((1)));
    }

    /**
     * When try get y should check that point return correct data..
     */
    @Test
    void whenTryGetYShouldCheckThatPointReturnCorrectData() {
        Point point = new Point(1, 2);
        assertThat(point.getY(), is((2)));
    }


}