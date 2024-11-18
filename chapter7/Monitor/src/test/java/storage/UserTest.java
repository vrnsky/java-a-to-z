package storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class UserTest {

    /**
     * Instance of testing class.
     */
    private User user;

    /**
     * Unique string for user.
     */
    private String id;

    /**
     * Create user before testing.
     */
    @BeforeEach
    public void setUp() {
        final int amount = 100;
        this.user = new User(amount);
        this.id = user.getId();
    }

    /**
     * Check that get id method works correct.
     * @throws Exception if something wrong.
     */
    @Test
    void getId() throws Exception {
        assertThat(id, is(this.user.getId()));
    }

    /**
     * Check that method get amount works correct.
     * @throws Exception if something wrong.
     */
    @Test
    void getAmount() throws Exception {
        final int expected = 100;
        assertThat(this.user.getAmount(), is(expected));
    }

    /**
     * When set new amount should check that amount update.
     * @throws Exception if something wrong.
     */
    @Test
    void setAmount() throws Exception {
        final int newAmount = 120;
        this.user.setAmount(newAmount);
        assertThat(user.getAmount(), is(newAmount));
    }
}
