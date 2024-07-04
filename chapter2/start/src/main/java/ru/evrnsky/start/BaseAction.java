package ru.evrnsky.start;

/**
 * It is common implementation of action.
 */
public abstract class BaseAction implements UserAction {

    /**
     * Name of action.
     */
    private final String actionName;

    /**
     * Create a new action and set name to the this name variable.
     * @param name it is name of action.
     */
    public BaseAction(final String name) {
        this.actionName = name;
    }

    /**
     * Return info about action, include key and name.
     * @return key and name of action.
     */
    public final String info() {
        return String.format("%s. %s", this.key(), this.actionName);
    }
}
