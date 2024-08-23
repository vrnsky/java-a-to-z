package start;

import model.Menu;
import model.MenuItem;
import ru.evrnsky.start.ConsoleIO;
import ru.evrnsky.start.IO;

/**
 *  Menu for tracker.
 */
public class TrackerMenu {

    /**
     * Instance of io interface.
     */
    private IO io;

    /**
     * Create a new tracker menu with given io system.
     * @param io instance of io interface.
     */
    public TrackerMenu(IO io) {
        this.io = io;
    }

    /**
     * Start app.
     * @param args keys.
     */
    public static void main(String[] args) {
        new TrackerMenu(new ConsoleIO()).init();
    }

    /**
     * Main program loop.
     */
    public void init() {
        Menu menu = new Menu(io);
        this.fillMenu(menu);
        do {
            menu.show();
            menu.choose();
        } while (!"y".equals(io.ask("Exit now ? (y/n)")));
    }

    /**
     * Before start using menu should fill it.
     * @param menu instance of menu class.
     */
    private void fillMenu(Menu menu) {
        MenuItem addNewItem = new MenuItem("Add new item");
        MenuItem removeItem = new MenuItem("Remove item");
        MenuItem showAllItems = new MenuItem("Show all items");
        MenuItem editItem = new MenuItem("Edit item");
        MenuItem commentItem = new MenuItem("Comment item");
        MenuItem showComments = new MenuItem("Show comments");
        MenuItem filteringByText = new MenuItem("Filtering by text");
        MenuItem filteringByTime = new MenuItem("Filtering by date");

        menu.addMenuItem(addNewItem);
        menu.addMenuItem(removeItem);
        menu.addMenuItem(showAllItems);
        menu.addMenuItem(editItem);
        menu.addMenuItem(commentItem);
        menu.addMenuItem(showComments);
        menu.addMenuItem(filteringByText);
        menu.addMenuItem(filteringByTime);
    }
}
