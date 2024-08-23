package service;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for User.java.
 */
class UserTest {

    /**
     * When try getting id of user should check that is correct.
     */
    @Test
    void whenTryGetIdOfUserShouldCheckThatIdIsCorrect() {

        //Assign block
        User user = new User("id");

        //Action block
        String actual = user.getId();

        //Assert block
        assertThat(actual, is("id"));
    }

    /**
     * When try set new id for user should check that object save it.
     */
    @Test
    void whenTrySetIdShouldCheckThatUserAcceptChanges() {

        //Assign block
        User user = new User("");

        //Action block
        user.setId("user");

        //Assert block
        assertThat(user.getId(), is("user"));
    }
}
