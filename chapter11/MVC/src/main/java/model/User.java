package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Real user implementation.
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
public class User {

    /**
     * Unique per user number.
     */
    @Getter @Setter
    private int id;

    /**
     * Email of user.
     */
    @Getter @Setter
    private String email;

    /**
     * Password of user.
     */
    @Getter @Setter
    private String password;

    /**
     * Create a user without id.
     * @param email for user.
     * @param password for user.
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
