package service;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Role.java.
 * @author evrnsky
 * @version 0.1
 */
class RoleTest {

    /**
     * When try getting id of role should check that is correct id.
     */
    @Test
    void whenTryGetIdOfRoleShouldCheckThatIsCorrectId() {
        Role admin = new Role("admin");
        assertThat(admin.getId(), is("admin"));
    }

    /**
     * When try set new id of role should check that role accept change.
     */
    @Test
    void whenTrySetNewIdOfRoleShouldCheckThatRoleAcceptChanges() {
        Role user = new Role("user");

        user.setId("admin");

        assertThat(user.getId(), is("admin"));
    }
}
