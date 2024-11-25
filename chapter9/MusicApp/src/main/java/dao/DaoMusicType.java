package dao;

import model.MusicType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.03.2017
 * <p>
 * This is dao for music type.
 */
public class DaoMusicType extends CommonDAO<MusicType> {

    /**
     * Instance of logger.
     */
    private static final Logger log = LoggerFactory.getLogger(DaoMusicType.class.getName());

    /**
     * Self instance, it is singleton.
     */
    private static final DaoMusicType DAO = new DaoMusicType();

    /**
     * Default constructor.
     */
    private DaoMusicType() {
        super();
    }

    /**
     * Return instance of this.
     *
     * @return instance of this.
     */
    public static DaoMusicType getInstance() {
        return DAO;
    }

    /**
     * SQL query which select all from table.
     *
     * @return SQL query for collect all order from concrete table.
     */
    @Override
    public String getSelectAll() {
        return "select * from musictype";
    }

    /**
     * SQL query which select all data from one row.
     *
     * @return SQL query for collect data from one row.
     */
    @Override
    public String getSelectById() {
        return "select * from musictype where id = ?";
    }

    /**
     * SQL query which edit object at the system.
     *
     * @return SQL query which edit object in the concrete table.
     */
    @Override
    public String getEdit() {
        return "update musictype type = ? where id = ?";
    }

    /**
     * SQL query which remove order about object from concrete table.
     *
     * @return SQL query which remove order about object at the concrete table.
     */
    @Override
    public String getRemove() {
        return "delete from musictype where id = ?";
    }

    /**
     * SQL query which insert data to the database.
     *
     * @return SQL INSERT for concrete table.
     */
    @Override
    public String getInsert() {
        return "insert into musictype (type) values(?)";
    }

    /**
     * Set data to the statement.
     *
     * @param statement instance of PreparedStatement.
     * @param object    instance of class.
     */
    @Override
    public void prepareStatementForInsert(PreparedStatement statement, MusicType object) {
        try {
            statement.setString(1, object.getType());
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
    }

    /**
     * Set data to the statement.
     *
     * @param statement instance of PreparedStatement.
     * @param object    instance of class.
     */
    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, MusicType object) {
        try {
            statement.setString(1, object.getType());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }
    }

    /**
     * Set data to the statement.
     *
     * @param set instance of result set interface.
     * @return list of music types.
     */
    @Override
    public List<MusicType> parseResultSet(ResultSet set) {
        List<MusicType> list = new ArrayList<>();
        try (ResultSet parseSet = set) {
            while (parseSet.next()) {
                int id = parseSet.getInt("id");
                String type = parseSet.getString("type");
                list.add(new MusicType(id, type));
            }
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
        }

        return list;
    }
}
