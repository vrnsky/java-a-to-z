package ru.vrnsky;


import database.DBManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementing database storage.
 * @author vrnsky
 * @since 31.05.2018
 * @version 0.1
 */
@Component
public class JdbcStorage implements Storage {

    /**
     * Instance of database manager which allow to us work with database.
     */
    private DBManager dbManager;

    /**
     * Create a new JDBC storage.
     * @param dbManager instance of database manager.
     */
    @Autowired
    public JdbcStorage(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * Default constructor.
     */
    public JdbcStorage() {
    }
    /**
     * Adding new user to the database.
     * @param user instance of user.
     */
    @Override
    public void add(User user) {
        Session session = this.dbManager.getSession(); // return null. so why ?!
    }

    /**
     * Getting user from database.
     * @param id unique per user number.
     * @return user with unique number.
     */
    @Override
    public User getUser(int id) {
        return null;
    }

    /**
     * Remove user from database.
     * @param id unique per user number.
     */
    @Override
    public void removeUser(int id) {

    }
}
