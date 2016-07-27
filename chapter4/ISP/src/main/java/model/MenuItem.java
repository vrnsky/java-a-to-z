package model;

import start.IO;
import start.MenuTracker;

/**
 * Model of menu item. It should have a name and may execute
 */
public class MenuItem implements Showable, Choose {

    /**
     * Unique value for each menu item.
     */
    private int key;

    /**
     * Reference to parent menu item.
     */
    private int parentKey;

    /**
     * Name of menu item.
     */
    private String name;

    /**
     * Create a menu item with given name.
     * @param name of menu item.
     */
    public MenuItem(String name) {
        this.name = name;
    }

    /**
     * Create a new sub menu item.
     * @param name of item.
     * @param parentKey unique string for find parent.
     */
    public MenuItem(String name, int parentKey) {
        this.name = name;
        this.parentKey = parentKey;
    }

    /**
     * Set a new key of his menu item.
     * @param key new value of key.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Get key for this item.
     * @return
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Return this parent key for this item
     * @return unique key of parent, if it is root menu item return null.
     */
    public int getParentKey() {
        return this.parentKey;
    }

    /**
     * Show all menu item.
     * @param io instance of IO interface for handle input/output.
     */
    @Override
    public void show(String value, IO io) {
        io.println(String.format(value + "%s.%s. %s", this.parentKey, this.key, this.name));
    }

    /**
     * Allow user to choose menu options.
     * @param key unique key of actions.
     * @param menuTracker instance of menu tracker.
     */
    @Override
    public void choose(int key, MenuTracker menuTracker) {
        menuTracker.select(key);
    }
}
