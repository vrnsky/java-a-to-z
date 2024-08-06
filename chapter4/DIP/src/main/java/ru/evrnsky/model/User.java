package ru.evrnsky.model;

/**
 * Model of user.
 */
public abstract class User {

    /**
     * Name of the user.
     */
    private String name;

    /**
     * Age of the user.
     */
    private int age;

    /**
     * unique value for each user.
     */
    private int id;

    /**
     * Create user without id.
     * @param name of user.
     * @param age of user.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Create user with id.
     * @param name of user.
     * @param age of user.
     * @param id of user.
     */
    public User(String name, int age, int id) {
        this(name, age);
        this.id = id;
    }

    /**
     * Return a name of user.
     * @return user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name of user.
     * @param name new name of user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return age of user.
     * @return age of user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set new age for user.
     * @param age new age for user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Return id of user.
     * @return id of user.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id for user.
     * @param id new id for user.
     */
    public void setId(int id) {
        this.id = id;
    }
}
