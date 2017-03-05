package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 24.02.2017
 * <p>
 * This model of user.
 */
public class User {

    /**
     * Unique number per user.
     */
    private int id;

    /**
     * Login of user.
     */
    private String login;

    /**
     * Login of password.
     */
    private String password;

    /**
     * Role of user.
     */
    private Role role;

    /**
     * Constructor with id.
     * @param id       of user.
     * @param login    of user.
     * @param password of user.
     * @param role     of user.
     */
    public User(int id, String login, String password, String role) {
        this(login, password, role);
        this.id = id;
    }

    /**
     * Default constructor.
     * @param login    of user.
     * @param password of user.
     * @param role     of user.
     */
    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = new Role(role);
    }

    /**
     * Return hash code of this object.
     * @return unique number per object.
     */
    @Override
    public int hashCode() {
        return id * 31 + 17;
    }

    /**
     * Compare this and other object that are equals.
     * @param o object for compare.
     * @return true if object are equals
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = false;
        }
        if (!(o instanceof User)) {
            result = false;
        }

        User user = (User) o;

        if (user.getId() == this.id) {
            result = true;
        }
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
     * Set new id.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return login of this user.
     * @return login of this user.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set new login of this user.
     * @param login new version of login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Return password of this user.
     * @return password of this user.
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
     * Return role of this user.
     * @return role of user.
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * Set new role.
     * @param role new version of role.
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
