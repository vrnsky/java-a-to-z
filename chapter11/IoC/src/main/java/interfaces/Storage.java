package interfaces;

import model.User;

/**
 * This is interface for any storage in app, all storages must implement this methods.
 * @author vrnsky
 * @version 1.0
 */
public interface Storage {

    /**
     * Add new user to the system.
     * @param user instance of user class.
     */
    void add(User user);

    /**
     * Getting user from the system.
     * @param id unique per user number.
     * @return user instance or null.
     */
    User get(int id);

    /**
     * Remove user from storage.
     * @param id unique per user number.
     */
    void remove(int id);

    /**
     * Update user.
     * @param user new version of user instance.
     */
    void update(User user);
}
