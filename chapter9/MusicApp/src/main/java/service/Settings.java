package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.02.2017
 * This provide mechanism for reading properties file.
 */
public class Settings {

    /**
     * Properties.
     */
    private Properties props = new Properties();

    /**
     * Load properties from file.
     * @param in input stream for reading.
     */
    public void load(InputStream in) {
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read property and return it.
     * @param key of property.
     * @return value of property.
     */
    public String getProperty(String key) {
        return this.props.getProperty(key);
    }
}