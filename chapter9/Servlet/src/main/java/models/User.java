package models;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 *
 * Model of user.
 */
public class User {

    /**
     * Unique number per user.
     */
    private int id;

    /**
     * Name of user.
     */
    private String name;

    /**
     * Surname of user.
     */
    private String surname;

    /**
     * Email of user.
     */
    private String email;

    /**
     * Create a new user.
     * @param name of user.
     * @param surname of user.
     * @param email of user.
     */
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Create a new user.
     * @param id of user.
     * @param name of user.
     * @param surname of user.
     * @param email of user.
     */
    public User(int id, String name, String surname, String email) {
        this(name, surname, email);
        this.id = id;
    }

    /**
     * Return name of user.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name for user.
     * @param name new version of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return surname of user.
     * @return surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set new version surname of user.
     * @param surname new surname for user.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Return email.
     * @return email of user.
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
     * Set new version of id for user.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return id of user.
     * @return id of user.
     */
    public int getId() {
        return this.id;
    }


}
