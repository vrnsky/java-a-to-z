package ru.evrnsky.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for EditChecker.java.
 */
class EditCheckerTest {

    /**
     * When try check may edit exist user should check that checker return true.
     */
    @Test
    void whenTryCheckMayEditExistUserShouldCheckThatReturnTrue() {
        User user = new StorageUser("Java", 20);
        User[] users = new User[1];
        users[0] = user;
        Checker checker = new EditChecker();

        //Action block
        boolean actual = checker.check(users, user);

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try check not exist user should check that checker return false.
     */
    @Test
    void whenTryCheckMayEditNonExistUserShouldCheckThatReturnFalse() {

        //Assign block
        User user = new StorageUser("Java", 20);
        User[] users = new User[3];
        users[0] = new StorageUser("First element", 0);
        users[1] = new StorageUser("Second element", 1);
        users[2] = new StorageUser("Third element", 2);
        Checker checker = new EditChecker();

        //Action block
        boolean actual = checker.check(users, user);

        //Assert block
        assertThat(actual, is(false));
    }
}
