package model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for role.
 * @author evrnsky
 * @version 0.1
 * @since 15.04.2017
 */
public class RoleTest {

    /**
     * When try create role should check that is created.
     */
    @Test
    public void whenCreateRoleShouldCheckThatAllIsOk() {
        Role role = new Role("admin");
        assertThat(role != null, is(true));
    }

    /**
     * When create a role should check that get method works.
     */
    @Test
    public void whenCreateRoleShouldCheckThatGetMethodWork() {
        Role role = new Role("admin");
        assertThat(role.getDesc(), is("admin"));
    }

    /**
     * when update desc should check that all is ok.
     */
    @Test
    public void whenUpdateDescShouldCheckThatAllIsOk() {
        Role role = new Role("admin");
        role.setDesc("super admin");
        assertThat(role.getDesc(), is("super admin"));
    }
}