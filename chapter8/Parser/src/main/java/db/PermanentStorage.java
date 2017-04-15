package db;

import start.Settings;
import start.Vacancy;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.DriverManager;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.01.2017
 *
 * Implementation of permanent storage.
 */
public class PermanentStorage {

    /**
     * Instance of logger.
     */
    private static final Logger LOGGER = Logger.getLogger(PermanentStorage.class);

    /**
     * SQL query for create database.
     */
    private static final String CREATE_TABLE_JOBS = String.format("%s\n%s\n%s\n%s\n%s\n%s",
            "create table if not exists jobs(",
            "id serial primary key,",
            "title varchar(2000),",
            "description varchar(50000),",
            "url varchar(300),",
            "publish_time timestamp)");

    /**
     * Instance of database connection.
     */
    private Connection connection;

    /**
     * Flag which means that we have connection to the database or already to the parser database.
     */
    private boolean connected;

    /**
     * Instance of settings class.
     */
    private Settings settings;

    /**
     * URL which specify pointer to the database.
     */
    private String dbUrl;

    /**
     * User of database.
     */
    private String dbUser;

    /**
     * Password for access to the database.
     */
    private String dbPassword;

    /**
     * URL to the parser database.
     */
    private String dbParserUrl;

    /**
     * Flag which means that we already init.
     */
    private boolean inited = false;

    /**
     * Default constructor.
     */
    public PermanentStorage() {
        if (!this.inited) {
            init();
        }
    }

    /**
     * Execute query which return some data.
     * @param sql query.
     * @return result of execution.
     */
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        connect();
        try {
            Statement statement = this.connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return resultSet;
    }

    /**
     * Adding vacancy to the database.
     * @param vacancy instance of vacancy fo adding.
     * @return generated keys.
     */
    public ResultSet addVacancy(Vacancy vacancy) {
        ResultSet resultSet = null;
        this.connectToParserDB();
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into jobs(title, description, url, publish_time) values(?, ?, ?, ?)");
            statement.setString(1, vacancy.getTitle());
            statement.setString(2, vacancy.getRequirements());
            statement.setString(3, vacancy.getUrl());
            statement.setTimestamp(4, new Timestamp(vacancy.getPublishTime()));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return resultSet;
    }

    /**
     * Execute query which update a database return only number of orders.
     * @param sql statement for executing.
     * @return count of orders which was changed.
     */
    public int executeUpdate(String sql) {
        int updated = 0;
        connect();
        try {
            Statement statement = this.connection.createStatement();
            updated = statement.executeUpdate(sql);
        } catch (SQLException exc) {
            LOGGER.log(Level.WARN, exc.getMessage(), exc);
        } finally {
            this.closeConnection();
        }
        return updated;
    }

    /**
     * Connection to the parser database.
     */
    public void connectToParserDB() {
        this.closeConnection();
        try {
            this.connection = DriverManager.getConnection(dbParserUrl, dbUser, dbPassword);
            this.connected = true;
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage(), e);
        }
    }

    /**
     * Init all need for first connection to the database.
     */
    private void init() {
        this.settings = new Settings();
        this.settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        this.dbUrl = this.settings.getValue("DB_URL");
        this.dbUser = this.settings.getValue("DB_USER");
        this.dbPassword = this.settings.getValue("DB_PASSWORD");
        this.dbParserUrl = this.settings.getValue("DB_PARSER_URL");
        this.createDatabase("parser");
        this.connectToParserDB();
        this.executeUpdate(CREATE_TABLE_JOBS);
        this.inited = true;
    }

    /**
     * Create a new database with given name.
     * @param dbName of database.
     */
    private void createDatabase(String dbName) {
        try {
            if (!this.databaseExist(dbName)) {
                this.executeUpdate(String.format("create database %s", dbName));
                LOGGER.log(Level.INFO, String.format("%s database was successfully created", dbName));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, e.getMessage(), e);
        }
    }

    /**
     * Connect to the database server.
     */
    private void connect() {
        if (!this.connected) {
            try {
                this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                connected = true;
            } catch (SQLException e) {
                LOGGER.log(Level.WARN, e.getMessage(), e);
            }
        }
    }

    /**
     * Close connection.
     */
    private void closeConnection() {
        if (this.connection != null && connected) {
            try {
                this.connection.close();
                connected = false;
            } catch (SQLException e) {
                LOGGER.log(Level.WARN, e.getMessage(), e);
            }
        }
    }

    /**
     * Checking that database already exist at the database server.
     * @param dbName for searching at the server.
     * @return true if database already exist, otherwise false.
     * @throws SQLException if some problem with access.
     */
    private boolean databaseExist(String dbName) throws SQLException {
        PreparedStatement sqlStatement = null;
        ResultSet set = null;
        boolean exist = false;
        this.connect();
        try {
            sqlStatement = this.connection.prepareStatement("select 1 from pg_database where datname = ?");
            sqlStatement.setString(1, dbName);
            set = sqlStatement.executeQuery();
            while (set.next()) {
                exist = set.getInt("?column?") == 1;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARN, e.getMessage(), e);
        } finally {
            if (sqlStatement != null) {
                sqlStatement.close();
            }
            if (set != null) {
                set.close();
            }
            if (this.connection != null && this.connected) {
                this.closeConnection();
            }
        }
        return exist;
    }


}
