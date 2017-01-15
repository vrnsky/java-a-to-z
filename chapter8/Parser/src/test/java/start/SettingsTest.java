package start;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.01.2017
 *
 * Unit test for Settings.java.
 */
public class SettingsTest {

    /**
     * Name of property file.
     */
    private static final String PROPERTIES_FILE = "app.properties";

    /**
     * Provider for property.
     */
    private Settings settings;

    /**
     * Init variables.
     */
    @Before
    public void setUp() {
        this.settings = new Settings();
        this.settings.load(Settings.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
    }

    /**
     * When write to the properties file should check that all is ok.
     */
    @Test
    public void whenWriteToThePropertiesFileShouldCheckThatItWrited()  {
        settings.write("ADDITIONAL", "1");
        assertThat(this.settings.getValue("ADDITIONAL"), is("1"));
    }

    /**
     * When try get value from properties should check that value right.
     */
    @Test
    public void whenTryGetValueFromPropertiesShouldCheckThatValueIsRight()  {
        assertThat(this.settings.getValue("DB_PASSWORD"), is("55555"));
    }

}