package templates;

import start.IO;

/**
 * Contract for all user actions.
 */
public interface UserAction {

    /**
     * Return info about action.
     * @return info about action.
     */
    String info();

    /**
     * Return unique key per action.
     * @return unique number.
     */
    int key();

    /**
     * Execute action.
     * @param io instance of input output interface.
     */
    void execute(IO io);
}
