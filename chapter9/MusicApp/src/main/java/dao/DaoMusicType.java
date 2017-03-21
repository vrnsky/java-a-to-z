package dao;

import model.MusicType;
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
 * <p>
 * This is dao for music type.
 */
public class DaoMusicType implements IDao<MusicType> {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(DaoMusicType.class);

    /**
     * Self instance, it is singleton.
     */
    private static final DaoMusicType DAO = new DaoMusicType();

    /**
     * Wrapper for work with database connection.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private DaoMusicType() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return instance of this.
     * @return instance of this.
     */
    public static DaoMusicType getInstance() {
        return DAO;
    }

    /**
     * Add new music type to the system.
     * @param type instance of music type class.
     */
    public int add(MusicType type) {
        int id = 0;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO musictype (type) values(?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, type.getType());
            statement.executeUpdate();
            try (ResultSet set = statement.getGeneratedKeys()) {
                while (set.next()) {
                    id = set.getInt("id");
                    type.setId(id);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return id;
    }

    /**
     * Edit already exist at the database music type.
     * @param type instance of music type.
     */
    public void edit(MusicType type) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE musictype SET type = ? WHERE id = ?")) {
            statement.setString(1, type.getType());
            statement.setInt(2, type.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }

    }

    /**
     * Return music type with given id, if it exist at the db, otherwise return null.
     * @param id unique number per music type.
     * @return music type instance with given id, if it exist, otherwise false.
     */
    public MusicType getById(int id) {
        MusicType resultType = null;
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM musictype WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    int typeId = set.getInt("id");
                    String type = set.getString("type");
                    resultType = new MusicType(typeId, type);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return resultType;
    }

    /**
     * Return list of music type which already in db.
     * @return list of music type.
     */
    public List<MusicType> getAll() {
        List<MusicType> types = new ArrayList<>();
        try (Connection connection = this.dbManager.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet set = statement.executeQuery("SELECT * FROM musictype")) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String type = set.getString("type");
                    types.add(new MusicType(id, type));
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        }
        return types;
    }

    /**
     * Remove music type.
     * @param type instance of music type.
     */
    public void remove(MusicType type) {
        try (Connection connection = this.dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM musictype WHERE id = ?")) {
            statement.setInt(1, type.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
