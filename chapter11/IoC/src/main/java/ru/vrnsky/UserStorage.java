package ru.vrnsky;

/**
 * This is implementation more global storage, for hide internal work of other storages.
 * @author vrnsky
 * @version 0.1
 * @since 31.05.2018
 */
public class UserStorage {

    /**
     * Implementation of storage interface.
     */
    private final Storage storage;

    /**
     * Creating new storage.
     * @param storage implement of storage.
     */
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    /**
     * Adding new user.
     * @param user instance of user.
     */
    public void add(User user) {
        this.storage.add(user);
    }
}
