package ru.vrnsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of storage which based on in memory.
 * @author vrnsky
 * @version 0.1
 * @since 31.05.2018
 */
public class MemoryStorage implements Storage {

    /**
     * Count users.
     */
    private static int userCounter = 0;

    /**
     * In memory storage.
     */
    private List<User> users = new ArrayList<>();


    /**
     * Adding user to the storage.
     * @param user instance of user.
     */
    @Override
    public void add(User user) {
        user.setId(userCounter++);
        this.users.add(user);
    }

    /**
     * Get user from storage.
     * @param id unique number per user.
     * @return instance of user.
     */
    @Override
    public User getUser(int id) {
        User user = null;
        if (!this.users.isEmpty()) {
            user = this.users.get(0);
        }
        return user;
    }

    /**
     * Remove user from storage.
     * @param id unique per user number.
     */
    @Override
    public void removeUser(int id) {
        this.users.remove(id);
    }
}
