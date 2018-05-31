package ru.vrnsky;

/**
 * Implementing database storage.
 * @author vrnsky
 * @since 31.05.2018
 * @version 0.1
 */
public class JdbcStorage implements Storage {

    /**
     * Adding new user to the database.
     * @param user instance of user.
     */
    @Override
    public void add(User user) {
    }

    /**
     * Getting user from database.
     * @param id unique per user number.
     * @return user with unique number.
     */
    @Override
    public User getUser(int id) {
        return null;
    }

    /**
     * Remove user from database.
     * @param id unique per user number.
     */
    @Override
    public void removeUser(int id) {

    }
}
