package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for RoleStorage.java.
 */
class RoleStorageTest {

    /**
     * When try adding role to role storage should check that role storage accept role.
     */
    @Test
    void whenTryAddRoleToTheStorageShouldCheckThatWorksCorrect() {
        Role role = new Role("author");
        RoleStorage storage = new RoleStorage();
        storage.add(role);

        Role actual = storage.get("author");

        assertThat(actual, is(role));
    }

    /**
     * When try removing role from storage should check that in role storage it not exists.
     */
    @Test
    void whenTryRemoveRoleFromStorageShouldCheckThatRoleWasRemoved() {
        RoleStorage storage = new RoleStorage();
        storage.add(new Role("programmer"));

        storage.remove("programmer");
        Assertions.assertThrows(NoSuchElementException.class, () -> storage.get("programmer"));

    }

    /**
     * When try update exist role at the role storage should check that storage accept changes.
     */
    @Test
    void whenTryUpdateExistValueShouldCheckThatStorageAcceptChanges() {
        RoleStorage storage = new RoleStorage();
        Role codeMonkey = new Role("codemonkey");
        storage.add(codeMonkey);

        storage.update(codeMonkey.getId(), new Role("senior java"));

        assertThat(storage.get("senior java").getId(), is("senior java"));
    }
}
