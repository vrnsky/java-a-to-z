package dao;

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
 *
 * This geo repo. Return city and countries.
 */
public class GeoRepository {

    /**
     * It is singleton.
     */
    private static final GeoRepository REPO = new GeoRepository();

    /**
     * Instance of database wrapper.
     */
    private DBManager dbManager;

    /**
     * Default constructor.
     */
    private GeoRepository() {
        this.dbManager = DBManager.getInstance();
    }

    /**
     * Return self.
     * @return instance of this.
     */
    public static GeoRepository getInstance() {
        return REPO;
    }

    /**
     * Return list of countries.
     * @return list of countries.
     */
    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        Statement statement = null;
        ResultSet set = null;
        String sql = String.format("SELECT * FROM %s", "countries");
        try {
            statement = this.dbManager.getConnection().createStatement();
            set = statement.executeQuery(sql);
            while (set.next()) {
                countries.add(set.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return countries;
    }

    /**
     * Return list of city.
     * @param country for this country will search cities at the db.
     * @return list of cities at the country.
     */
    public List<String> getCities(String country) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<String> cities = new ArrayList<>();
        try {
            statement = this.dbManager.
                            getConnection().prepareStatement("select city_name from city as city right outer join countries as c on city.country_id = c.id where c.country = ?");
            statement.setString(1, country);
            set = statement.executeQuery();
            while (set.next()) {
                cities.add(set.getString("city_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return cities;
    }
}
