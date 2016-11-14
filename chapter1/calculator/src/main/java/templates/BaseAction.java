package templates;

/**
 * All actions must expand this class.
 * Model for all user actions.
 */
public abstract class BaseAction implements UserAction {

    /**
     * Name of action. It will be show in menu.
     */
    protected String name;

    /**
     * Create new action with name.
     * @param actionName of action.
     */
    public BaseAction(String actionName) {
        this.name = actionName;
    }

    /**
     * Return info about action include key and name.
     * @return key and name of action.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
