package dao;

import model.Role;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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
 * DAO for role in system.
 */
public class DaoRole {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoRole.class);

    /**
     * Self instance of this.
     */
    private static final DaoRole DAO = new DaoRole();

    /**
     * For handle response from database.
     */
    private ResultSet set;

    /**
     * For request to the database.
     */
    private PreparedStatement statement;

    /**
     * Wrapper for work with database connection.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private DaoRole() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of this class.
     * @return instance.
     */
    public static DaoRole getInstance() {
        return DAO;
    }

    /**
     * Add new role to the system.
     * @param role instance of role class.
     */
    public int addRole(Role role) {
        int result = 0;
        try {
            this.statement = this.dbManager.
                    getConnection().prepareStatement("INSERT INTO roles (role_name) values(?)", Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, role.getRole());
            this.statement.executeUpdate();
            this.set = this.statement.getGeneratedKeys();
            while (this.set.next()) {
                int id = this.set.getInt("id");
                role.setId(id);
                result = id;
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return result;
    }

    /**
     * Edit already created role at the system.
     * @param role instance of role class.
     */
    public void editRole(Role role) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("UDPATE roles SET role_name = ? WHERE id = ?");
            this.statement.setString(1, role.getRole());
            this.statement.setInt(2, role.getId());
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }

    /**
     * Return role with given id, if it exist, otherwise return null.
     * @param id unique number per role
     * @return role with given id, if it exist, otherwise false.
     */
    public Role getRoleById(int id) {
        Role role = null;
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM role WHERE id = ?");
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int roleId = this.set.getInt("id");
                String roleName = this.set.getString("role_name");
                role = new Role(roleId, roleName);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return role;
    }

    /**
     * Return all role at the system.
     * @return list of roles.
     */
    public List<Role> getAllRoles() {
        List<Role> roles =  new ArrayList<>();
        Statement statement = null;
        try {
            statement = dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * from role_name");
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String roleName = this.set.getString("role_name");
                roles.add(new Role(id, roleName));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return roles;
    }

    /**
     * Remove role from system.
     * @param role instance of role class.
     */
    public void removeRole(Role role) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM roles WHERE id = ?");
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }
}
