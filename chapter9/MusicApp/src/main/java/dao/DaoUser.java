package dao;

import model.Address;
import model.Role;
import model.User;
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
 * This is model of user.
 */
public class DaoUser extends CommonDAO<User> {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoUser.class);

    /**
     * Self instance, it is singleton.
     */
    private static final DaoUser DAO = new DaoUser();


    /**
     * Dao for address.
     */
    private CommonDAO<Address> daoAddress;

    /**
     * Dao for roles.
     */
    private CommonDAO<Role> daoRole;

    /**
     * Default constructor.
     */
    private DaoUser() {
        super();
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

    @Override
    public String getSelectAll() {
        return "select * from users";
    }

    @Override
    public String getSelectById() {
        return "select * from users where id = ?";
    }

    @Override
    public String getEdit() {
        return "update users set email = ?, password = ? where id = ?";
    }

    @Override
    public String getRemove() {
        return "delete from users where id = ?";
    }

    @Override
    public String getInsert() {
        return "insert into users(email, password, role_id, address_id) values(?, ?, ?, ?)";
    }

    @Override
    public void prepareStatementForInsert(PreparedStatement statement, User user) {
        try {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, this.daoRole.add(user.getRole()));
            statement.setInt(4, this.daoAddress.add(user.getAddress()));
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, User user) {
        this.daoAddress.edit(user.getAddress());
        this.daoRole.edit(user.getRole());
        try {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }
    }

    @Override
    public List<User> parseResultSet(ResultSet set) {
        List<User> users = new ArrayList<>();
        try (ResultSet parseSet = set) {
            while (parseSet.next()) {
                int id = parseSet.getInt("id");
                String email = parseSet.getString("email");
                String password = parseSet.getString("password");
                Role role = this.daoRole.getById(parseSet.getInt("role_id"));
                Address address = this.daoAddress.getById(parseSet.getInt("address_id"));
                User user = new User(id, email, password);
                user.setRole(role);
                user.setAddress(address);
                users.add(user);
            }
        } catch (SQLException e) {
            LOG.log(Level.ERROR, e.getMessage(), e);
        }

        return users;
    }
}
