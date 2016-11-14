package start;

/**
 * Using for determine user actions. Contract for all user actions.
 */
public interface UserAction {
    /**
     * @return key of action.
     */
    int key();

    /**
     * execute operation from tracker.
     * @param io instance of io interface.
     * @param tracker instance of tracker.
     */
    void execute(IO io, Tracker tracker);

    /**
     * Info about action.
     * @return info about action.
     */
    String info();
}
