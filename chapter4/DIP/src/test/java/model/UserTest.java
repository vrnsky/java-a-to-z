package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for User.java.
 */

public class UserTest {

    /**
     * When try create new user should check that constructor works correct.
     */
    @Test
    public void whenTryCreateNewUserUseConstructorShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("Egor", 19);

        //Action block
        boolean actual = user != null;

        //Assert block
        assertThat(actual, is(true));
    }

    /**
     * When try get name of user should check that works correct.
     */
    @Test
    public void whenTryGetNameOfUserShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("Java", 20);
        String expected = "Java";

        //Action block
        String actual = user.getName();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try get age of user should check that works corrects.
     */
    @Test
    public void whenTryGetAgeOfUserShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("HTML", 30);
        int expected = user.getAge();

        //Action block
        int actual = user.getAge();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try set and get id should check that get new id.
     */
    @Test
    public void whenTrySetAndGetIdShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("No name", 0);
        int expected = 1;

        //Action block
        user.setId(1);
        int actual = user.getId();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try set and get name should check that get new name.
     */
    @Test
    public void whenTrySetAndGetNameShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("OldName", 0);
        String expected = "NewName";

        //Action block
        user.setName("NewName");
        String actual = user.getName();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try set and get age should check that get new age.
     */
    @Test
    public void whenTrySetAndGetAgeShouldCheckThatWorksCorrect() {

        //Assign block
        User user = new User("Google", 0);
        int expected = 25;

        //Action block
        user.setAge(25);
        int actual = user.getAge();

        //Assert block
        assertThat(actual, is(expected));
    }
}
