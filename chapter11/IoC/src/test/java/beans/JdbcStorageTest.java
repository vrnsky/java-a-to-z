package beans;

import model.User;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;


/**
 * This unit test for JdbcStorage.java.
 * @author vrnsky.
 * @version 1.0
 */
class JdbcStorageTest {


    /**
     * All beans may get from context, if it to register at context file.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    /**
     * Get storage from context.
     */
    private JdbcStorage jdbcStorage = context.getBean(JdbcStorage.class);


    /**
     * When add user to the storage should check that storage save user instance.
     */
    @Test
    void whenAddUserToTheSystemShouldCheckThatStorageSafeIt() {
        User user = new User();
        user.setName("Barsik");
        this.jdbcStorage.add(user);
        User actualUser = this.jdbcStorage.get(user.getId());
        assertThat(actualUser.getName(), is("Barsik"));
    }

    /**
     * When get user from storage should check that getted user is not null.
     */
    @Test
    void whenGetUserFromStorageShouldCheckThatItReturnUser() {
        User helen = new User();
        helen.setName("Helen");
        this.jdbcStorage.add(helen);
        assertThat(this.jdbcStorage.get(helen.getId()), notNullValue());
    }

    /**
     * When remove user should check that user was removed from storage.
     */
    @Test
    void whenRemoveUserShouldCheckThatItRemovedFromStorage() {
        User jerk = new User();
        jerk.setName("Jimmy");
        this.jdbcStorage.add(jerk);
        this.jdbcStorage.remove(jerk.getId());
        assertThat(this.jdbcStorage.get(jerk.getId()), nullValue());
    }

    /**
     * When update user should check that changes applied.
     */
    @Test
    void whenUpdateUserShouldCheckThatChangesApplied() {
        User hipster = new User();
        hipster.setName("hipster");
        this.jdbcStorage.add(hipster);
        hipster.setName("newHipstor");
        this.jdbcStorage.update(hipster);
        assertThat(this.jdbcStorage.get(hipster.getId()).getName(), is("newHipstor"));
    }
}