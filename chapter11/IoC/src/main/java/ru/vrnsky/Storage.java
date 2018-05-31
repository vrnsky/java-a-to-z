package ru.vrnsky;

/**
 * This interface describe how to must work storages.
 */
public interface Storage {

    /**
     * Adding new user.
     * @param user instance of user.
     */
    void add(User user);

    /**
     * Get user by unique number.
     * @param id unique number.
     * @return user with given number.
     */
    User getUser(int id);

    /**
     * Remove user from storage.
     * @param id unique number.
     */
    void removeUser(int id);
}
