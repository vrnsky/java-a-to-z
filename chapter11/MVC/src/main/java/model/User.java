package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


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
