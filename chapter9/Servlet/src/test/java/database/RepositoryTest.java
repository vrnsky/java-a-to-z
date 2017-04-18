package database;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author evrnsky
 * @version 0.1.
 * @since 18.04.2017
 *
 * This is unit test for repository.
 */
public class RepositoryTest {

    /**
     * Instance of system under test.
     */
    private Repository repo;

    /**
     * This method calls before each test case.
     * It instant repository instance.
     */
    @Before
    public void setUp() {
        repo = Repository.getInstance();
    }

    /**
     * When try add user should check that user was added.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryAddUserShouldCheckThatUserWasAdded() throws Exception {
        User user = new User("Andrew", "Voronyansky", "vrnsky@vrnsky.com");
        this.repo.addUser(user);
        assertThat(this.repo.findUserById(user.getId()), is(user));
    }

    /**
     * When try edit user should check that data is saved.
     * @throws Exception if something wrong.
     */
    @Test
    public void whenTryEditUserShouldCheckThatRepoAcceptedNewVersion() throws Exception {
        User user = new User("Andrew", "Voronyansky", "vrnsky@vrnsky.com");
        this.repo.addUser(user);
        user.setEmail("wolf@vrn.com");
        this.repo.editUser(user);
        assertThat(this.repo.findUserById(user.getId()).getEmail(), is("wolf@vrn.com"));
    }

    /**
     * When remove user should check that method find by id return null.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenRemoveUserShouldCheckThatMethodFindByIdReturnNull() throws Exception {
        User user = new User("yegor", "256", "eo");
        this.repo.addUser(user);
        this.repo.removeUser(user);
        assertThat(this.repo.findUserById(user.getId()), is(nullValue()));
    }

    /**
     * When try get all users should check that method return correct list.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryGetAllUsersShouldCheckThatMethodReturnCorrectData() throws Exception {
        User user = new User("yegor", "256", "eo");
        this.repo.addUser(user);
        assertEquals(1, this.repo.getAllUsers().size());
    }

    /**
     * After all test we need to clear storage, because it is thread safe storage.
     * And without invoke clear method we have a problem with size test cases.
     */
    @After
    public void tearDown() {
        this.repo.clear();
    }
}