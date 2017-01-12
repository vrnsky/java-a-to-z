package start;

import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 10.01.2017
 * Unit test for Settings.java. It testing all opportunities from this class.
 * Settings provide access to the property file which contains important data.
 */
public class SettingsTest {

    /**
     * Name which specify properties file.
     */
    private static final String PROPERTIES_FILE = "db.properties";

    /**
     * Key for get value from property.
     */
    private static final String DB_URL = "DB_URL";

    /**
     * Right value of property which key is equals DB_URL. See above.
     */
    private static final String RIGHT_DB_URL = "jdbc:postgresql://localhost:5432/";

    /**
     * Key for get value from property.
     */
    private static final String DB_USER = "DB_USER";

    /**
     * Right value of property which key is equals DB_USER. See above.
     */
    private static final String DB_USER_VALUE = "postgres";

    /**
     * Key for get value from property.
     */
    private static final String DB_PASSWORD = "DB_PASSWORD";

    /**
     * Right value of password to the db server.
     */
    private static final String DB_PASSWORD_VALUE = "55555";

    /**
     * Key for get value from property.
     */
    private static final String DB_TRACKER = "DB_TRACKER_URL";

    /**
     * Right url for get access to the tracker database.
     */
    private static final String TRACKER_URL="jdbc:postgresql://localhost:5432/tracker";

    /**
     * Instance of properties accessor.
     */
    private Settings settings;

    /**
     * This method call before each method which has @Test annotation
     */
    @Before
    public void loadProperties() {
        ClassLoader loader = Settings.class.getClassLoader();
        InputStream propsInput = loader.getResourceAsStream(PROPERTIES_FILE);
        this.settings = new Settings();
        this.settings.load(propsInput);
    }

    /**
     * Check that when loading database url it is right url.
     */
    @Test
    public void whenLoadDbURLShouldCheckThatIsCorrect() {
        assertThat(this.settings.getProperty(DB_URL), is(RIGHT_DB_URL));
    }

    /**
     * Check that when loading database user it is right username.
     */
    @Test
    public void whenLoadDbUserShouldCheckCorrect() {
        assertThat(this.settings.getProperty(DB_USER), is(DB_USER_VALUE));
    }

    /**
     * Check that when loading db pass it is a correct password.
     */
    @Test
    public void whenLoadDbPassShouldCheckCorrect() {
        assertThat(this.settings.getProperty(DB_PASSWORD), is(DB_PASSWORD_VALUE));
    }


    /**
     * Check that when load database tracker url it is right url.
     */
    @Test
    public void whenLoadDbTrackerUrlShouldCheckCorrect() {
        assertThat(this.settings.getProperty(DB_TRACKER), is(TRACKER_URL));
    }
}
