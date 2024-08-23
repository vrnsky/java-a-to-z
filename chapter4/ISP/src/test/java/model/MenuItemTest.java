package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.evrnsky.start.MenuTracker;
import ru.evrnsky.start.StubIO;
import ru.evrnsky.start.Tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Unit test for MenuItem.java.
 */
class MenuItemTest {

    /**
     * When create a menu item should check that constructor works correct.
     */
    @Test
    void whenCreateMenuItemShouldCheckThatIsNotNull() {
        MenuItem menuItem = new MenuItem("Menu");
        Assertions.assertNotNull(menuItem);
    }

    /**
     * Check that menu item saved its name.
     */
    @Test
    void whenCreateMenuItemShouldCheckThatSaveName() {
        MenuItem menuItem = new MenuItem("Menu");
        String expected = "Menu";

        String actual = menuItem.getName();

        assertThat(actual, is(expected));
    }

    /**
     * When try to show menu without sub items should check it correct.
     */
    @Test
    void whenTryToShowMenuItemWithoutSubItemsShouldCheckThatIsCorrect() {
        String[] answer = new String[]{"", "", ""};
        StubIO stubIO = new StubIO(answer);
        MenuItem menuItem = new MenuItem("Start");
        String expected = "1.Start \n";

        menuItem.show("1", stubIO);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try to show menu with sub items should check that is correct.
     */
    @Test
    void whenTryToShowMenuWithSubItemsShouldCheckThatIsCorrect() {
        String[] answer = new String[]{"", "", ""};
        StubIO stubIO = new StubIO(answer);
        MenuItem start = new MenuItem("Start");
        MenuItem server = new MenuItem("Server");
        MenuItem app = new MenuItem("App");
        server.addSubItem(app);
        start.addSubItem(server);
        String expected = "1.Start \n"
                +
                "1.1.Server \n"
                +
                "1.1.1.App \n";

        start.show("1", stubIO);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * Check coherence between menu and menu tracker. It works.
     */
    @Test
    void whenTryToChooseOptionFromMenuTrackerShouldCheckThatExecutionWasCorrect() {
        String[] answer = new String[]{"Special", "Item", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuItem addNewItem = new MenuItem("Add new item");
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        menuTracker.fillActions();
        String expected = "\tName:Special\n"
                +
                "Desc:Item";

        addNewItem.choose(0, menuTracker);
        menuTracker.select(2);

        assertThat(stubIO.getOut(), containsString(expected));
    }
}
