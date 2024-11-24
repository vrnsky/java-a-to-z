package dao;

import model.IDInterface;
import service.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.03.2017
 * @param <T> describe with which class may work DAO.
 *
 * This class provide abstraction for all dao's in system.
 */
public abstract class CommonDAO<T> implements IDao<T> {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(CommonDAO.class.getSimpleName());

    /**
     * Wrapper for work with database connection.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    CommonDAO() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * SQL query which select all from table.
     * @return SQL query for collect all order from concrete table.
     */
    public abstract String getSelectAll();

    /**
     * SQL query which select all data from one row.
     * @return SQL query for collect data from one row.
     */
    public abstract String getSelectById();

    /**
     * SQL query which edit object at the system.
     * @return SQL query which edit object in the concrete table.
     */
    public abstract String getEdit();

    /**
     * SQL query which remove order about object from concrete table.
     * @return SQL query which remove order about object at the concrete table.
     */
    public abstract String getRemove();

    /**
     * SQL query which insert data to the database.
     * @return SQL INSERT for concrete table.
     */
    public abstract String getInsert();

    /**
     * Before execute sql statement needs to set data to the statement.
     * This action delegates to the child classes.
     * @param statement instance of PreparedStatement.
     * @param object instance of class.
     */
    public abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    /**
     * Before execute sql statement need to set data to the statement.
     * This action delegates to the child classes.
     * @param statement instance of PreparedStatement.
     * @param object instance of class.
     */
    public abstract void prepareStatementForUpdate(PreparedStatement statement, T object);


    /**
     * Parsing result of response from the database.
     * @param set instance of result set interface.
     * @return list of objects.
     */
    public abstract List<T> parseResultSet(ResultSet set);

    /**
     * Adding new object to the system.
     * @param value instance of T.
     * @return id which generated for given object.
     */
    @Override
    public int add(T value) {
        int id = 0;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(getInsert())) {
            prepareStatementForInsert(statement, value);
            statement.executeUpdate();
            id = getIdFromResultSet(statement.getGeneratedKeys());
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        return id;
    }

    /**
     * Edit already exist at the database object.
     * @param value instance of T.
     */
    @Override
    public void edit(T value) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(getEdit())) {
            prepareStatementForUpdate(statement, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /**
     * Get object by id from concrete table.
     * @param id of T.
     * @return object from system with given id.
     */
    @Override
    public T getById(int id) {
        List<T> list = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(getSelectById())) {
             prepareStatementForReadById(statement, id);
             list = parseResultSet(statement.executeQuery());
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        return list.get(0);
    }

    /**
     * Return list of all object from concrete table.
     * @return object representation of data holding at the concrete table.
     */
    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             Statement statement = connection.createStatement()) {
             ResultSet set = statement.executeQuery(getSelectAll());
             list = parseResultSet(set);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }

        return list;
    }

    /**
     * Remove from concrete table order with given id.
     * @param idInterface instance of IDInterface class.
     */
    @Override
    public void remove(IDInterface idInterface) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(getRemove())) {
            statement.setInt(1, idInterface.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /**
     * Parsing set and find at it id.
     * @param set response from database.
     * @return id of generated object.
     */
    private int getIdFromResultSet(ResultSet set) {
        int id = 0;
        try (ResultSet parseSet = set) {
            while (parseSet.next()) {
                id = parseSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Return ready to execute PreparedStatement.
     * @param statement prepared statement for read by id.
     * @param id unique number.
     */
    private void prepareStatementForReadById(PreparedStatement statement, int id) {
        try {
            statement.setInt(1, id);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
