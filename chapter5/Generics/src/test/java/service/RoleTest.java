package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for Role.java
 * @author evrnsky
 * @version 0.1
 */
public class RoleTest {

    /**
     * When try get id of role should check that is correct id.
     */
    @Test
    public void whenTryGetIdOfRoleShouldCheckThatIsCorrectId() {

        //Assign block
        Role admin = new Role("admin");

        //Assert block
        assertThat(admin.getId(), is("admin"));
    }

    /**
     * When try set new id of role should check that role accept change.
     */
    @Test
    public void whenTrySetNewIdOfRoleShouldCheckThatRoleAcceptChanges() {

        //Assign block
        Role user = new Role("user");

        //Action block
        user.setId("admin");

        //Assert block
        assertThat(user.getId(), is("admin"));
    }
}
