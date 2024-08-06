package ru.evrnsky.model;

/**
 * All checker must implement this interface.
 */
public interface Checker {

    /**
     * Check that user have a some property.
     * @param users collection of users.
     * @param user under checking.
     * @return true if all is ok, otherwise false.
     */
    boolean check(User[] users, User user);
}
