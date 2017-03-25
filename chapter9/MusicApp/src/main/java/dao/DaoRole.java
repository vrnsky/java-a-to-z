package dao;

import model.Role;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.DBManager;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
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
public class DaoRole implements IDao<Role> {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoRole.class);

    /**
     * Self instance of this.
     */
    private static final DaoRole DAO = new DaoRole();



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
     * @return id which generated for given role.
     */
    public int add(Role role) {
        int result = 0;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO roles (role_name) values(?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, role.getRole());
            statement.executeUpdate();
            try (ResultSet set = statement.getGeneratedKeys()) {
                while (set.next()) {
                    result = set.getInt("id");
                    role.setId(result);
                }
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
    public void edit(Role role) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("UDPATE roles SET role_name = ? WHERE id = ?")) {
            statement.setString(1, role.getRole());
            statement.setInt(2, role.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }

    /**
     * Return role with given id, if it exist, otherwise return null.
     * @param id unique number per role
     * @return role with given id, if it exist, otherwise false.
     */
    public Role getById(int id) {
        Role role = null;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM role WHERE id = ?")) {
            try  (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int roleId = set.getInt("id");
                    String roleName = set.getString("role_name");
                    role = new Role(roleId, roleName);
                }
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
    public List<Role> getAll() {
        List<Role> roles =  new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet set = statement.executeQuery("SELECT * from role_name")) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String roleName = set.getString("role_name");
                    roles.add(new Role(id, roleName));
                }
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
    public void remove(Role role) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM roles WHERE id = ?")) {
            statement.setInt(1, role.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }
}
