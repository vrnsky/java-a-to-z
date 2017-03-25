package dao;


import model.Address;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.DBManager;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This data access object for address.
 */
public class DaoAddress implements IDao<Address> {


    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoAddress.class);

    /**
     * Instance of itself, it is singleton.
     */
    private static final DaoAddress DAO = new DaoAddress();


    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private DaoAddress() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of this.
     * @return instance of this class.
     */
    public static DaoAddress getInstance() {
        return DAO;
    }

    /**
     * Add new address to the database.
     * @param address instance of address class.
     * @return id which was generated for given address.
     */
    public int add(Address address) {
        int id = 0;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO address(country, city) values(?, ?) ", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.executeUpdate();
            try (ResultSet set = statement.getGeneratedKeys()) {
                while (set.next()) {
                    id = set.getInt("id");
                    address.setId(id);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return id;
    }

    /**
     * Edit address which already in database.
     * @param address instance of address class.
     */
    public void edit(Address address) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE address SET country = ?, city = ? WHERE id = ?")) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCountry());
            statement.setInt(3, address.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }

    /**
     * Return address with given id if it exist, otherwise null.
     * @param id unique number for each address.
     * @return instance of address class if it exist at the database, otherwise false.
     */
    public Address getById(int id) {
        Address address = null;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM address WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int addressId = set.getInt("id");
                    String country = set.getString("country");
                    String city = set.getString("city");
                    address = new Address(addressId, country, city);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return address;
    }

    /**
     * Remove address from the database.
     * @param address instance of address class.
     */
    public void remove(Address address) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(IDao.REMOVE_BY_ID, "address"))) {
            statement.setInt(1, address.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }

    }

    /**
     * Return list of address.
     * @return all addresses which already in database.
     */
    public List<Address> getAll() {
        List<Address> addresses =  new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
            Statement statement = connection.createStatement()) {
            try (ResultSet set = statement.executeQuery(String.format(IDao.SELECT_ALL, "address"))) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String country = set.getString("country");
                    String city = set.getString("city");
                    addresses.add(new Address(id, country, city));
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return addresses;
    }
}
