package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 */
public class User implements IDInterface {

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
     * Address of user.
     */
    private Address address;

    /**
     * Role of user.
     */
    private Role role;

    /**
     * Music types of user.
     */
    private List<MusicType> musicTypes;

    /**
     * Create a new user with given params.
     * @param originalId id of user.
     * @param email email of user.
     * @param password of user.
     */
    public User(int originalId, String email, String password) {
        this.id = originalId;
        this.email = email;
        this.password = password;
        this.musicTypes = new ArrayList<>();
    }

    /**
     * Check that given object equals with this.
     * @param o object for checking.
     * @return true if object are equals, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this == o) {
            equals = true;
        }
        if (!(o instanceof User)) {
            equals =  false;
        }

        User user = (User) o;

        if (id != user.id) {
            equals = false;
        }
        if (!email.equals(user.email)) {
            equals =  false;
        } else if (password.equals(user.password) && email.equals(user.email) && id == user.id) {
            equals = true;
        }
        return equals;
    }

    /**
     * Return unique hash code for this.
     * @return unique hash code for this.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    /**
     * Return id of user.
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set new id.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set new address.
     * @param address instance of address class.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Return current address of user.
     * @return current address.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Return email of user.
     * @return email of user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Return password of user.
     * @return password of user.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set new role of user.
     * @param role instance of role class.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Return current role of user.
     * @return current role of user.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Add to the user music types new music type, only it not have yet given music type.
     * @param type instance of music type class.
     */
    public void addMusicType(MusicType type) {
        if (!this.musicTypes.contains(type)) {
            this.musicTypes.add(type);
        }
    }

    /**
     * Add all music types, if user not have yet this.
     * @param collection instance of collection interface.
     */
    public void addMusicType(Collection<MusicType> collection) {
        if (!this.musicTypes.containsAll(collection)) {
            this.musicTypes.addAll(collection);
        }
    }



}
