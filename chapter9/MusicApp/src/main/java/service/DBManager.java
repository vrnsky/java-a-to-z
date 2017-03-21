package service;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 */
public class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class);

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
     * Pool of connection.
     */
    private PGSimpleDataSource dataSource;


    /**
     * Create a new manager and init all fields. Also load driver for JDBC.
     */
    private DBManager() {
        init();
        this.dataSource = new PGSimpleDataSource();
        this.dataSource.setUser(this.dbUser);
        this.dataSource.setPassword(this.dbPassword);
        this.dataSource.setDatabaseName(this.dbUrl);
    }

    /**
     * Return instance of itself.
     * @return itself instance.
     */
    public static DBManager getInstance() {
        return DB_MANAGER;
    }

    /**
     * Return connection from pool to the database.
     * @return connection.
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = this.dataSource.getConnection();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return connection;
    }



    private void init() {
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

}
