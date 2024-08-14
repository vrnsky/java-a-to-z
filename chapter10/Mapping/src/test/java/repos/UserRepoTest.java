package repos;

import database.DBManager;
import model.User;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

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
    @BeforeAll
    public static void setUp() {
        DBManager.getInstance().init();
    }

    /**
     * When try to get user with good credits should check that repo return it.
     */
    @Test
    void whenTryGetUserByCreditsShouldCheckThatRepoReturnUser() {
        User user = new User();
        user.setEmail("vrnsky@vrnsky.com");
        user.setPassword("root");
        UserRepo.getInstance().add(user);
        User actual = UserRepo.getInstance().getUserByCredits("vrnsky@vrnsky.com", "root");
        MatcherAssert.assertThat(actual, is(notNullValue()));
    }


    /**
     * After all test needs to close session factory object.
     */
    @AfterAll
    public static void tearDown() {
        DBManager.getInstance().close();
    }
}