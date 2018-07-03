package beans;

import interfaces.Storage;
import model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * This storage hold data in memory. For use it as storage for user storage.
 * Mark this class @Component annotations from org.springframework.
 * @author vrnsky.
 * @version 1.0
 */
public class MemoryStorage implements Storage {

    /**
     * Holding all users, not thread safe.
     */
    private List<User> users;

    /**
     * Create a new in memory storage.
     */
    public MemoryStorage() {
        this.users = new ArrayList<>();

    }

    /**
     * Adding new user to the system.
     * @param user instance of user object.
     */
    @Override
    public void add(User user) {
        this.users.add(user);
    }

    /**
     * Return user if it exist at the system, otherwise return null.
     * @param id unique per user number.
     * @return user object if it exist, otherwise return null.
     */
    @Override
    public User get(int id) {
        User user = null;
        if (!this.users.isEmpty()) {
            user = this.users.get(id);
        }
        return user;
    }

    /**
     * Remove user in memory storage.
     * @param id unique per user number.
     */
    @Override
    public void remove(int id) {
        this.users.remove(id);
    }

    /**
     * Update user at the in memory storage.
     * @param user instance of user.
     */
    @Override
    public void update(User user) {
        this.users.set(user.getId(), user);
    }
}
