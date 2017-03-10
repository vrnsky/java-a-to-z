package dao;

import service.Settings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.03.2017
 */
public class GeoRepository {

    private final static GeoRepository REPO = new GeoRepository();
    private DBManager dbManager;

    private GeoRepository() {
        this.dbManager = DBManager.getInstance();
    }

    public static GeoRepository getInstance() {
        return REPO;
    }

    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s", "countries");
        try {
            Statement statement = this.dbManager.getConnection().createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                countries.add(set.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

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
