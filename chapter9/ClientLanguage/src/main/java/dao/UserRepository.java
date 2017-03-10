package dao;

import model.Address;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.Settings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 */
public class UserRepository {

    private static final Logger LOG = Logger.getLogger(UserRepository.class);
    private static final UserRepository REPO = new UserRepository();
    private DBManager dbManager;
    private PreparedStatement statement;
    private ResultSet set;


    private UserRepository() {
        this.dbManager = DBManager.getInstance();
    }

    public static UserRepository getInstance() {
        return REPO;
    }

    public void addUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("INSERT INTO users(email, password, cvFile, country, city) values(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.setString(3, user.getCvFileLink());
            this.statement.setString(4, user.getAddress().getCountry());
            this.statement.setString(5, user.getAddress().getCity());
            this.set = this.statement.executeQuery();
            while (set.next()) {
                user.setId(this.set.getInt("id"));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            closeDbStructures();
        }
    }

    public void editUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("UPDATE users SET email  = ?, password = ? , cvFile = ? , country = ?, city = ? WHERE id = ?");
            this.statement.setString(1, user.getEmail());
            this.statement.setString(2, user.getPassword());
            this.statement.setString(3, user.getCvFileLink());
            this.statement.setString(4, user.getAddress().getCountry());
            this.statement.setString(5, user.getAddress().getCity());
            this.statement.setInt(6, user.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.closeDbStructures();
        }
    }

    public void removeUser(User user) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            this.statement.setInt(1, user.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            closeDbStructures();
        }

    }

    public boolean isExist(User user) {
        boolean isExist = false;
        try {
            PreparedStatement statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            this.set = statement.executeQuery();
            if (set.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDbStructures();
        }
        return isExist;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = this.dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * FROM users");
            while (set.next()) {
                int id = set.getInt("id");
                String email =  set.getString("email");
                String password = set.getString("password");
                String cvFile = set.getString("cvFile");
                String country = set.getString("country");
                String city = set.getString("city");
                users.add(new User(id, email, password, cvFile, new Address(country, city)));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.closeDbStructures();
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    LOG.log(Level.WARN, e.getMessage(), e);
                }
            }
        }

        return users;
    }

    private void closeDbStructures() {
        this.dbManager.closeConnection();
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }

        if (this.set != null) {
            try {
                this.set.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }
    }
}
