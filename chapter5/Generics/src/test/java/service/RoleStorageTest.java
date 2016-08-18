package service;

import org.junit.Test;

import java.util.NoSuchElementException;

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
        Role actual = storage.get("author");

        //Assert block
        assertThat(actual, is(role));
    }

    /**
     * When try remove role from storage should check that in role storage it not exist.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveRoleFromStorageShouldCheckThatRoleWasRemoved() {

        //Assign block
        RoleStorage storage = new RoleStorage();
        storage.add(new Role("programmer"));

        //Action block
        storage.remove("programmer");
        Role actual = storage.get("programmer");

    }

    /**
     * When try update exist role at the role storage should check that storage accept changes.
     */
    @Test
    public void whenTryUpdateExistValueShouldCheckThatStorageAcceptChanges() {

        //Assign block
        RoleStorage storage = new RoleStorage();
        Role codemonkey = new Role("codemonkey");
        storage.add(codemonkey);

        //Action block
        storage.update(codemonkey.getId(), new Role("senior java"));

        //Assert block
        assertThat(storage.get("senior java").getId(), is("senior java"));
    }
}
