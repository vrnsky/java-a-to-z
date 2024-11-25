package dao;

import model.Address;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 * <p>
 * This user repository.
 */
public class UserRepository {

    /**
     * Logger, needs for debug and understand what happens.
     */
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class.getSimpleName());

    /**
     * Self instance, it is singleton.
     */
    private static final UserRepository REPO = new UserRepository();

    /**
     * Wrapper for db interact.
     */
    private DBManager dbManager;

    /**
     * More of executing operations in repo need prepare statement.
     */
    private PreparedStatement statement;

    /**
     * Also in some operations needs get result of execution.
     */
    private ResultSet set;

    /**
     * Singleton.
     */
    private UserRepository() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of this.
     *
     * @return instance.
     */
    public static UserRepository getInstance() {
        return REPO;
    }

    /**
     * Add new user to the system.
     *
     * @param user instance of user class.
     */
    public void addUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("INSERT INTO users(email, password, cvFile, country, city) values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.setString(3, user.getCvFileLink());
            this.statement.setString(4, user.getAddress().getCountry());
            this.statement.setString(5, user.getAddress().getCity());
            this.statement.executeUpdate();
            this.set = this.statement.getGeneratedKeys();
            while (set.next()) {
                user.setId(this.set.getInt("id"));
            }
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        } finally {
            closeDbStructures();
        }
    }

    /**
     * Edit already exist user at the system.
     *
     * @param user instance of user class.
     */
    public void editUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("UPDATE users SET email  = ?, password = ? , cvFile = ? , country = ?, city = ? WHERE id = ?");
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.setString(3, user.getCvFileLink());
            this.statement.setString(4, user.getAddress().getCountry());
            this.statement.setString(5, user.getAddress().getCity());
            this.statement.setInt(6, user.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        } finally {
            this.closeDbStructures();
        }
    }

    /**
     * Remove user from database.
     *
     * @param user instance of user.
     */
    public void removeUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            this.statement.setInt(1, user.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        } finally {
            closeDbStructures();
        }

    }


    /**
     * Checking that user with given credits exist at the db.
     *
     * @param email    of user.
     * @param password of user.
     * @return user if it exist at the db, otherwise false.
     */
    public User isExist(String email, String password) {
        User user = null;
        try {
            PreparedStatement statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            this.set = statement.executeQuery();
            if (set.next()) {
                user = this.getUserById(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDbStructures();
        }
        return user;
    }

    /**
     * Return list of all users.
     *
     * @return list of all users.
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = this.dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * FROM users ORDER BY id ASC");
            while (set.next()) {
                int id = set.getInt("id");
                String email = set.getString("email");
                String password = set.getString("password");
                String cvFile = set.getString("cvFile");
                String country = set.getString("country");
                String city = set.getString("city");
                users.add(new User(id, email, password, cvFile, new Address(country, city)));
            }
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        } finally {
            this.closeDbStructures();
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }

        return users;
    }

    /**
     * Return user by id.
     *
     * @param id unique number per user.
     * @return user from database if it exist, otherwise return null.
     */
    public User getUserById(int id) {
        User user = null;
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE id = ?");
            this.statement.setInt(1, id);
            this.set = this.statement.executeQuery();
            while (set.next()) {
                int userId = this.set.getInt("id");
                String login = this.set.getString("email");
                String password = this.set.getString("password");
                String cvFile = this.set.getString("cvFile");
                String country = this.set.getString("country");
                String city = this.set.getString("city");
                user = new User(userId, login, password, cvFile, new Address(country, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDbStructures();
        }
        return user;
    }

    /**
     * Close all needed variable for interact with database.
     */
    private void closeDbStructures() {
        this.dbManager.closeConnection();
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                log.warn(e.getMessage(), e);
            }
        }

        if (this.set != null) {
            try {
                this.set.close();
            } catch (SQLException e) {
                log.warn(e.getMessage(), e);
            }
        }
    }
}
