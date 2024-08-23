package model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for User.java.
 */
class UserTest {

    /**
     * When create a simple user should check that user have name.
     */
    @Test
    void whenCreateASimpleUserShouldCheckThatUserHaveName() {

        //Assign block
        String expected = "Google";
        User user = new User(expected);

        //Action block
        String actual = user.getName();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When create a middle full profile should check that user have children.
     */
    @Test
    void whenCreateAMiddleUserShouldCheckThatUserHaveCountOfKids() {

        //Assign block
        int expected = 2;
        User user = new User("Vasya", expected);

        //Action block
        int actual = user.getChildren();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When create full profile should check that birthday is legal.
     */
    @Test
    void whenCreateFullUserShouldCheckThatUserHaveBirthday() {

        //Assign block
        Calendar birthday = new GregorianCalendar(1996, 10, 1);
        User user = new User("Egor", 0, birthday);

        //Action block
        Calendar actual = user.getBirthday();

        //Assert block
        assertThat(actual, is(birthday));
    }

    /**
     * When try update name of user should check that object saved chages.
     */
    @Test
    void whenTryUpdateNameOfUserShouldCheckThatUserNameWasUpdated() {

        //Assign block
        User user = new User("Elixir");
        String expected = "Volodka";

        //Action block
        user.setName(expected);
        String actual = user.getName();

        //Assert block
        assertThat(actual, is(expected));

    }

    /**
     * When try update count of children should check that field of object was updated.
     */
    @Test
    void whenTryUpdateCountOfChildrenShouldCheckThatFieldOfObjectWasUpdated() {

        //Assign block
        User user = new User("Update", 1);

        //Action block
        user.setChildren(3);
        int actual = user.getChildren();

        //Assert block
        assertThat(actual, is(3));
    }

    /**
     * When try update birthday should check that object saved changes.
     */
    @Test
    void whenTryUpdateBirthdayShouldCheckThatModelWasSaveChanges() {

        //Assign block
        User user = new User("Update", 1, new GregorianCalendar(1996, 10, 1));
        Calendar calendar = new GregorianCalendar(1995, 4, 27);

        //Action block
        user.setBirthday(calendar);

        //Assert block
        assertThat(user.getBirthday(), is(calendar));

    }
}
