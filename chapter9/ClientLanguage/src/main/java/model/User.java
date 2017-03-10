package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 */
public class User {

    private int id;
    private String email;
    private String password;
    private String cvFileLink;
    private Address address;


    public User(int id, String email, String password, String cvFileLink, Address address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cvFileLink = cvFileLink;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCvFileLink() {
        return cvFileLink;
    }


    public Address getAddress() {
        return this.address;
    }
}
