package model;

import start.MenuTracker;

/**
 *  We may also need that components may be choose by key and execute query to Tracker API.
 */
public interface Choose {
    void choose(int key, MenuTracker menuTracker);
}
