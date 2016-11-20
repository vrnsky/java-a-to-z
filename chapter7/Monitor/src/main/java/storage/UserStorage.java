package storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class UserStorage {

    /**
     * At this place hold all users.
     */
    private List<User> userList;

    /**
     * Smart lock for correct access.
     */
    private Lock lock;

    /**
     * Create a new storage with synchronized list.
     */
    public UserStorage() {
        this.userList = new ArrayList<>();
        this.userList = Collections.synchronizedList(userList);
    }

    /**
     * Added new user to the end of array list.
     *
     * @param user object for adding.
     * @return true if success add, otherwise false.
     */
    public boolean add(User user) {
        return this.userList.add(user);
    }

    /**
     * Edit user.
     *
     * @param user new version of user.
     */
    public void editUser(User user) {
        for (int index = 0; index < userList.size(); index++) {
            if (user.equals(userList.get(index))) {
                userList.add(index, user);
                break;
            }
        }
    }

    /**
     * Removing user from repository.
     *
     * @param id of user.
     * @return true if user was deleted, otherwise false.
     */
    public boolean remove(String id) {
        return this.userList.remove(this.getById(id));
    }

    /**
     * Return user or null if user not contains in list.
     *
     * @param id of user.
     * @return user or null.
     */
    public User readUserById(String id) {
        return this.getById(id);
    }

    /**
     * Transaction amount.
     *
     * @param userIdOne id of first user.
     * @param userIdTwo id of second user.
     * @param amount    for transaction.
     * @return true if success, otherwise false.
     */
    public boolean transactionAmount(String userIdOne, String userIdTwo, int amount) {
        boolean success = false;
        User userOne = this.getById(userIdOne);
        User userTwo = this.getById(userIdTwo);
        if (userOne == null || userTwo == null) {
            success = false;
        } else {
            lock.lock();
            try {
                int amountAfterTransaction = userOne.getAmount() - amount;
                userOne.setAmount(amountAfterTransaction);
                userTwo.setAmount(userTwo.getAmount() + amount);
                success = true;
            } finally {
                lock.unlock();
            }
        }
        return success;
    }

    /**
     * Find user by id and return it. Otherwise return false.
     *
     * @param id of user.
     * @return user or null.
     */
    private User getById(String id) {
        User user = null;
        for (User client : userList) {
            if (client.getId().equals(id)) {
                user = client;
                break;
            }
        }
        return user;
    }
}
