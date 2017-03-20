package service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.03.2017
 */
public class Closer {

    private final static Logger LOG = Logger.getLogger(Closer.class);
    private Closer() {
    }

    public static void closeDbStructure(ResultSet set, PreparedStatement statement) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }
    }

    public static void closeDbStructure(ResultSet set, Statement statement) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOG.log(Level.WARN, e.getMessage(), e);
            }
        }
    }
}
