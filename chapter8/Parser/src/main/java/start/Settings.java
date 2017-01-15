package start;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Properties;


/**
 * @author evrnsky
 * @version 0.1
 * @since 12.01.2017
 *
 * Provider for properties files.
 */
public class Settings {

    /**
     * Properties file.
     */
    private final Properties properties = new Properties();

    /**
     * Specify file path to the file which contains all properties.
     */
    private static final String PATH = "../chapter8/Parser/src/main/resources/app.properties";

    /**
     * Loading data from the properties file.
     * @param stream input stream to the properties file.
     */
    public void load(InputStream stream) {
        try {
            this.properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write to the properties file.
     * @param key of property.
     * @param value of property.
     */
    public void write(String key, String value) {
        this.properties.setProperty(key, value);
        FileWriter fileOutput = null;
        try {
            fileOutput = new FileWriter(new File(PATH));
            this.properties.store(fileOutput, null);
            fileOutput.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            if (fileOutput != null) {
                try {
                    fileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Return value for specify key.
     * @param key of property.
     * @return string view of property.
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

}
