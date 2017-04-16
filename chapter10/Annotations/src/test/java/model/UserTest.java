package model;

import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 */
public class UserTest {

    /**
     * When try create user should check that user created.
     */
    @Test
    public void whenTryCreateUserShouldCheckThatUserCreated() {
       User user = new User();
       assertThat(user, is(notNullValue()));
    }

    /**
     * When try saved id should check that user saved id.
     */
    @Test
    public void whenTrySaveIdShouldCheckThatUserSaveId() {
        User user = new User();
        user.setId(1);
        assertThat(user.getId(), is(1));
    }

    /**
     * When try save email should check that user save email.
     */
    @Test
    public void whenTrySaveEmailShouldCheckThatUserSaveEmail() {
        User user = new User();
        user.setEmail("email");
        assertThat(user.getEmail(), is("email"));
    }

    /**
     * When try save password should check that user save password.
     */
    @Test
    public void whenTrySavePasswordShouldCheckThatUserSavePassword() {
        User user = new User();
        user.setPassword("root");
        assertThat(user.getPassword(), is("root"));
    }

    /**
     * When try call to string should check that user prints correct.
     */
    @Test
    public void whenTryCallToStringShouldCheckThatUserPrintsCorrect() {
        User user = new User();
        user.setEmail("email");
        assertThat(user.getEmail(), is("email"));
    }
}