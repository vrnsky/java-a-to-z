package dao;

import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 *
 * User repository provide next function: add user, edit, remove and get by id.
 */
public class Repository {

    /**
     * Instance of itself because it is singleton.
     */
    private static final Repository REPOSITORY = new Repository();

    /**
     * Help for interact with database.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private Repository() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of itself.
     * @return instance of itself.
     */
    public static Repository getInstance() {
        return REPOSITORY;
    }

    /**
     * Adding user to the system.
     * @param user instance of user class.
     */
    public void addUser(User user) {
        try {
            PreparedStatement statement = dbManager.getConnection().prepareStatement("INSERT INTO users(user_name, surname, email) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            while (set.next()) {
                user.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection();
        }
    }

    /**
     * Edit user which already in the system.
     * @param user instance of user class.
     */
    public void editUser(User user) {
        try {
            PreparedStatement statement = dbManager.getConnection().prepareStatement("UPDATE users SET user_name=?, surname=?, email=? WHERE id=?");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection();
        }
    }

    /**
     * Remove user from the system.
     * @param user instance of user class.
     */
    public void removeUser(User user) {
        try {
            PreparedStatement statement = dbManager.getConnection().prepareStatement("DELETE FROM users WHERE id=?");
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection();
        }
    }

    /**
     * Return user with given id.
     * @param id number for search user in database.
     * @return user from database if it exist, otherwise return null.
     */
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement statement = dbManager.getConnection().prepareStatement("SELECT * from users WHERE id=?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int userId = set.getInt("id");
                String name = set.getString("user_name");
                String surname = set.getString("surname");
                String email = set.getString("email");
                user = new User(userId, name, surname, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection();
        }

        return user;
    }

    /**
     * Return list of all users.
     * @return list of all users.
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet set = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();
            set = statement.executeQuery("SELECT * from users");
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("user_name");
                String surname = set.getString("surname");
                String email = set.getString("email");
                users.add(new User(id, name, surname, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
