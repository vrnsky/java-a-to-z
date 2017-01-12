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
 */
public class Settings {

    private static final Logger LOG = Logger.getLogger(Settings.class);

    private final Properties properties = new Properties();

    public void load(InputStream load) {
        try {
           this.properties.load(load);
        } catch (IOException ioe) {
            LOG.log(Level.WARN, ioe.getMessage(), ioe);
        }
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
