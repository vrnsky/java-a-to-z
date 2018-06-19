package ru.vrnsky;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Unit test for memory storage test.
 * @author vrnsky
 * @version 0.1
 * @since 31.05.2018
 */
public class MemoryStorageTest {

    /**
     * Context from Spring.
     */
    private final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    /**
     * Get storage from context.
     */
    private final MemoryStorage storage = context.getBean(MemoryStorage.class);


    /**
     * When add user to the  storage should check that storage safe it.
      */
    @Test
    public void whileAddUserShouldSafeIt() {
        User user = new User();
        this.storage.add(user);
        assertThat(user, is(storage.getUser(0)));
    }

    /**
     * When remove user should remove it from user.
     */
    @Test
    public void whenRemoveUserShouldRemoveItFromStorage() {
        User user = new User();
        this.storage.add(user);
        this.storage.removeUser(0);
        assertNull(this.storage.getUser(0));
    }
}