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
     * First name of user.
     */
    private String firstName;

    /**
     * Last name of user.
     */
    private String surname;

    /**
     * Email of user.
     */
    private String email;

    /**
     * Create a new user without id.
     * @param firstName of user.
     * @param surname of user.
     * @param email of user.
     */
    public User(String firstName, String surname, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Create a new user with id.
     * @param id unique number.
     * @param firstName of user.
     * @param surname of user.
     * @param email of user.
     */
    public User(int id, String firstName, String surname, String email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Return id of user.
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
     * Return first name of this user.
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name of this user.
     * @param firstName new version of first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return surname of this user.
     * @return surname of this user.
     */
    public String getSurname() {
        return surname;
    }


    /**
     * Set new user surname.
     * @param surname new version of surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Return email of user.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email for user.
     * @param email new version email user.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
