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
        Menu menu = new Menu(new ConsoleIO());
        MenuItem start = new MenuItem("Launch server");
        menu.addMenuItem(start);
        MenuItem windowServer = new MenuItem("Windows Server", start.getKey());
        menu.addMenuItem(windowServer);
        MenuItem thirdParty = new MenuItem("Third party", windowServer.getKey());
        menu.addMenuItem(thirdParty);
        MenuItem settings = new MenuItem("Settings");
        menu.addMenuItem(settings);
        MenuItem heap = new MenuItem("Heap", settings.getKey());
        menu.addMenuItem(heap);
        MenuItem heapSize = new MenuItem("1024 MB", heap.getKey());
        menu.addMenuItem(heapSize);
        menu.show();
    }
}
