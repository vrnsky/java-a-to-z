package repo;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.02.2017
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
     * Email.
     */
    private String email;

    /**
     * Default constructor.
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
     * Constructor for create user from database.
     * @param id of user.
     * @param name of user.
     * @param surname of user.
     * @param email of user.
     */
    public User(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Return name of user.
     * @return name of user.
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name of user.
     * @param name new version of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return surname of user.
     * @return surname of user.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set new surname for user.
     * @param surname new version of surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Return email of user.
     * @return user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new email.
     * @param email new version of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return id of user.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new version of id.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s", this.surname, this.name, this.email);
    }
}
