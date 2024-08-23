package model;



import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 */
class UserTest {

    /**
     * When try to create user should check that user created.
     */
    @Test
    void whenTryCreateUserShouldCheckThatUserCreated() {
       User user = new User();
       assertThat(user, is(notNullValue()));
    }

    /**
     * When try saved id should check that user saved id.
     */
    @Test
    void whenTrySaveIdShouldCheckThatUserSaveId() {
        User user = new User();
        user.setId(1);
        assertThat(user.getId(), is(1));
    }

    /**
     * When try save email should check that user save email.
     */
    @Test
    void whenTrySaveEmailShouldCheckThatUserSaveEmail() {
        User user = new User();
        user.setEmail("email");
        assertThat(user.getEmail(), is("email"));
    }

    /**
     * When try save password should check that user save password.
     */
    @Test
    void whenTrySavePasswordShouldCheckThatUserSavePassword() {
        User user = new User();
        user.setPassword("root");
        assertThat(user.getPassword(), is("root"));
    }
}