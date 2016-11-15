package storage;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class UserStorageTest {

    /**
     * Instance of storage.
     */
    private final static UserStorage USER_STORAGE = new UserStorage();

    /**
     * When try add user to storage should check that user add.
     */
    @Test
    public final void whenAddUserToStorageShouldCheckStorage() {
        final int amount = 0;
        User user = new User(amount);
        boolean actual = USER_STORAGE.add(user);
        assertThat(actual, is(true));
    }

    /**
     * When update user should check that storage actual.
     */
    @Test
    public final void whenUpdateUserShouldCheckThatAllFine() {
        final int amount = 120;
        final int increaseAmount = 150;
        User oldUser = new User(amount);
        USER_STORAGE.add(oldUser);
        User editableUser = USER_STORAGE.readUserById(oldUser.getId());
        editableUser.setAmount(increaseAmount);
        USER_STORAGE.editUser(editableUser);
        assertThat(USER_STORAGE.readUserById(oldUser.getId()).getAmount(), is(increaseAmount));
    }

    /**
     * When remove user should check that storage delete user.
     */
    @Test
    public final void whenRemoveUserShouldCheckThatStorageDelUser() {
        final int amount = 120;
        User user = new User(amount);
        USER_STORAGE.add(user);
        USER_STORAGE.remove(user.getId());
        assertThat(USER_STORAGE.readUserById(user.getId()), nullValue());
    }

    /**
     * When transaction perform should check that all fine executed.
     */
    @Test
    public final void whenTransactionPerformShouldCheckThatAllFine() {
        final int amountOne = 100;
        final int amountTwo = 50;
        final int transactionValue = 50;
        User userOne = new User(amountOne);
        User userTwo = new User(amountTwo);
        USER_STORAGE.add(userOne);
        USER_STORAGE.add(userTwo);
        USER_STORAGE.transactionAmount(userOne.getId(), userTwo.getId(), transactionValue);
        final int actualAmountOne = USER_STORAGE.readUserById(userOne.getId()).getAmount();
        final int actualAmountTwo = USER_STORAGE.readUserById(userTwo.getId()).getAmount();
        assertThat(actualAmountOne, is(amountTwo));
        assertThat(actualAmountTwo, is(amountOne));
    }

}