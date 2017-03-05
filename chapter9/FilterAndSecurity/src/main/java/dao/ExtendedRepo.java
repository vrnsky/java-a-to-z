package dao;
import model.Role;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.02.2017
 *
 * This is extended version of repo.
 */
public class ExtendedRepo {

    /**
     * It is singleton.
     */
    private static final ExtendedRepo REPO = new ExtendedRepo();

    /**
     * Wrapper for database.
     */
    private DBManager dbManager;

    /**
     * Result set for data from database.
     */
    private ResultSet set;

    /**
     * SQL statement.
     */
    private Statement statement;

    /**
     * Default constructor.
     */
    private ExtendedRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of itself.
     * @return itself.
     */
    public static ExtendedRepo getInstance() {
        return REPO;
    }

    /**
     * Add user to the system.
     * @param user instance of user class.
     */
    public void addUser(User user) {
        PreparedStatement statement = null;
        try {
            statement = this.dbManager.getConnection().prepareStatement("INSERT INTO authapp (login, password, role) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, Integer.valueOf(user.getRole().getDesc()));
            statement.executeUpdate();
            this.set = statement.getGeneratedKeys();
            while (set.next()) {
                int id = set.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get user by login and password.
     * @param login of user.
     * @param password of user.
     * @return user if it exist at the database, otherwise false.
     */
    public User getUser(String login, String password) {
        User user = null;
        ResultSet set = null;

        try {
            PreparedStatement statement =
                    this.dbManager.getConnection().prepareStatement("select a.id, a.login, a.password, r.role_name from authapp as a left outer join roles as r on a.role = r.id where a.login = ? AND a.password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String role = set.getString("role_name");
                user = new User(id, login, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            this.closeDBStructures();
        }
        return user;
    }

    /**
     * Return all users from database.
     * @return list of users.
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            statement = this.dbManager.getConnection().createStatement();
            set = statement.executeQuery("select a.id, a.login, a.password, r.role_name from authapp as a left outer join roles as r on a.role = r.id order by a.id ASC");
            while (set.next()) {
                int id = set.getInt("id");
                String login = set.getString("login");
                String password = set.getString("password");
                String role = set.getString("role_name");
                users.add(new User(id, login, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            this.closeDBStructures();
        }
        return users;
    }

    /**
     * Return all roles at the system.
     * @return list of roles.
     */
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        try {
            this.statement = this.dbManager.getConnection().createStatement();
            this.set = this.statement.executeQuery("SELECT role_name FROM roles");
            while (this.set.next()) {
                String desc = this.set.getString("role_name");
                roles.add(new Role(desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            this.closeDBStructures();
        }
        return roles;
    }

    /**
     * Return user with given id if it exist at the database.
     * @param id unique number per user.
     * @return user if it exist at the db, otherwise false.
     */
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement statement = this.dbManager.getConnection().
                                          prepareStatement("select a.id, a.login, a.password, r.role_name from authapp as a left outer join roles as r on a.role = r.id where a.id = ?");
            statement.setInt(1, id);
            this.set = statement.executeQuery();
            while (this.set.next()) {
                int userId = this.set.getInt("id");
                String login = this.set.getString("login");
                String password = this.set.getString("password");
                String role = this.set.getString("role_name");
                user = new User(userId, login, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            this.closeDBStructures();
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    /**
     * Edit exist user at the system.
     * @param id of user.
     * @param login of user.
     * @param password of user.
     * @param role of user.
     */
    public void editUser(int id, String login, String password, int role) {
        PreparedStatement statement = null;
        try {
            statement = this.dbManager.getConnection().prepareStatement("UPDATE authapp SET login = ?, password = ?, role = ? WHERE id = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setInt(3, role);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            this.dbManager.closeConnection();
        }
    }

    /**
     * Remove user from the system.
     * @param id unique number per user.
     */
    public void removeUser(int id) {
        PreparedStatement statement = null;
        try {
            statement = this.dbManager.getConnection().prepareStatement("DELETE FROM authapp WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            this.dbManager.closeConnection();
        }
    }

    /**
     * Add new role to the system.
     * @param roleName name of new role.
     */
    public void addRole(String roleName) {
        PreparedStatement statement = null;
        try {
            statement = this.dbManager.getConnection().prepareStatement("INSERT INTO roles (role_name) values(?)");
            statement.setString(1, roleName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            this.dbManager.closeConnection();
        }
    }

    /**
     * Remove role from system.
     * @param id of role.
     */
    public void removeRole(int id) {
        PreparedStatement statement = null;
        try {
            statement = this.dbManager.getConnection().prepareStatement("DELETE FROM roles WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            this.dbManager.closeConnection();
        }
    }

    /**
     * Close all variables which needed for work with database.
     */
    private void closeDBStructures() {
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (this.set != null) {
            try {
                this.set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
