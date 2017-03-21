package dao;

import model.Address;
import model.MusicType;
import model.Role;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 *
 * This is model of user.
 */
public class DaoUser {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoUser.class);

    /**
     * Self instance, it is singleton.
     */
    private static final DaoUser DAO = new DaoUser();

    /**
     * Wrapper for work with database connection.
     */
    private DBManager dbManager;


    private DaoAddress daoAddress;
    private DaoRole daoRole;

    /**
     * Default constructor.
     */
    private DaoUser() {
        this.dbManager = DBManager.getInstance();
        this.daoRole = DaoRole.getInstance();
        this.daoAddress = DaoAddress.getInstance();
    }

    /**
     * Return instance of this class.
     * @return instance of this class.
     */
    public static DaoUser getInstance() {
        return DAO;
    }

    public void addUser(User user) {
        int addressId = this.daoAddress.addAddress(user.getAddress());
        int roleId = this.daoRole.addRole(user.getRole());
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO users (email, password, role_id, address_id) values (?, ?, ?, ?)",  Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, roleId);
            statement.setInt(4, addressId);
            statement.executeUpdate();
            try (ResultSet set = statement.getGeneratedKeys()) {
                while (set.next()) {
                    user.setId(set.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit already exist user at the system.
     * @param user instance of user class.
     */
    public void editUser(User user) {
        this.daoAddress.editAddress(user.getAddress());
        this.daoRole.editRole(user.getRole());
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPADTE users SET email = ?, password = ? WHERE id = ?")) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
    }

    /**
     * Return user with given id if it exist at the database, otherwise false.
     * @param id unique number per user.
     * @return user object if it exist, otherwise false.
     */
    public User getUserById(int id) {
        User user = null;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")){
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int originalId = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    Role role = this.daoRole.getRoleById(set.getInt("role_id"));
                    Address address = this.daoAddress.getAddressById(set.getInt("address_id"));
                    List<MusicType> types = getUserMusicTypes(originalId);
                    user = new User(originalId, email, password);
                    user.setAddress(address);
                    user.setRole(role);
                    user.addMusicType(types);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return user;
    }

    /**
     * Return list of all users.
     * @return list of all users.
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
            Statement statement = connection.createStatement()) {
            try (ResultSet set = statement.executeQuery("SELECT * FROM users")) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    Role role = DaoRole.getInstance().getRoleById(set.getInt("role_id"));
                    Address address = DaoAddress.getInstance().getAddressById(set.getInt("address_id"));
                    User user = new User(id, email, password);
                    user.setAddress(address);
                    user.setRole(role);
                    user.addMusicType(getUserMusicTypes(id));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return users;
    }

    /**
     * Remove users from system.
     * @param user instance of user class.
     */
    public void removeUser(User user) {
        this.daoAddress.removeAddress(user.getAddress());
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?"))  {
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return all music types for given user.
     * @param id of user for search music types.
     * @return list of music type for user with given id.
     */
    private List<MusicType> getUserMusicTypes(int id) {
        List<MusicType> types = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT mt.type FROM musictype as mt right outer join usermusictypes as uts on uts.musictype_id = mt.id WHERE uts.user_id = ?")) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    types.add(new MusicType(id, set.getString("type")));
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return types;
    }

}
