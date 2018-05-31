package ru.vrnsky;

/**
 * Simple class for testing.
 * @version 0.1
 * @since 31.05.2018
 */
public class User {

    /**
     * Unique per user number.
     */
    private int id;

    /**
     * Construct new user.
     * @param id unique per user number
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * This constructor needs for hibernate.
     */
    public User() {
    }

    /**
     * Getting id of user.
     * @return unique per user number.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id.
     * @param id unique per number user.
     */
    public void setId(int id) {
        this.id = id;
    }
}
