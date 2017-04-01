package model;

import start.MenuTracker;

/**
 *  We may also need that components may be choose by key and execute query to Tracker API.
 */
public interface Choose {

    /**
     * Choose method.
     * @param key of operations.
     * @param menuTracker instance of menu tracker.
     */
    void choose(int key, MenuTracker menuTracker);
}
