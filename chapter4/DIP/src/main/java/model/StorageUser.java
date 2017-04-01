package model;

/**
 * Concrete implementation of user model.
 */
public class StorageUser extends User {

    /**
     * Create concrete user.
     * @param name of user.
     * @param age of user.
     */
    public StorageUser(String name, int age) {
        super(name, age);
    }

    /**
     * Create a new concrete user.
     * @param name of user.
     * @param age of user.
     * @param id for user.
     */
    public StorageUser(String name, int age, int id) {
        super(name, age, id);
    }
}
