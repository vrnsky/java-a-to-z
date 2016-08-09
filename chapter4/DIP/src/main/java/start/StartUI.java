package start;

import model.EditChecker;
import model.UserStorage;

/**
 *  Demo of interact class UserStorage and Checker.
 */
public class StartUI {

    /**
     * Instance of IO system.
     */
    private IO io;

    /**
     * Create a new UI with given io system.
     * @param io instance of io interface.
     */
    public StartUI(IO io) {
        this.io = io;
    }

    /**
     * Start app.
     * @param args
     */
    public static void main(String[] args) {
       new StartUI(new ConsoleIO()).init();
    }

    /**
     * Init app, first add new user, second edit exist user, and remove user.
     */
    public void init() {
        UserStorage userStorage = new UserStorage(this.io, new EditChecker());
        userStorage.createUser();
        userStorage.showUsers();
        userStorage.editUser();
        userStorage.showUsers();
        userStorage.removeUser();
        userStorage.showUsers();
    }
}
