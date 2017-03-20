package dao;

import model.Address;
import model.MusicType;
import model.Role;
import model.User;
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

    /**
     * For handle response from database.
     */
    private ResultSet set;

    /**
     * For request to the database.
     */
    private PreparedStatement statement;

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
        try {
            this.statement = this.dbManager.
                    getConnection().prepareStatement(
                    "INSERT INTO users (email, password, role_id, address_id) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.setInt(3, roleId);
            this.statement.setInt(4, addressId);
            this.statement.executeUpdate();
            this.set = this.statement.getGeneratedKeys();
            while (this.set.next()) {
                user.setId(this.set.getInt("id"));
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
        try {
            this.statement = this.dbManager.
                    getConnection().
                    prepareStatement("UPADTE users SET email = ?, password = ? WHERE id = ?");
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.executeUpdate();
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
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE id = ?");
            this.statement.setInt(1, id);
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int originalId = this.set.getInt("id");
                String email = this.set.getString("email");
                String password = this.set.getString("password");
                int roleId = this.set.getInt("role_id");
                int addressId = this.set.getInt("address_id");
                List<MusicType> types = getUserMusicTypes(originalId);
                user = new User(originalId, email, password);
                user.setAddress(DaoAddress.getInstance().getAddressById(addressId));
                user.setRole(DaoRole.getInstance().getRoleById(roleId));
                user.addMusicType(types);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return user;
    }

    /**
     * Return list of all users.
     * @return list of all users.
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = this.dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * FROM users");
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String email = this.set.getString("email");
                String password = this.set.getString("password");
                Role role = DaoRole.getInstance().getRoleById(this.set.getInt("role_id"));
                Address address = DaoAddress.getInstance().getAddressById(this.set.getInt("address_id"));
                User user = new User(id, email, password);
                user.setAddress(address);
                user.setRole(role);
                user.addMusicType(getUserMusicTypes(id));
                users.add(user);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, statement);
        }
        return users;
    }

    /**
     * Remove users from system.
     * @param user instance of user class.
     */
    public void removeUser(User user) {
        this.daoAddress.removeAddress(user.getAddress());
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            this.statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }

    }

    /**
     * Return all music types for given user.
     * @param id of user for search music types.
     * @return list of music type for user with given id.
     */
    private List<MusicType> getUserMusicTypes(int id) {
        List<MusicType> types = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            statement = this.dbManager.
                    getConnection().prepareStatement(
                   "SELECT mt.type FROM musictype as mt right outer join usermusictypes as uts on uts.musictype_id = mt.id WHERE uts.user_id = ?");
            statement.setInt(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                types.add(new MusicType(id, set.getString("type")));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            Closer.closeDbStructure(set, statement);
        }
        return types;
    }

}
