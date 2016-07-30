package start;

import model.Menu;
import model.MenuItem;

/**
 * Demo of menu work.
 */
public class MenuDemo {

    /**
     * Show that the menu tree works correct.
     * @param args nothing.
     */
    public static void main(String[] args) {
        new MenuDemo().init(new ConsoleIO());
    }

    /**
     * Start app, show simple menu with sub menu.
     * @param io instance of io interface.
     */
    public void init(IO io) {
        MenuItem start = new MenuItem("Choose server");
        MenuItem tomcat = new MenuItem("Tomcat");
        MenuItem startTomcat = new MenuItem("Start");
        tomcat.addSubItem(startTomcat);
        start.addSubItem(tomcat);

        MenuItem settings = new MenuItem("Settings");
        MenuItem storage = new MenuItem("Storage");
        MenuItem oneSize = new MenuItem("1024 TB");
        MenuItem twoSize = new MenuItem("2048 TB");
        storage.addSubItem(oneSize);
        storage.addSubItem(twoSize);
        settings.addSubItem(storage);

        Menu menu = new Menu(io);
        menu.addMenuItem(start);
        menu.addMenuItem(settings);
        menu.show();
    }
}
