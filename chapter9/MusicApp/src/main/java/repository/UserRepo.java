package repository;
import dao.DaoAddress;
import dao.DaoRole;
import dao.DaoUser;
import model.Address;
import model.MusicType;
import model.Role;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import service.DBManager;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 */
public class UserRepo {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(UserRepo.class);

    /**
     * Instance of itselft.
     */
    private static final UserRepo REPO = new UserRepo();

    /**
     * Hard sql query which find user by music type.
     */
    private static final String FIND_BY_MT = String.format(
            "%s%s%s", "select u.id, u.email, u.role_id, address_id, m.mtype from users as u",
            "left outer join usermusictype as umt on u.id = umt.user_id",
            "left outer join musictype as m on m.id = umt.id where umt.musictype_id = ?");

    /**
     * Manager for interact with database.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private UserRepo() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of itself.
     * @return instance of itself.
     */
    public static UserRepo getInstance() {
        return REPO;
    }

    /**
     * Add user, address and role to the system.
     * @param user instance of user class.
     * @param address instance of address class.
     * @param role instance of role class.
     */
    public void addUser(User user, Address address, Role role) {
        DaoUser.getInstance().addUser(user);
        DaoRole.getInstance().add(role);
        DaoAddress.getInstance().add(address);
    }

    /**
     * Find user by address and return it.
     * @param address instance of address class.
     * @return list of users which address are equals to the given address.
     */
    public List<User> findByAddress(Address address) {
        List<User> users = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE address_id = ?")) {
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    Role role = DaoRole.getInstance().getById(set.getInt("role_id"));
                    Address adr = DaoAddress.getInstance().getById(address.getId());
                    User user = new User(id, email, password);
                    user.setAddress(adr);
                    user.setRole(role);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return users;
    }

    /**
     * Find user by role and return it.
     * @param role instance of role.
     * @return list of users which role are equals to the given role.
     */
    public List<User> findByRole(Role role) {
        List<User> users = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE role_id = ?")) {
            statement.setInt(1, role.getId());
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    User user = new User(id, email, password);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return users;
    }

    /**
     * Return list of user with given music type.
     * @param type instance of music type class.
     * @return list of users which music type are contains the given music type.
     */
    public List<User> findByMusicType(MusicType type) {
        List<User> users = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_MT)) {
            statement.setInt(1, type.getId());
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String password = set.getString("password");
                    Role role = DaoRole.getInstance().getById(set.getInt("role_id"));
                    Address address = DaoAddress.getInstance().getById(set.getInt("address_id"));
                    User user = new User(id, email, password);
                    user.setAddress(address);
                    user.setRole(role);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return users;
    }
}
