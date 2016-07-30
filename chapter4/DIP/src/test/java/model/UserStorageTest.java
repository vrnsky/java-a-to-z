package model;

import org.junit.Test;
import start.StubIO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for UserStorage.java
 */
public class UserStorageTest {

    /**
     * When try create new user which not exist in storage
     * Should check that user was added.
     */
    @Test
    public void whenTryCreateNewUserShouldCheckThatApiWorksCorrect() {

        //Assign block
        String[] answer = new String[]{"Egor", "19"};
        StubIO stubIO = new StubIO(answer);
        UserStorage userStorage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "ID\tName\tAge\n" +
                          "0\tEgor\t19\n";

        //Action block
        userStorage.createUser(checker);
        userStorage.showUsers();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try create new user which already exist in storage
     * Should check that user was not added.
     */
    @Test
    public void whenTryCreateNewUserWhichAlreadyInBaseShouldCanceledAddOperation() {

        //Assign block
        String[] answer = new String[]{"Yegor", "19", "Yegor", "19", "0"};
        StubIO stubIO = new StubIO(answer);
        UserStorage storage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "User with given name already exist\n";

        //Action block
        storage.createUser(checker);
        storage.createUser(checker);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try edit exist user should check that app correct edit.
     */
    @Test
    public void whenTryEditExistUserShouldCheckThatApiWorksCorrect() {

        //Assign block
        String[] answer = new String[]{"Egor", "19", "Egor", "19", "0", "Yegor", "0", "19"};
        StubIO stubIO = new StubIO(answer);
        UserStorage storage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "User was edited.\n" +
                          "ID\tName\tAge\n" +
                          "0\tYegor\t19\n";

        //Action block
        storage.createUser(checker);
        storage.editUser(checker);
        storage.showUsers();

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try edit not exist user should check that app notify about it.
     */
    @Test
    public void whenTryEditNoExistingUserShouldCheckThatAppShowInfoAboutIt() {

        //Assign block
        String[] answer = new String[]{"Yegor", "19", "Egor", "25", "1"};
        StubIO stubIO = new StubIO(answer);
        UserStorage storage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "User with given data not exist!\n";

        //Action block
        storage.createUser(checker);
        storage.editUser(checker);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try to remove exist user should check that user was removed.
     */
    @Test
    public void whenTryRemoveExistingUserShouldCheckThatApiWorksCorrect() {

        //Assign block
        String[] answer = new String[]{"Yegor", "19", "Yegor", "19", "0"};
        StubIO stubIO = new StubIO(answer);
        UserStorage userStorage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "User was removed.\n" +
                          "ID\tName\tAge\n";

        //Action block
        userStorage.createUser(checker);
        userStorage.removeUser(checker);
        userStorage.showUsers();

        //Action block
        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try remove not exist user should notify user about it.
     */
    @Test
    public void whenTryRemoveNoExistUserShouldShowInfoAboutIt() {

        //Assign block
        String[] answer = new String[]{"Yegor", "19", "Egor", "20", "0"};
        StubIO stubIO = new StubIO(answer);
        UserStorage storage = new UserStorage(stubIO);
        Checker checker = new EditChecker();
        String expected = "User was added\n" +
                          "User with given data not exist!\n";

        //Action block
        storage.createUser(checker);
        storage.removeUser(checker);

        //Assert block
        assertThat(stubIO.getOut(), is(expected));
    }
}
