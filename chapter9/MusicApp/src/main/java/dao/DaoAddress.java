package dao;

import model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 * <p>
 * This data access object for address.
 */
public class DaoAddress extends CommonDAO<Address> {

    /**
     * Instance of logger.
     */
    private static final Logger log = LoggerFactory.getLogger(DaoAddress.class);

    /**
     * Instance of itself, it is singleton.
     */
    private static final DaoAddress DAO = new DaoAddress();

    /**
     * Default constructor.
     */
    private DaoAddress() {
        super();
    }

    /**
     * SQL query which select all from table.
     * @return SQL query for collect all order from concrete table.
     */
    @Override
    public String getSelectAll() {
        return "select * from address";
    }

    /**
     * SQL query which select all data from one row.
     * @return SQL query for collect data from one row.
     */
    @Override
    public String getSelectById() {
        return "select * from address where id = ?";
    }

    /**
     * SQL query which edit object at the system.
     * @return SQL query which edit object in the concrete table.
     */
    @Override
    public String getEdit() {
        return "update address set country = ?, city = ? where id = ?";
    }

    /**
     * SQL query which remove order about object from concrete table.
     * @return SQL query which remove order about object at the concrete table.
     */
    @Override
    public String getRemove() {
        return "delete from address where id = ?";
    }

    /**
     * SQL query which insert data to the database.
     * @return SQL INSERT for concrete table.
     */
    @Override
    public String getInsert() {
        return "insert into address (country, city) values(?, ?)";
    }

    /**
     * Return instance of this.
     * @return instance of this class.
     */
    public static DaoAddress getInstance() {
        return DAO;
    }

    /**
     * Set data for statement.
     * @param statement instance of PreparedStatement.
     * @param address instance of class.
     */
    @Override
    public void prepareStatementForInsert(PreparedStatement statement, Address address) {
        try {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Set data to the statement.
     * @param statement instance of PreparedStatement.
     * @param address instance of address class.
     */
    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Address address) {
        try {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setInt(3, address.getId());
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Parse response from database.
     * @param set instance of result set interface.
     * @return list of addresses.
     */
    @Override
    public List<Address> parseResultSet(ResultSet set) {
        List<Address> addresses = new ArrayList<>();
        try (ResultSet parseSet = set) {
            while (parseSet.next()) {
                int id = parseSet.getInt("id");
                String country = parseSet.getString("country");
                String city = parseSet.getString("city");
                addresses.add(new Address(id, country, city));
            }
        } catch (SQLException sqlEx) {
            log.error(sqlEx.getMessage(), sqlEx);
            throw new RuntimeException(sqlEx.getMessage(), sqlEx);
        }
        return addresses;
    }


}
