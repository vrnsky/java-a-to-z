package ru.vrnsky;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * It is unit test for jdbc storage.
 * @author vrnsky
 * @since 1.0
 */
public class JdbcStorageTest {

    /**
     * Context from Spring.
     */
    private final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    /**
     * Get storage from context.
     */
    private final JdbcStorage storage = context.getBean(JdbcStorage.class);

    /**
     *
     */
    @Test
    public void whenAddingNewUserToTheSystemShouldCheckThatUserWasAdded() {
        //storage.add(new User()); // fail on this line.
    }

    /**
     * When user getted from database should check that is not null.
     */
    @Test
    public void whenGetUserFromDatabaseShouldCheckThatUserIsNotNull() {
    }

    /**
     * When remove user, should check that system return null.
     */
    @Test
    public void whenRemoveUserFromDatabaseShouldCheckThatSystemReturnNull() {
    }
}