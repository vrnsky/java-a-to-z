package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 */
public class User {

    private int id;
    private String email;
    private String password;
    private Address address;
    private Role role;
    private List<MusicType> musicTypes;

    public User(int originalId, String email, String password) {
        this.id = originalId;
        this.email = email;
        this.password = password;
        this.musicTypes = new ArrayList<>();
    }


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Role getRole() {
        return role;
    }

    public void addMusicType(MusicType type) {
        if (!this.musicTypes.contains(type)) {
            this.musicTypes.add(type);
        }
    }

    public void addMusicType(Collection<MusicType> collection) {
        if (!this.musicTypes.containsAll(collection)) {
            this.musicTypes.addAll(collection);
        }
    }



}
