package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Role.java.
 * @author evrnsky
 * @version 0.1
 */
public class RoleTest {

    /**
     * When try get id of role should check that is correct id.
     */
    @Test
    public void whenTryGetIdOfRoleShouldCheckThatIsCorrectId() {
        Role admin = new Role("admin");
        assertThat(admin.getId(), is("admin"));
    }

    /**
     * When try set new id of role should check that role accept change.
     */
    @Test
    public void whenTrySetNewIdOfRoleShouldCheckThatRoleAcceptChanges() {
        Role user = new Role("user");

        user.setId("admin");

        assertThat(user.getId(), is("admin"));
    }
}
