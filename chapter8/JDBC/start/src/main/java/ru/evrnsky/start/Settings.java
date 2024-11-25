package ru.evrnsky.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author evrnsky
 * @version 0.1
 * @since 10.01.2017
 * <p>
 * Provide access to the settings class.
 */
public class Settings {

    /**
     * Instance of logger.
     */
    private static final Logger log = LoggerFactory.getLogger(Settings.class.getSimpleName());

    /**
     * Properties.
     */
    private final Properties properties = new Properties();

    /**
     * Load properties from file.
     *
     * @param load input stream for loading.
     */
    public void load(InputStream load) {
        if (load == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }
        try {
            this.properties.load(load);
        } catch (IOException ioe) {
            log.error("Failed to load configuration", ioe);
            throw new IllegalStateException("Unable to load configuration", ioe);
        }
    }

    /**
     * Return property from properties.
     *
     * @param key for property.
     * @return value from property.
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
