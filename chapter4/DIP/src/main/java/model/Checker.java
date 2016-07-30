package model;

/**
 * All checker must implement this interface
 */
public interface Checker {

    boolean check(User[] users, User user);
}
