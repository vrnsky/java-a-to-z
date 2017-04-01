package service;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for UserStorage.java.
 * @author evrnsky
 * @version 0.1
 */
public class UserStorageTest {

    /**
     * When try add user to the storage should check that storage add user.
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
     * When try remove user from storage should check that storage remove it.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryRemoveUserFromStorageShouldCheckThatStorageRemoveIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("user");

        //Action block
        storage.add(user);
        storage.remove("user");
        storage.get("user");
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
