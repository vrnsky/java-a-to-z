package dao;


import model.Address;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.Closer;
import service.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This data access object for address.
 */
public class DaoAddress {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoAddress.class);

    /**
     * Instance of itself, it is singleton.
     */
    private static final DaoAddress DAO = new DaoAddress();

    /**
     * Statement for work with database.
     */
    private PreparedStatement statement;

    /**
     * Set for work with database.
     */
    private ResultSet set;

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
     */
    public int addAddress(Address address) {
        int id = 0;
        try {
            this.statement = this.dbManager.getConnection().
                    prepareStatement("INSERT INTO address(country, city) values(?, ?) ", Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, address.getCountry());
            this.statement.setString(2, address.getCity());
            this.statement.executeUpdate();
            this.set = this.statement.getGeneratedKeys();
            while (set.next()) {
                id = this.set.getInt("id");
                address.setId(id);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return id;
    }

    /**
     * Edit address which already in database.
     * @param address instance of address class.
     */
    public void editAddress(Address address) {
        try {
            this.statement = dbManager.getConnection().prepareStatement("UPDATE address SET country = ?, city = ? WHERE id = ?");
            this.statement.setString(1, address.getCountry());
            this.statement.setString(2, address.getCountry());
            this.statement.setInt(3, address.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
    }

    /**
     * Return address with given id if it exist, otherwise null.
     * @param id unique number for each address.
     * @return instance of address class if it exist at the database, otherwise false.
     */
    public Address getAddressById(int id) {
        Address address = null;
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM address WHERE id = ?");
            this.statement.setInt(1, id);
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int addressId = this.set.getInt("id");
                String country = this.set.getString("country");
                String city = this.set.getString("city");
                address = new Address(addressId, country, city);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return address;
    }

    /**
     * Remove address from the database.
     * @param address instance of address class.
     */
    public void removeAddress(Address address) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM address WHERE id = ?");
            this.statement.setInt(1, address.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }

    }

    /**
     * Return list of address.
     * @return all addresses which already in database.
     */
    public List<Address> getAllAddresses() {
        List<Address> addresses =  new ArrayList<>();
        Statement statement = null;
        try {
            statement = this.dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * FROM address");
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String country = this.set.getString("country");
                String city = this.set.getString("city");
                addresses.add(new Address(id, country, city));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();;
            Closer.closeDbStructure(this.set, statement);
        }

        return addresses;
    }
}
