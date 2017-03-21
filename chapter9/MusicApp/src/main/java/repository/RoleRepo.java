package repository;

import model.Role;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.DBManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 * <p>
 * Role repository.
 */
public class RoleRepo {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(RoleRepo.class);

    /**
     * Self instance, it is singleton.
     */
    private static final RoleRepo REPO = new RoleRepo();

    /**
     * Wrapper for work with database.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private RoleRepo() {
        this.dbManager = DBManager.getInstance();
    }

    public static RoleRepo getInstance() {
        return REPO;
    }

    /**
     * Return all user with roles.
     * @return all users with role.
     */
    public List<User> getReferences() {
        List<User> users = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet set = statement.
                    executeQuery(
                            "SELECT u.id, u.email, u.password, r.role_name, r.role_id from user as u left outer join roles as r on u.role_id = r.id")) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    String roleName = set.getString("role_name");
                    int roleId = set.getInt("role_id");
                    User user = new User(id, email, password);
                    user.setRole(new Role(roleId, roleName));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return users;
    }
}
