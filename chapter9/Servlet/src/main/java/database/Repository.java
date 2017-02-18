package database;

import models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 *
 * This is user repository. It provides next function add, remove and edit.
 */
public class Repository {

    /**
     * Lock for correct thread work.
     */
    private static final Object LOCK = new Object();

    /**
     * Hold list of all controllers.
     */
    private List<User> users;

    /**
     * Self instance. It is singleton.
     */
    private static Repository instance;

    /**
     * For count all controllers at the system.
     */
    private AtomicInteger counter;

    /**
     * Default constructor.
     */
    private Repository() {
        this.users = new CopyOnWriteArrayList<>();
        this.counter = new AtomicInteger(1);
    }

    /**
     * Return instance of already created and inited object or create new and return it.
     * @return instance of itself.
     */
    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    /**
     * Add user to the repository.
     * @param user instance of user class.
     */
    public void addUser(User user) {
        synchronized (LOCK) {
            user.setId(this.counter.getAndIncrement());
            this.users.add(user);
        }
    }

    /**
     * Edit user which already at the system.
     * @param user which will be edit.
     */
    public void editUser(User user) {
        synchronized (LOCK) {
            User oldUser = findUserById(user.getId());
            if (oldUser != null) {
                oldUser.setName(user.getName());
                oldUser.setSurname(user.getSurname());
                oldUser.setEmail(user.getEmail());
            }
        }
    }


    /**
     * Remove user from repository.
     * @param user instance of user class.
     */
    public void removeUser(User user) {
        synchronized (LOCK) {
            this.users.remove(user);
        }
    }

    /**
     * Search user by id.
     * @param id unique number per user.
     * @return user which id is equal given id.
     */
    public User findUserById(int id) {
        User user = null;
        synchronized (LOCK) {
            for (User usr : users) {
                if (usr.getId() == id) {
                    user = usr;
                    break;
                }
            }
        }
        return user;
    }

    /**
     * Return list of all controllers.
     * @return all controllers.
     */
    public List<User> getAllUsers() {
        synchronized (LOCK) {
            return this.users;
        }
    }
}
