package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for User.java.
 */
public class UserTest {

    /**
     * When try get id of user should check that is correct.
     */
    @Test
    public void whenTryGetIdOfUserShouldCheckThatIdIsCorrect() {

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
    public void whenTrySetIdShouldCheckThatUserAcceptChanges() {

        //Assign block
        User user = new User("");

        //Action block
        user.setId("user");

        //Assert block
        assertThat(user.getId(), is("user"));
    }
}
