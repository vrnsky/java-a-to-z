package beans;

import interfaces.Storage;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is crud repository for User class.
 * @author vrnsky.
 * @version 1.0.
 */
@Component
public class UserStorage {


    /**
     * Any implementation of storage, for example it may be in memory storage, or database storage.
     */
    private Storage storage;

    /**
     * Create a new storage.
     * @param storage any implementation of storage intrface.
     */
    @Autowired
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Spring needs it.
     */
    public UserStorage() {
    }

    /**
     * Adding new user to the system.
     * @param user instance of user object.
     */
    public void add(User user) {
        this.storage.add(user);
    }

    /**
     * Get user from the system. If user does not exist at the system return null.
     * @param id unique per user number.
     * @return user instance if it exist, otherwise return.
     */
    public User getUser(int id) {
        return this.storage.get(id);
    }

    /**
     * Remove user from storage.
     * @param id unique per user number.
     */
    public void removeUser(int id) {
        this.storage.remove(id);
    }

    /**
     * Update user at the storage.
     * @param user new version of user.
     */
    public void updateUser(User user) {
        this.storage.update(user);
    }
}
