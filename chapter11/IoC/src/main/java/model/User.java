package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This is user implementation, such as people have id and number.
 * @author vrnsky
 * @version 1.0
 */
public class User {

    /**
     * Unique per number user.
     */
    @Getter @Setter
    private int id;

    /**
     * Name of user.
     */
    @Getter @Setter
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


}
