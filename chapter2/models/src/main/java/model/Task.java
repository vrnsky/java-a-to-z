package model;


/**
 * It is a extension of item class.
 * Have all public variable and public, protected methods.
 */
public class Task extends Item {
    /**
     * Create a new task.
     * @param name - it is name of new task.
     * @param desc - it is description of new task.
     */
    public Task(final String name, final String desc) {
        super(name, desc);
    }
}
