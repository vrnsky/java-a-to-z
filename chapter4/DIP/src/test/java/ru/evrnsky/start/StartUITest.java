package ru.evrnsky.start;

import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StartUI;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for StartUI.java.
 */
class StartUITest {

    /**
     * Check that app correct works. First add new user, second edit exist user and remove.
     */
    @Test
    void whenTryStartAppShouldCheckThatMethodInitWorksCorrect() {

        //Assign block
        String[] answer = new String[]{"Yegor", "19", "Yegor", "19", "0", "Egor", "0", "20", "Egor", "20", "0"};
        StubIO stubIO = new StubIO(answer);
        StartUI app = new StartUI(stubIO);
        String expected = "User was added\n"
                +
                "ID\tName\tAge\n"
                +
                "0\tYegor\t19\n"
                +
                "User was edited.\n"
                +
                "ID\tName\tAge\n"
                +
                "0\tEgor\t20\n"
                +
                "User was removed.\n"
                +
                "ID\tName\tAge\n";

        app.init();

        assertThat(stubIO.getOut(), is(expected));
    }
}
