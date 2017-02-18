package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 *
 * This wrapper for work with database.
 */
public class DBManager {

    /**
     * Settings class, provide access to the properties files.
     */
    private static final Settings SETTINGS = new Settings();

    /**
     * Itself instance, it is singleton.
     */
    private static final DBManager DB_MANAGER = new DBManager();


    /**
     * URL to database.
     */
    private String dbUrl;

    /**
     * Database user.
     */
    private String dbUser;

    /**
     * Database password.
     */
    private String dbPassword;

    /**
     * Flag which means that we already connect to the database.
     */
    private boolean connected = false;

    /**
     * Instance of connection to the database.
     */
    private Connection connection;


    /**
     * Create a new manager and init all fields. Also load driver for JDBC.
     */
    private DBManager() {
        SETTINGS.load(Settings.class.getClassLoader().getResourceAsStream("db.properties"));
        this.dbUrl = SETTINGS.getProperty("DB_URL");
        this.dbUser = SETTINGS.getProperty("DB_USER");
        this.dbPassword = SETTINGS.getProperty("DB_PASSWORD");
        try {
            Class.forName(SETTINGS.getProperty("DB_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return instance of itself.
     * @return itself instance.
     */
    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    /**
     * Return connection to the database.
     * @return connection.
     */
    public Connection getConnection() {
        this.connect();
        return this.connection;
    }

    /**
     * Set connection to the database.
     */
    private void connect() {
        if (this.connection == null && !this.connected) {
            try {
                this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close connection with database.
     */
    public void closeConnection() {
        if (this.connection != null && this.connected) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
