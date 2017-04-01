package model;

import start.IO;
import start.MenuTracker;
import start.Tracker;

/**
 * Model of menu, this must show menu and handle choose operation.
 */
public class Menu {

    /**
     * All menu items holds in this array.
     */
    private MenuItem[] items;

    /**
     * Intance of menu tracker. Provider for Tracker API.
     */
    private MenuTracker menuTracker;

    /**
     * Instance of IO interface. Allow accept data and show data to user.
     */
    private IO io;


    /**
     * Create a new menu.
     * @param io intance of io interface.
     * @param capacity of menu.
     */
    public Menu(IO io, int capacity) {
        this.items = new MenuItem[capacity];
        this.io = io;
        this.menuTracker = new MenuTracker(this.io, new Tracker());
        this.menuTracker.fillActions();
    }

    /**
     * Add menu item to menu items array.
     * @param menuItem instance of menu item class.
     */
    public void addMenuItem(MenuItem menuItem) {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] == null) {
                this.items[index] = menuItem;
                break;
            }
        }
    }

    /**
     * Create a new menu.
     * @param io instance of io interface.
     */
    public Menu(IO io) {
        this(io, 10);

    }

    /**
     * Show menu item with give string value.
     * @param value must be number of menu item in string view.
     */
    public void show(String value) {
       int number = Integer.valueOf(value);
       if (this.items[number - 1] != null) {
           this.items[number - 1].show(value, this.io);
       }
    }

    /**
     * Print all menu.
     */
    public void show() {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] != null) {
                this.show(String.valueOf(index + 1));
            }
        }
    }

    /**
     * Choose operation from tracker menu.
     * At this method decrease number from use because in MenuTracker all action in array.
     * By above reason increase high boundary of range io.ask.
     */
    public void choose() {
        int choose = io.ask("Enter a number of action: ", this.menuTracker.getIdFirstCommand(), this.menuTracker.getIdLastCommand() + 1);
        if (choose > 0) {
            choose--;
        }
        this.items[choose].choose(choose, this.menuTracker);
    }


}
