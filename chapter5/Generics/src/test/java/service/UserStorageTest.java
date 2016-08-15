package service;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit test for UserStorage.java
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
        User actual = storage.get(0);

        //Assert block
        assertThat(actual, is(user));
    }

    /**
     * When try remove user from storage should check that storage remove it.
     */
    @Test
    public void whenTryRemoveUserFromStorageShouldCheckThatStorageRemoveIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("user");

        //Action block
        storage.add(user);
        storage.remove(0);

        //Assert block
        assertThat(storage.get(0), is(nullValue()));
    }

    /**
     * When try update exist value in storage should check that storage save changes.
     */
    @Test
    public void whenTryUpdateAlreadyExistValueInStorageShouldCheckThatStorageSaveIt() {

        //Assign block
        UserStorage storage = new UserStorage();
        User user = new User("name");

        //Action block
        storage.add(user);
        storage.update(0, new User("Yegor"));

        //Assert block
        assertThat(storage.get(0).getId(), is("Yegor"));
    }
}
