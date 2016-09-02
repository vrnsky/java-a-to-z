package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Model of user.
 */
public class User {

    /**
     * Name of user.
     */
    private String name;

    /**
     * Count of children for current user.
     */
    private int children;

    /**
     * Birthday of user.
     */
    private Calendar birthday;

    /**
     * Create a new user with given name and count of children.
     * Birthday set by current date.
     * @param name of user.
     * @param children count of kids.
     */
    public User(String name, int children) {
        this(name, children, new GregorianCalendar());
    }


    /**
     * Create a new user with given name, children and birthday.
     * @param name of user.
     * @param children count of kids.
     * @param birthday of user.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Create new user with given name.
     * @param name of user.
     */
    public User(String name) {
        this(name, 0, new GregorianCalendar());
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
     * @param name new version of name for user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return children of user.
     * @return children of user.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Set new count of children.
     * @param children new version of count kids.
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Return a birthday of user.
     * @return birthday of user.
     */
    public Calendar getBirthday() {
        return birthday;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }

    /**
     * Update birthday of user.
     * @param birthday new version of birthday.

     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
}
