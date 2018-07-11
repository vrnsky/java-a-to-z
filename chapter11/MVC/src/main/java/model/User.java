package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Real user implementation.
 *
 * @author vrnsky.
 * @version 0.1.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * Unique per user number.
     */
    @Id
    private int id;

    /**
     * Email of user.
     */
    @Column(name = "email")
    private String email;

    /**
     * Password of user.
     */
    @Column(name = "password")
    private String password;

    /**
     * Create a user without id.
     * @param email    for user.
     * @param password for user.
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
