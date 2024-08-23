package ru.evrnsky.model;

import ru.evrnsky.start.IO;

/**
 * Model of user storage.
 */
public class UserStorage extends Storage {

    /**
     * Instance of io interface.
     */
    private IO io;

    /**
     * Method for checking data.
     */
    private Checker checker;

    /**
     * Create a new storage with given capacity and io system.
     *
     * @param capacity size of user array.
     * @param io       instance of io interface.
     * @param checker  method of checking.
     */
    public UserStorage(int capacity, IO io, Checker checker) {
        super(capacity);
        this.io = io;
        this.checker = checker;
    }


    /**
     * Create a new user storage with given io system and method of checking.
     *
     * @param io      system for input and output.
     * @param checker method for checking.
     */
    public UserStorage(IO io, Checker checker) {
        this(10, io, checker);
    }

    /**
     * Create a new user.
     */
    public void createUser() {
        String name = io.ask("Enter a name of new user: ");
        int age = io.ask("Enter age of new user: ", 0, Integer.MAX_VALUE);
        if (!this.checker.check(this.users, new StorageUser(name, age))) {
            super.addUser(new StorageUser(name, age));
            this.io.println("User was added");
        } else {
            this.io.println("User with given name already exist");
        }
    }

    /**
     * Edit exist user.
     */
    public void editUser() {
        String name = io.ask("Enter a name of user for edit:");
        int age = io.ask("Enter a age of user for edit", 0, Integer.MAX_VALUE);
        int id = io.ask("Enter a id of user for edit: ", 0, super.getIdLastElement() + 1);
        if (this.checker.check(users, new StorageUser(name, age, id))) {
            String newName = io.ask("Enter new name for user: ");
            int newId = io.ask("Enter a new id for user: ", 0, super.getIdLastElement());
            int newAge = io.ask("Enter a new age for user: ", 0, Integer.MAX_VALUE);
            this.users[newId] = new StorageUser(newName, newAge, newId);
            this.io.println("User was edited.");
        } else {
            io.println("User with given data not exist!");
        }

    }

    /**
     * Remove user from storage.
     */
    public void removeUser() {
        String name = io.ask("Enter a name of user for delete: ");
        int age = io.ask("Enter a age of user for delete: ", 0, Integer.MAX_VALUE);
        int id = io.ask("Enter a id of user for delete: ", 0, super.getIdLastElement());

        if (checker.check(this.users, new StorageUser(name, age, id))) {
            super.users[id] = null;
            io.println("User was removed.");
        } else {
            io.println("User with given data not exist!");
        }
    }

    /**
     * Show all user by call print method from io system.
     */
    public void showUsers() {
        this.io.println("ID\tName\tAge");
        for (User user : this.users) {
            if (user != null) {
                this.io.println(String.format("%s\t%s\t%s", user.getId(), user.getName(), user.getAge()));
            }
        }
    }


}
