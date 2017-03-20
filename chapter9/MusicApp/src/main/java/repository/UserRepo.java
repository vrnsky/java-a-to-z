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
 */
public class UserRepo {

    private static final Logger LOG = Logger.getLogger(UserRepo.class);
    private static final UserRepo REPO = new UserRepo();
    private static final String FIND_BY_MT = String.format(
            "%s%s%s", "select u.id, u.email, u.role_id, address_id, m.mtype from users as u",
            "left outer join usermusictype as umt on u.id = umt.user_id",
            "left outer join musictype as m on m.id = umt.id where umt.musictype_id = ?");

    private DBManager dbManager;
    private ResultSet set;
    private PreparedStatement statement;
    private UserRepo() {
        this.dbManager = DBManager.getInstance();
    }

    public static UserRepo getInstance() {
        return REPO;
    }

    public void addUser(User user, Address address, Role role) {
        DaoUser.getInstance().addUser(user);
        DaoRole.getInstance().addRole(role);
        DaoAddress.getInstance().addAddress(address);
    }

    public List<User> findByAddress(Address address) {
        List<User> users = new ArrayList<>();
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE address_id = ?");
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String email = this.set.getString("email");
                String password = this.set.getString("password");
                Role role = DaoRole.getInstance().getRoleById(this.set.getInt("role_id"));
                Address adr = DaoAddress.getInstance().getAddressById(address.getId());
                User user = new User(id, email, password);
                user.setAddress(adr);
                user.setRole(role);
                users.add(user);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return users;
    }

    public List<User> findByRole(Role role) {
        List<User> users = new ArrayList<>();
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE role_id = ?");
            this.statement.setInt(1, role.getId());
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String email = this.set.getString("email");
                String password = this.set.getString("password");
                User user = new User(id, email, password);
                users.add(user);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return users;
    }

    public List<User> findByMusicType(MusicType type) {
        List<User> users = new ArrayList<>();
        try {
            this.statement = this.dbManager.
                    getConnection().
                    prepareStatement(FIND_BY_MT);
            this.statement.setInt(1, type.getId());
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String email = this.set.getString("email");
                String password = this.set.getString("password");
                Role role = DaoRole.getInstance().getRoleById(this.set.getInt("role_id"));
                Address address = DaoAddress.getInstance().getAddressById(this.set.getInt("address_id"));
                User user = new User(id, email, password);
                user.setAddress(address);
                user.setRole(role);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return users;
    }
}
