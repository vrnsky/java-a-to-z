package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 *
 * This is simple implementation of user model.
 */
public class User {

    /**
     * Unique number per user.
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
     * Link to the cv file.
     */
    private String cvFileLink;

    /**
     * Address of user.
     */
    private Address address;

    /**
     * Default constructor.
     * @param id of user.
     * @param email of user.
     * @param password of user.
     * @param cvFileLink of user.
     * @param address of user.
     */
    public User(int id, String email, String password, String cvFileLink, Address address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cvFileLink = cvFileLink;
        this.address = address;
    }

    /**
     * Return id of user.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id.
     * @param id new id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return email of user.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return cv link.
     * @return cv link.
     */
    public String getCvFileLink() {
        return cvFileLink;
    }

    /**
     * Set new cv link file.
     * @param cvFileLink new file.
     */
    public void setCvFileLink(String cvFileLink) {
        this.cvFileLink = cvFileLink;
    }

    /**
     * Return address.
     * @return address.
     */
    public Address getAddress() {
        return this.address;
    }
}
