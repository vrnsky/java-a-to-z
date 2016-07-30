package templates;

import start.IO;

/**
 * Contract for all user actions.
 */
public interface UserAction {

    String info();
    int key();
    void execute(IO io);
}
