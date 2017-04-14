package repos;

import database.DBManager;
import model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 13.04.2017
 * <p>
 * Unit test for User Repository.
 */
public class UserRepoTest {

    /**
     * Before all test needs create a session factory object.
     */
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When try get user with good credits should check that repo return it.
     */
    @Test
    public void whenTryGetUserByCreditsShouldCheckThatRepoReturnUser() {
        User user = new User();
        user.setEmail("vrnsky@vrnsky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        User actual = UserRepo.getInstance().getUserByCredits("vrnsky@vrnsky.com", "root");
        assertThat(actual, is(notNullValue()));
    }


    /**
     * After all test needs to close session factory object.
     */
    @AfterClass
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}