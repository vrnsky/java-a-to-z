package beans;

import model.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * This unit test for UserStorage class.
 * @author vrnsky
 * @version 1.0
 */
class UserStorageTest {

    /**
     * Create a context of app.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    /**
     * Get user storage bean from context, all dependecy already injected. Magic of Spring.
     */
    private UserStorage userStorage = context.getBean(UserStorage.class);

    /**
     * When add user to the storage should check that storage safe it.
     */
    @Test
    void whenAddUserToTheSystemShouldCheckThatStorageSafeIt() {
        User jhipster = new User("JHipster");
        this.userStorage.add(jhipster);
        assertThat(this.userStorage.getUser(jhipster.getId()).getName(), is("JHipster"));
    }

    /**
     * When get user from system should check that is not null.
     */
    @Test
    void whenGetUserFromSystemShouldCheckThatIsNotNull() {
        User jayz = new User("jayz");
        this.userStorage.add(jayz);
        assertThat(this.userStorage.getUser(jayz.getId()), notNullValue());
    }

    /**
     * When remove user should check that it remove from storage.
     */
    @Test
    void whenRemoveUserShouldCheckThatItRemovedFromStorage() {
        User jerk = new User("jerk");
        this.userStorage.add(jerk);
        this.userStorage.removeUser(jerk.getId());
        assertThat(this.userStorage.getUser(jerk.getId()), nullValue());

    }

    /**
     * When update user shold check that storage was updated.
     */
    @Test
    void whenUpdateUserShouldCheckThatSystemWasUpdated() {
        User yegor = new User("yegor");
        this.userStorage.add(yegor);
        yegor.setName("Yegor Voronyansky");
        this.userStorage.updateUser(yegor);
        assertThat(userStorage.getUser(yegor.getId()).getName(), is("Yegor Voronyansky"));
    }
}