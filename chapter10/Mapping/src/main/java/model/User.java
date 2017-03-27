package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 27.03.2017
 *
 * Describe user at the system.
 */
public class User {

    /**
     * Unique number among all users.
     */
    private int id;

    /**
     * Email of user.
     */
    private String email;

    /**
     * Password of user.
     */
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
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return email of this user.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new version of email.
     * @param email new version of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return password of user.
     * @return password of user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set new password.
     * @param password new version of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return text view of user.
     * @return text view of object.
     */
    @Override
    public String toString() {
        return String.format("%s", this.email);
    }
}
