package repo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.02.2017
 */
public class Settings {

    /**
     * Instance of properties.
     */
    private Properties properties = new Properties();

    /**
     * Load data from file.
     * @param in input stream for load.
     */
    public void load(InputStream in) {
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting data from properties file.
     * @param key name of property.
     * @return value of property if it in file, otherwise null.
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
