package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 */
public class Role {

    private int id;
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    /**
     * Check that given object equals with it.
     * @param o object for compare.
     * @return true if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this == o) {
            equals = true;
        }
        if (!(o instanceof Role)) {
            equals = false;
        }

        Role role1 = (Role) o;

        if (id != role1.id) {
            equals = false;
        } else if (role.equals(role1.role)) {
            equals = true;
        }
        return equals;
    }

    /**
     * Return hash code for this.
     * @return unique hash code for this object.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role.hashCode();
        return result;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
