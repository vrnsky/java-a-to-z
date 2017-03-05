package repo;

import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.02.2017
 *
 * This class implement user repos.
 */
public class UserRepo {

    /**
     * Instance of itself, this is singleton.
     */
    private static final UserRepo INSTANCE = new UserRepo();

    /**
     * Instance of db management.
     */
    private DbManager dbManager;

    /**
     * Default constructor.
     */
    private UserRepo() {
        this.dbManager = new DbManager();
    }

    /**
     * Return instance of itself.
     * @return instance of itself.
     */
    public static UserRepo getInstance() {
        return INSTANCE;
    }

    /**
     * Add new user to the system.
     * @param user instance of user class.
     */
    public void addUser(User user) {
        this.dbManager.addUser(user);
    }


    /**
     * Edit already in system user.
     * @param id number of user.
     * @param name new name.
     * @param surname new surname.
     * @param email new email.
     */
    public void editUser(int id, String name, String surname, String email) {
        this.dbManager.editUser(id, name, surname, email);
    }

    /**
     * Remove user from system.
     * @param id of user at the system.
     */
    public void removeUser(int id) {
        this.dbManager.removeUser(id);
    }

    /**
     * Return user with given id.
     * @param id number of user.
     * @return user with given id.
     */
    public User getUserById(int id) {
        return this.dbManager.getUserById(id);
    }

    /**
     * Return list of all controllers.
     * @return all controllers.
     */
    public List<User> getAllUsers() {
        return this.dbManager.getAllUsers();
    }
}
