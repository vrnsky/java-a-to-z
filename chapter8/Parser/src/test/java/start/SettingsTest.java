package start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.01.2017
 *
 * Unit test for Settings.java.
 */
class SettingsTest {

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
    @BeforeEach
    public void setUp() {
        this.settings = new Settings();
        this.settings.load(Settings.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
    }

    /**
     * When write to the properties file should check that all is ok.
     */
    @Test
    void whenWriteToThePropertiesFileShouldCheckThatItWrited()  {
        settings.write("ADDITIONAL", "1");
        assertThat(this.settings.getValue("ADDITIONAL"), is("1"));
    }

    /**
     * When try to get value from properties should check that value right.
     */
    @Test
    void whenTryGetValueFromPropertiesShouldCheckThatValueIsRight()  {
        assertThat(this.settings.getValue("DB_PASSWORD"), is("55555"));
    }

}