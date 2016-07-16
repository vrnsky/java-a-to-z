package templates;

import start.IO;

/**
 * TODO write docs
 */
public interface UserAction {

    String info();
    /**
     * Get position in actions array.
     * @return position in actions array.
     */
    int key();
    void execute(IO io);
}
