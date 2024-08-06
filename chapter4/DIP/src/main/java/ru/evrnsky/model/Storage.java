package ru.evrnsky.model;

/**
 * Model of storage.
 */
public abstract class Storage {

    /**
     * At this place hold all controllers.
     */
    protected User[] users;

    /**
     * Reference to the last not null element in array.
     */
    private int lastElement;

    /**
     * Create a new storage with given capacity.
     * @param capacity size of user array.
     */
    public Storage(int capacity) {
        this.users = new User[capacity];
    }

    /**
     * Default constructor. Create storage with ten capacity.
     */
    public Storage() {
        this(10);
    }

    /**
     * Add new user to controllers array.
     * @param user instance of user class.
     */
    protected void addUser(User user) {
        for (int index = 0; index < this.users.length; index++) {
            if (this.users[index] == null) {
                user.setId(index);
                this.users[index] = user;
                this.lastElement = index;
                break;
            }
        }
    }

    /**
     * Return number of the last not null element in user array.
     * @return number of the last no null element in user array.
     */
    protected int getIdLastElement() {
        return this.lastElement;
    }

    /**
     * Implement by child.
     */
    abstract void createUser();

    /**
     * Implement by child.
     */
    abstract void editUser();

    /**
     * Implement by child.
     */
    abstract void removeUser();

    /**
     * Implement by child.
     */
    abstract void showUsers();
}
