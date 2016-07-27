package model;

import start.IO;
import start.MenuTracker;
import start.Tracker;

/**
 * Model of menu, this must show menu and handle choose operation
 */
public class Menu {

    /**
     * All menu items holds in this array.
     */
    private MenuItem[] items;

    /**
     * Menu numbers must starts with 1
     */
    private int position = 1;

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
    }

    /**
     * Create a new menu.
     * @param io instance of io interface.
     */
    public Menu(IO io) {
        this(io, 7);

    }

    /**
     * Add new menu item. May root or sub menu item.
     * @param menuItem instance of menu item.
     */
    public void addMenuItem(MenuItem menuItem) {
       for(int index = 0; index < this.items.length; index++) {
           if(this.items[index] == null) {
               menuItem.setKey(position++);
               this.items[index] = menuItem;
               break;
           }
       }
    }

    /**
     * Show all menu items include all sub items.
     */
    public void show() {
        for(MenuItem item : this.items) {
            if(item != null && item.getParentKey() == 0) {
                item.show("",this.io);
                this.printSubMenu(item.getKey(), 0);
            }
        }
    }

    /**
     * Print all sub menu items for menu with given key.
     * @param key unique value for each menu item.
     * @param level of sub.
     */
    private void printSubMenu(int key, int level) {
        level++;
        for(int index = 0; index < this.items.length; index++) {
            if(this.items[index] != null) {
                if (this.items[index].getParentKey() == key) {
                    this.items[index].show(addTab(level), this.io);
                    this.printSubMenu(this.items[index].getKey(), level);
                }
            }
        }
    }

    /**
     * Return tabs sequence.
     * @param level of sub.
     * @return string with level count of \t.
     */
    private String addTab(int level) {
        StringBuilder builder = new StringBuilder(level);
        for (int index = 0; index < level; index++) {
            builder.append("\t");
        }
        return builder.toString();
    }
    /**
     * All menu items may be choose.
     */
    public void choose() {
        int key = this.io.ask("Enter a menu option: ", 0, this.position - 1);
        for (MenuItem item : this.items) {
            if(item.getKey() == key) {
                menuTracker.select(key);
            }
        }
    }
}
































//    public void show() {
//        for (int x = 0; x < menuElements.length; x++) {
//            if (menuElements[x] != null && menuElements[x].getParentKey() == 0) {
//                menuElements[x].show(this.io,"");
//                print(menuElements[x].getKey(),0);
//            }
//        }
//    }

//
//    public void print(long parentId, int level) {
//        level++;
//        for (int x = 0; x < menuElements.length; x++) {
//            if (menuElements[x] != null && menuElements[x].getParentKey() == parentId) {
//                menuElements[x].show(this.io, addSpaces(level*4));
//                print(menuElements[x].getKey(), level);
//            }
//        }
//    }
//
//    public String addSpaces(int length) {
//        StringBuffer outputBuffer = new StringBuffer(length);
//        for(int i=0; i<length; i++){
//            outputBuffer.append(" ");
//        }
//        return outputBuffer.toString();
//    }
