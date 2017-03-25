package dao;

import model.Role;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * DAO for role in system.
 */
public class DaoRole extends CommonDAO<Role> {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoRole.class);

    /**
     * Self instance of this.
     */
    private static final DaoRole DAO = new DaoRole();


    /**
     * Default constructor.
     */
    private DaoRole() {
        super();
    }

    /**
     * Return instance of this class.
     * @return instance.
     */
    public static DaoRole getInstance() {
        return DAO;
    }

    /**
     * SQL query which select all from table.
     * @return SQL query for collect all order from concrete table.
     */
    @Override
    public String getSelectAll() {
        return "select * from roles";
    }

    /**
     * SQL query which select all data from one row.
     * @return SQL query for collect data from one row.
     */
    @Override
    public String getSelectById() {
        return "select * from roles where id = ?";
    }

    /**
     * SQL query which edit object at the system.
     * @return SQL query which edit object in the concrete table.
     */
    @Override
    public String getEdit() {
        return "update roles set role_name = ? where id = ?";
    }

    /**
     * SQL query which remove order about object from concrete table.
     * @return SQL query which remove order about object at the concrete table.
     */
    @Override
    public String getRemove() {
        return "delete from roles where id = ?";
    }

    /**
     * SQL query which insert data to the database.
     * @return SQL INSERT for concrete table.
     */
    @Override
    public String getInsert() {
        return "insert into roles (role_name) values (?)";
    }

    /**
     * Before execute statement, need to set data.
     * @param statement instance of PreparedStatement.
     * @param role instance of role class.
     */
    @Override
    public void prepareStatementForInsert(PreparedStatement statement, Role role) {
        try {
            statement.setString(1, role.getRole());
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }
    }

    /**
     * Before execute statement need to set data.
     * @param statement instance of PreparedStatement.
     * @param role instance of role class.
     */
    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Role role) {
        try {
            statement.setString(1, role.getRole());
            statement.setInt(2, role.getId());
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }
    }

    /**
     * Parse response from database.
     * @param set instance of result set interface.
     * @return list of roles.
     */
    @Override
    public List<Role> parseResultSet(ResultSet set) {
        List<Role> roles = new ArrayList<>();
        try (ResultSet parseSet = set) {
            while (parseSet.next()) {
                int id = parseSet.getInt("id");
                String roleName = parseSet.getString("role_name");
                roles.add(new Role(id, roleName));
            }
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }
        return roles;
    }
}
