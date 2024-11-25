package repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.02.2017
 * <p>
 * Database management.
 */
public class DbManager {

    /**
     * Instance of settings class for reading props.
     */
    private static final Settings SETTINGS = new Settings();

    /**
     * Logger for detect reason of failure.
     */
    private static final Logger log = LoggerFactory.getLogger(DbManager.class.getSimpleName());

    /**
     * Connection to the database.
     */
    private Connection connection;

    /**
     * Flag which mean that we already connected to the database.
     */
    private AtomicBoolean connected = new AtomicBoolean(false);

    /**
     * Default constructor.
     */
    public DbManager() {
        SETTINGS.load(Settings.class.getClassLoader().getResourceAsStream("db.properties"));
        this.connect();
    }


    /**
     * Adding user to the system.
     *
     * @param user instance of user class.
     */
    public void addUser(User user) {
        this.connect();
        ResultSet set = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO users(user_name, surname, email) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            set = statement.getGeneratedKeys();
            while (set.next()) {
                int id = set.getInt("id");
                user.setId(id);
            }

        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
        try {
            if (set != null) {
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }

    /**
     * Edit user.
     *
     * @param id      of user.
     * @param name    new version of name for user.
     * @param surname new version of surname for user.
     * @param email   new version of email for user.
     */
    public void editUser(int id, String name, String surname, String email) {
        this.connect();
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE users SET user_name = ?, surname = ?, email = ? WHERE id = ? ");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setInt(4, id);
            statement.executeUpdate();
            this.closeConnection();
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
        this.closeConnection();
    }

    /**
     * Remove user from system.
     *
     * @param id unique key for user.
     */
    public void removeUser(int id) {
        this.connect();
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            this.closeConnection();
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
    }

    /**
     * Return user with given id, if exist otherwise return null.
     *
     * @param id of user.
     * @return null if user is not in database, otherwise return user from database.
     */
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int userId = set.getInt("id");
                String userName = set.getString("user_name");
                String surname = set.getString("surname");
                String email = set.getString("email");
                user = new User(userName, surname, email);
                user.setId(userId);
            }
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Return all user at the system.
     *
     * @return list of all controllers.
     */
    public List<User> getAllUsers() {
        this.connect();
        List<User> users = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM users");
            while (set.next()) {
                int id = set.getInt("id");
                String username = set.getString("user_name");
                String surname = set.getString("surname");
                String email = set.getString("email");
                users.add(new User(id, username, surname, email));
            }
            set.close();
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Execute sql prepared statement.
     *
     * @param statement instance of prepared statement.
     * @return result set of execution sql statement.
     */
    private ResultSet executeQuery(PreparedStatement statement) {
        this.connect();
        ResultSet set = null;
        try {
            set = statement.executeQuery();
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
        return set;
    }

    /**
     * Update query.
     *
     * @param sql string view of sql statement.
     */
    private void updateQuery(String sql) {
        this.connect();
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }

    }

    /**
     * Connection to the database.
     */
    private void connect() {
        if (!this.connected.get()) {
            try {
                Class.forName(SETTINGS.getProperty("DB_DRIVER"));
                connection = DriverManager.getConnection(SETTINGS.getProperty("DB_URL"), SETTINGS.getProperty("DB_USER"), SETTINGS.getProperty("DB_PASSWORD"));
                this.connected.set(true);
            } catch (SQLException | ClassNotFoundException e) {
                log.warn(e.getMessage(), e);
            }
        }
    }

    /**
     * Close connection to the database.
     */
    private void closeConnection() {
        if (this.connection != null && this.connected.get()) {
            try {
                this.connection.close();
                this.connected.set(false);
            } catch (SQLException e) {
                log.warn(e.getMessage(), e);
            }
        }
    }

}
