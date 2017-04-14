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
     * Return true if object are same.
     * @param o object for checking.
     * @return true if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (!email.equals(user.email)) {
            return false;
        }
        return password.equals(user.password);
    }

    /**
     * Return hash code of object.
     * @return hash code of object.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
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
     * Return current email.
     * @return email.
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
