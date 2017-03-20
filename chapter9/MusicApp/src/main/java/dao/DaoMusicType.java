package dao;

import model.MusicType;
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
 * This is dao for music type.
 */
public class DaoMusicType {

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
     * Set for handle response from database.
     */
    private ResultSet set;

    /**
     * Statement for request to the database.
     */
    private PreparedStatement statement;

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
    public void addMusicType(MusicType type) {
        try {
            this.statement = this.dbManager.
                    getConnection().prepareStatement("INSERT INTO musictype (type) values(?)", Statement.RETURN_GENERATED_KEYS);
            this.statement.setString(1, type.getType());
            this.statement.executeUpdate();
            this.set = this.statement.getGeneratedKeys();
            while (this.set.next()) {
                type.setId(this.set.getInt("id"));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
    }

    /**
     * Edit already exist at the database music type.
     * @param type instance of music type.
     */
    public void editMusicType(MusicType type) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("UPDATE musictype SET type = ? WHERE id = ?");
            this.statement.setString(1,type.getType());
            this.statement.setInt(2, type.getId());
            this.statement.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }

    }

    /**
     * Return music type with given id, if it exist at the db, otherwise return null.
     * @param id unique number per music type.
     * @return music type instance with given id, if it exist, otherwise false.
     */
    public MusicType getMusicTypeById(int id) {
        MusicType resultType = null;
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("SELECT * FROM musictype WHERE id = ?");
            this.statement.setInt(1, id);
            this.set = this.statement.executeQuery();
            while (this.set.next()) {
                int typeId = this.set.getInt("id");
                String type = this.set.getString("type");
                resultType = new MusicType(typeId, type);
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
        return resultType;
    }

    /**
     * Return list of music type which already in db.
     * @return list of music type.
     */
    public List<MusicType> getAllMusicTypes() {
        List<MusicType> types = new ArrayList<>();
        Statement statement = null;
        try {
            statement = this.dbManager.getConnection().createStatement();
            this.set = statement.executeQuery("SELECT * FROM musictype");
            while (this.set.next()) {
                int id = this.set.getInt("id");
                String type = this.set.getString("type");
                types.add(new MusicType(id, type));
            }
        } catch (SQLException e) {
            LOG.log(Level.WARN, e.getMessage(), e);
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, statement);
        }
        return types;
    }

    /**
     * Remove music type.
     * @param type instance of music type.
     */
    public void removeMusicType(MusicType type) {
        try {
            this.statement = this.dbManager.getConnection().prepareStatement("DELETE FROM musictype WHERE id = ?");
            this.statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dbManager.closeConnection();
            Closer.closeDbStructure(this.set, this.statement);
        }
    }

}
