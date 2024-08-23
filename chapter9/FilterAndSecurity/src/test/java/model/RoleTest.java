package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test for role.
 * @author evrnsky
 * @version 0.1
 * @since 15.04.2017
 */
class RoleTest {

    /**
     * When try to create role should check that is created.
     */
    @Test
    void whenCreateRoleShouldCheckThatAllIsOk() {
        Role role = new Role("admin");
        Assertions.assertNotNull(role);
    }

    /**
     * When create a role should check that get method works.
     */
    @Test
    void whenCreateRoleShouldCheckThatGetMethodWork() {
        Role role = new Role("admin");
        assertThat(role.getDesc(), is("admin"));
    }

    /**
     * when update desc should check that all is ok.
     */
    @Test
    void whenUpdateDescShouldCheckThatAllIsOk() {
        Role role = new Role("admin");
        role.setDesc("super admin");
        assertThat(role.getDesc(), is("super admin"));
    }
}