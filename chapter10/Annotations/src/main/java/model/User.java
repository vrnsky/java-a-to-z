package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 *
 * Describe user model at the app.
 */
@Entity
@Table(name="users")
public class User {

    /**
     * Unique number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * Email.
     */
    @Column(name="email")
    private String email;

    /**
     * Password.
     */
    @Column(name="password")
    private String password;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Return id of this user.
     * @return id of this user.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for this user.
     * @param id new for this user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return email of this user.
     * @return email of this user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new email of user.
     * @param email new version of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return password of this user.
     * @return password of this user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set new password for user.
     * @param password new version of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return text view of user.
     * @return text view of user.
     */
    @Override
    public String toString() {
        return this.getEmail();
    }
}
