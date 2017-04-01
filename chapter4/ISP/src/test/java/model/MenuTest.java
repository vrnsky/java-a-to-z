package model;

import org.junit.Test;
import start.StubIO;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit for Menu.java.
 */
public class MenuTest {

    /**
     * When try show menu with only root components should check that is works correct.
     */
    @Test
    public void whenTryShowMenuWithoutSubOptionsShouldCheckThatIsWorksCorrect() {
        String[] answer = new String[]{""};
        StubIO stubIO = new StubIO(answer);
        Menu menu = new Menu(stubIO);
        MenuItem start = new MenuItem("Start");
        menu.addMenuItem(start);
        MenuItem settings = new MenuItem("Settings");
        menu.addMenuItem(settings);
        MenuItem exit = new MenuItem("Exit");
        menu.addMenuItem(exit);
        String expected = "1.Start \n"
                +
                "2.Settings \n"
                +
                "3.Exit \n";

        menu.show();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try show menu item with sub items should check that is correct.
     */
    @Test
    public void whenTryToShowMenuWithSubItemsShouldCheckThatIsCorrect() {
        String[] answer = new String[]{"", "", ""};
        StubIO stubIO = new StubIO(answer);
        Menu menu = new Menu(stubIO);
        MenuItem root = new MenuItem("Root");
        MenuItem subItem = new MenuItem("Sub 1-lvl");
        MenuItem subSubItem = new MenuItem("Sub 1-1-lvl");
        subItem.addSubItem(subSubItem);
        root.addSubItem(subItem);
        menu.addMenuItem(root);
        String expected = "1.Root \n"
                +
                "1.1.Sub 1-lvl \n"
                +
                "1.1.1.Sub 1-1-lvl \n";

        menu.show();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try show one menu item should check that works correct.
     */
    @Test
    public void whenTryShowOneMenuItemShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"", "", ""};
        StubIO stubIO = new StubIO(answer);
        Menu menu = new Menu(stubIO);
        MenuItem root = new MenuItem("Root");
        menu.addMenuItem(root);
        String expected = "1.Root \n";

        menu.show("1");

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try choose menu option should check that works correct.
     * Adding and showing items from tracker.
     */
    @Test
    public void whenTryToChooseMenuOptionShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"1", "Egor", "Voronyansky", "3"};
        StubIO stubIO = new StubIO(answer);
        Menu menu = new Menu(stubIO);
        MenuItem addItem = new MenuItem("Add new item");
        MenuItem removeItem = new MenuItem("Remove item");
        MenuItem showAllItems = new MenuItem("Show all items");
        menu.addMenuItem(addItem);
        menu.addMenuItem(removeItem);
        menu.addMenuItem(showAllItems);
        String expected = "\tName:Egor\n"
                +
                "Desc:Voronyansky";

        menu.choose();
        menu.choose();

        assertThat(stubIO.getOut(), containsString(expected));
    }
}
