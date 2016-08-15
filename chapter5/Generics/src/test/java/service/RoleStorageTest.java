package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit test for RoleStorage.java
 */
public class RoleStorageTest {

    /**
     * When try add role to role storage should check that role storage accept role.
     */
    @Test
    public void whenTryAddRoleToTheStorageShouldCheckThatWorksCorrect() {

        //Assign block
        Role role = new Role("author");
        RoleStorage storage = new RoleStorage();
        storage.add(role);

        //Action block
        Role actual = storage.get(0);

        //Assert block
        assertThat(actual, is(role));
    }

    /**
     * When try remove role from storage should check that in role storage it not exist.
     */
    @Test
    public void whenTryRemoveRoleFromStorageShouldCheckThatRoleWasRemoved() {

        //Assign block
        RoleStorage storage = new RoleStorage();
        storage.add(new Role("programmer"));

        //Action block
        storage.remove(0);
        Role actual = storage.get(0);

        //Assert block
        assertThat(actual, is(nullValue()));
    }

    /**
     * When try update exist role at the role storage should check that storage accept changes.
     */
    @Test
    public void whenTryUpdateExistValueShouldCheckThatStorageAcceptChanges() {

        //Assign block
        RoleStorage storage = new RoleStorage();
        storage.add(new Role("codemonkey"));

        //Action block
        storage.update(0, new Role("cool developer"));

        //Assert block
        assertThat(storage.get(0).getId(), is("cool developer"));
    }
}
