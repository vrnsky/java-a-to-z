package model;

import start.IO;
import start.MenuTracker;

/**
 * Model of menu item. It should have a name and may execute
 */
public class MenuItem implements Showable, Choose {

    /**
     * Name of menu item.
     */
    private String name;

    /**
     * All sub items hold at this array.
     */
    private MenuItem[] subItems;


    /**
     * Add sub item to this menu item.
     * @param item instance of menu item class which will add as sub item.
     */
    public void addSubItem(MenuItem item) {
        for (int index = 0; index < this.subItems.length; index++) {
            if (this.subItems[index] == null) {
                this.subItems[index] = item;
                break;
            }
        }
    }

    /**
     * Create a menu item with given name.
     * @param name of menu item.
     */
    public MenuItem(String name) {
        this.name = name;
        this.subItems = new MenuItem[10];
    }


    /**
     * Show all menu item.
     * @param io instance of IO interface for handle input/output.
     */
    @Override
    public void show(String value, IO io) {
       io.println(String.format(value +  ".%s ", this.getName()));
       for (int index = 0; index < this.subItems.length; index++) {
           if (this.subItems[index] != null) {
               this.subItems[index].show(String.format("%s.%s", value, index + 1), io);
           }
       }
    }


    /**
     * Return name of menu item.
     * @return name of menu item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Allow user to choose menu options.
     * @param key         unique key of actions.
     * @param menuTracker instance of menu tracker.
     */
    @Override
    public void choose(int key, MenuTracker menuTracker) {
        menuTracker.select(key);
    }
}
