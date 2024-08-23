package database;

import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author evrnsky
 * @version 0.1.
 * @since 18.04.2017
 *
 * This is unit test for repository.
 */
class RepositoryTest {

    /**
     * Instance of system under test.
     */
    private Repository repo;

    /**
     * This method calls before each test case.
     * It instant repository instance.
     */
    @BeforeEach
    public void setUp() {
        repo = Repository.getInstance();
    }

    /**
     * When try to add user should check that user was added.
     */
    @Test
    void whenTryAddUserShouldCheckThatUserWasAdded()  {
        User user = new User("Andrew", "Voronyansky", "vrnsky@vrnsky.com");
        this.repo.addUser(user);
        assertThat(this.repo.findUserById(user.getId()), is(user));
    }

    /**
     * When try edit user should check that data is saved.
     */
    @Test
    void whenTryEditUserShouldCheckThatRepoAcceptedNewVersion() {
        User user = new User("Andrew", "Voronyansky", "vrnsky@vrnsky.com");
        this.repo.addUser(user);
        user.setEmail("wolf@vrn.com");
        this.repo.editUser(user);
        assertThat(this.repo.findUserById(user.getId()).getEmail(), is("wolf@vrn.com"));
    }

    /**
     * When remove user should check that method find by id return null.
     */
    @Test
    void whenRemoveUserShouldCheckThatMethodFindByIdReturnNull() {
        User user = new User("yegor", "256", "eo");
        this.repo.addUser(user);
        this.repo.removeUser(user);
        assertThat(this.repo.findUserById(user.getId()), is(nullValue()));
    }

    /**
     * When try to get all users should check that method return correct list.
     */
    @Test
    void whenTryGetAllUsersShouldCheckThatMethodReturnCorrectData() {
        User user = new User("yegor", "256", "eo");
        this.repo.addUser(user);
        assertEquals(1, this.repo.getAllUsers().size());
    }

    /**
     * After all test we need to clear storage, because it is thread safe storage.
     * And without invoke clear method we have a problem with size test cases.
     */
    @AfterEach
    public void tearDown() {
        this.repo.clear();
    }
}