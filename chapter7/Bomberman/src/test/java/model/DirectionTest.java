package model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 */
public class DirectionTest {

    /**
     * When try to get random direction should check that not null.
     * @throws Exception if some problem.
     */
    @Test
    public void whenTryGetRandomDirectionShouldCheckThatNotNull() throws Exception {
        Direction direction = Direction.getRandomDirection();
        assertThat(direction, is(notNullValue()));
    }
}