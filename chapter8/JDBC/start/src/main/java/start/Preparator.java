package start;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 * @author evrnsky (voronyansky.egor@yandex.ru)
 * @version 0.1
 * @since 05.01.2017
 *
 * This class need for deploy and drop database in and from database server.
 * It create database and fill it by two tables. Also it may drop all database.
 */
public class Preparator {

    /**
     * URL for connect to the db server, not concrete database.
     */
    private static final String URL = "jdbc:postgresql://localhost:5432/";

    /**
     * Name of user which will work with database.
     */
    private static final String USER = "postgres";

    /**
     * Password for this user.
     */
    private static final String PASSWORD = "55555";

    /**
     * SQL statement for create a new database.
     */
    private static final String CREATE_DATABASE = "create database tracker";

    /**
     * SQL statement fro create item table.
     */
    private static final String CREATE_ITEM_TABLE = String.format("%s\n%s\n%s\n%s\n%s",
            "create table if not exists items(",
            "id serial primary key not null,",
            "item_name character varying(200),",
            "description character varying(2000),",
            "create_time timestamp default now())");

    /**
     * SQL statement for create comments table.
     */
    private static final String CREATE_COMMENTS_TABLE = String.format("%s\n%s\n%s\n%s",
            "create table if not exists comments(",
            "id serial primary key not null,",
            "text character varying(2000),",
            "item_id integer not null references items(id));");


    /**
     * Default constructor.
     */
    public Preparator() {
    }

    /**
     * Create database and item table, comment table.
     * @throws SQLException if problem with access to database or connection already closed.
     */
    public void createDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement sqlStatement = connection.createStatement();
        if (!databaseExist()) {
            sqlStatement.executeUpdate(CREATE_DATABASE);
        }
        connection.close();
        Connection trackerConnection = DriverManager.getConnection(String.format("%s%s", URL, "tracker"), USER, PASSWORD);
        sqlStatement = trackerConnection.createStatement();
        sqlStatement.executeUpdate(CREATE_ITEM_TABLE);
        sqlStatement.executeUpdate(CREATE_COMMENTS_TABLE);
        sqlStatement.close();
        trackerConnection.close();
    }

    /**
     * Drop database from server.
     * Do not remove first sql query operation because it kill another connection to the database.
     * It is need for correct perform unit test, because after test database must be dropped.
     * @throws SQLException if problem with access to the database or connection already closed.
     */
    public void dropDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement drop = connection.createStatement();
        drop.executeQuery("select pid, pg_terminate_backend(pid) from pg_stat_activity WHERE datname = 'tracker' and pid <> pg_backend_pid()");
        drop.executeUpdate("drop database if exists tracker");
        connection.close();
        drop.close();
    }

    /**
     * Method check that database exist at the database server.
     * Because at the PostgreSQL does not support if not exist for create database operation it
     * was wrotten this bicycle.
     * @return true if database already exist at the database server.
     * @throws SQLException if some problem with access to the server or connection already closed.
     */
    private boolean databaseExist() throws SQLException {
        PreparedStatement sqlStatement = null;
        ResultSet set = null;
        boolean exist = false;
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        try {
            sqlStatement = connection.prepareStatement("select 1 from pg_database where datname = ?");
            sqlStatement.setString(1, "tracker");
            set = sqlStatement.executeQuery();
            while (set.next()) {
                exist = set.getInt("?column?") == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sqlStatement != null) {
                sqlStatement.close();
            }
            if (set != null) {
                set.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return exist;
    }
}
