package model;

/**
 * This is user implementation, such as people have id and number.
 * @author vrnsky
 * @version 1.0
 */
public class User {

    /**
     * Unique per number user.
     */
    private int id;

    /**
     * Name of user.
     */
    private String name;

    /**
     * Default constructor. It need for reflection from hibernate.
     */
    public User() {
    }

    /**
     * Create a new user with given name.
     * @param name of user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Create a new user with given id.
     * @param id unique per user number.
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * Return unique per user number.
     * @return unique per user number.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id of this user.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get name of this user.
     * @return string version of this name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name of user.
     * @param name new version of name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
