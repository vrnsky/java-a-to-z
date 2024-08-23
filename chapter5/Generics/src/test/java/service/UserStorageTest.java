package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for UserStorage.java.
 * @author evrnsky
 * @version 0.1
 */
class UserStorageTest {

    /**
     * When try adding user to the storage should check that storage add user.
     */
    @Test
    public void whenTryAddUserToUserStorageShouldCheckThatStorageAddedIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("user");

        //Action block
        storage.add(user);
        User actual = storage.get("user");

        //Assert block
        assertThat(actual, is(user));
    }

    /**
     * When try removing user from storage should check that storage remove it.
     */
    @Test
    void whenTryRemoveUserFromStorageShouldCheckThatStorageRemoveIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("user");

        //Action block
        storage.add(user);
        storage.remove("user");

        Assertions.assertThrows(NoSuchElementException.class, () -> storage.get("user"));
    }

    /**
     * When try update exist value in storage should check that storage save changes.
     */
    @Test
    public void whenTryUpdateAlreadyExistValueInStorageShouldCheckThatStorageSaveIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("name");
        User newUser = new User("Yegor");

        //Action block
        storage.add(user);
        storage.update(user.getId(), newUser);

        //Assert block
        assertThat(storage.get(newUser.getId()).getId(), is("Yegor"));
    }
}
