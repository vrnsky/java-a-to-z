package start;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author evrnsky
 * @version 0.1
 * @since 10.01.2017
 *
 * Provide access to the settings class.
 */
public class Settings {

    /**
     * Instance of logger.
     */
    private static final Logger LOG = Logger.getLogger(Settings.class);

    /**
     * Properties.
     */
    private final Properties properties = new Properties();

    /**
     * Load properties from file.
     * @param load input stream for loading.
     */
    public void load(InputStream load) {
        try {
           this.properties.load(load);
        } catch (IOException ioe) {
            LOG.log(Level.WARN, ioe.getMessage(), ioe);
        }
    }

    /**
     * Return property from properties.
     * @param key for property.
     * @return value from property.
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
