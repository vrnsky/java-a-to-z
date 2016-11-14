package start;


import models.Item;
import models.Comment;

/**
 * This class uses for interacting with user and execute command from his.
 */
public class MenuTracker {

    /**
     * Count of action in tracker.
     */
    private static final int NUMBER_OF_ACTIONS = 8;

    /**
     * Instance of API Tracker.
     */
    private Tracker tracker;
    /**
     * Instance of IO system for handle input and show data to user.
     */
    private IO io;

    /**
     * Actions which do user.
     */
    private UserAction[] actions = new UserAction[NUMBER_OF_ACTIONS];

    /**
     * For correct add new action in actions array should use pointer.
     */
    private int position = 0;

    /**
     * Constructor for this class.
     *
     * @param inOut      implement of input/output interface.
     * @param trackerApp instance of tracker API.
     */
    public MenuTracker(final IO inOut, final Tracker trackerApp) {
        this.tracker = trackerApp;
        this.io = inOut;
    }

    /**
     * Fill actions array by creating new instance of actions
     * and fill array ranges for correct using menu.
     */
    public final void fillActions() {
        actions[position++] = new AddItem("Add a new item");
        actions[position++] = new RemoveItem("Remove item");
        actions[position++] = new ShowAllItems("Show all items");
        actions[position++] = new EditItem("Edit item");
        actions[position++] = new CommentItem("Comment item");
        actions[position++] = new ShowComments("Show comments");
        actions[position++] = new FilteringByTextData("Search by text data");
        actions[position++] = new FilteringByTime("Search by time");
    }

    /**
     * In near future will be add feature for adding
     * your actions to actions array. Now this N/A for correct working.
     * Don't use this!
     * @param action it is kid of BaseAction class
     */
    public final void addAction(final BaseAction action) {
        actions[position++] = action;
    }

    /**
     * This method select action and call from action method execute.
     * @param key id of action.
     */
    public final void select(final int key) {
        this.actions[key].execute(io, tracker);
    }

    /**
     * Return id of first not null action.
     * @return position of first command in actions array.
     */
    public final int getIdFirstCommand() {
        int result = -1;
        for (int index = 0; index != actions.length; index++) {
            if (actions[index] != null) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * Return id of last not null action.
     * @return - it is last not null action in array actions.
     */
    public final int getIdLastCommand() {
        int result = -1;
        for (int index = actions.length - 1; index >= 0; index--) {
            if (actions[index] != null) {
                result = index;
                break;
            }
        }
        return result;
    }


    /**
     * This method using for show user all possible action.
     */
    public final void show() {
        for (UserAction act : actions) {
            if (act != null) {
                io.println(act.info());
            }
        }
    }

    /**
     * Implementation of adding item.
     */
    private class AddItem extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 0;

        /**
         * Init new action by calling constructor from parent.
         * @param name it is name of action.
         */
        AddItem(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Execute command from user by interacting with him
         * And ask about item which will added to tracker.
         * @param inOut      implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        public void execute(final IO inOut, final Tracker trackerApp) {
            String name = io.ask("Enter a name of the new item: ");
            String description = io.ask(
               String.format("%s", "Enter a description of the new item: "));
            tracker.addItem(new Item(name, description));
        }

    }

    /**
     * Implement of remove option.
     */
    private class RemoveItem extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 1;

        /**
         * Init a new action - remove item.
         * @param name name of action.
         */
        RemoveItem(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Execute a remove item command. Ask user about number of item.
         * Try find it item and if found remove from tracker
         * Otherwise show user message about tracker was empty
         * or user choose wrong number.
         * @param inOut      implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO inOut, final Tracker trackerApp) {
            int start = tracker.getStart();
            int finish = tracker.getFinish();
            Item[] items = tracker.getAllItems();
            if (items.length == 0) {
                io.println("Nothing to delete!");
                return;
            }
            final int positionItem = io.ask("Type a number of item in list: ",
                                  start, finish);
            Item removeItem = items[positionItem - 1];
            tracker.removeItem(removeItem.getId());
        }

    }

    /**
     * Implementation of show all items action.
     */
    private class ShowAllItems extends BaseAction {
        /**
         * key of action.
         */
        private final int key = 2;


        /**
         * Init a new action - it is show all items action.
         * @param name string for naming this action.
         */
        ShowAllItems(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */

        public int key() {
            return key;
        }

        /**
         * Show all items call from io system method println.
         * @param inOut      implement of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO inOut, final Tracker trackerApp) {
            for (Item item : tracker.getAllItems()) {
                if (item != null) {
                    io.println(item);
                }
            }
        }
    }

    /**
     * Implementation of edit item option.
     */
    private class EditItem extends BaseAction {

        /**
         * key of action.
         */
        private final int key = 3;

        /**
         * Init a new action by calling constructor from the parent.
         * @param name of action.
         */
        EditItem(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */

        public int key() {
            return key;
        }

        /**
         * Ask user about number of item in list and try find item.
         * If item was found try edit item, otherwise return
         * and show user about problem.
         * Further find item and edit by set new name and description.
         * @param input      implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO input, final Tracker trackerApp) {
            Item[] items = tracker.getAllItems();
            if (items.length == 0) {
                io.println("Nothing to edit!");
                return;
            }
            int start = tracker.getStart();
            int finish = tracker.getFinish();
            int positionItem = io.ask("Enter a number of item in list: ",
                                  start, finish);
            Item item = items[positionItem - 1];
            item.setName(io.ask("Type new name for item :"));
            item.setDescription(io.ask("Type new description: "));
            tracker.editItem(item);
        }
    }

    /**
     * Implementation of commenting option.
     */
    private class CommentItem extends BaseAction {

        /**
         * key of action.
         */
        private final int key = 4;

        /**
         * Init a new action comment item.
         * @param name name of action.
         */
        CommentItem(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Ask user about item and try find it, if not found return.
         * Further attach comments about item to the item.
         * @param input    implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO input, final Tracker trackerApp) {
            Item[] items = tracker.getAllItems();
            if (items.length == 0) {
                io.println("Nothing to comment!");
                return;
            }
            final int start = tracker.getStart();
            final int finish = tracker.getFinish();
            final int positionItem = io.ask("Enter a number of item in list",
                                        start, finish);
            Item item = items[positionItem - 1];
            tracker.addComment(item, new Comment(
                               io.ask("Enter your comment for item: ")));
        }
    }

    /**
     * Implementation of show comments options.
     */
    private class ShowComments extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 5;

        /**
         * Init a new action - show comments.
         * @param name of action.
         */
        ShowComments(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Ask user about item and try find it if not found return.
         * Further show comment for this item
         * @param inOut      implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO inOut, final Tracker trackerApp) {
            Item[] items = tracker.getAllItems();
            if (items.length == 0) {
                io.println("Nothing to show, item list is empty!");
                return;
            }
            int start = tracker.getStart();
            int finish = tracker.getFinish();
            int positionItem = io.ask("Choose item to show comments: ",
                                  start, finish);
            Item item = tracker.getAllItems()[positionItem - 1];
            for (Comment comment : item.getComments()) {
                io.println(comment);
            }
        }
    }

    /**
     * Implement of filtering by text data option.
     */
    private class FilteringByTextData extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 6;

        /**
         * filtering by text data by calling constructor from the parent.
         * @param name for action.
         */
        FilteringByTextData(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Ask about text which he want find and items.
         * and try to find items.
         * @param inOut      implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO inOut, final Tracker trackerApp) {
            String search = io.ask("Enter a text for search: ");
            Item[] result = tracker.getItemsFilteredByText(search);
            if (result.length == 0) {
                io.println("Items with given text not found!");
                return;
            }
            for (Item item : result) {
                if (item != null) {
                    io.println(item);
                }
            }
        }
    }

    /**
     * Implementation of filtering by time option.
     */
    private class FilteringByTime extends BaseAction {


        /**
         * Key of action.
         */
        private final int key = 7;


        /**
         * Init a new action - filtering by time.
         * @param name name of action.
         */
        FilteringByTime(final String name) {
            super(name);
        }

        /**
         * Use for determine position in actions array.
         * @return position in the actions array.
         */
        public int key() {
            return key;
        }

        /**
         * Ask user about time of item which he want find and try to find it.
         * @param ioInstance implementation of input/output interface.
         * @param trackerApp instance of Tracker API.
         */
        @Override
        public void execute(final IO ioInstance, final Tracker trackerApp) {
            long time = io.askForLong("Enter a time for search");
            Item[] result = tracker.getItemsFilteredByTime(time);
            if (result.length == 0) {
                io.println("Items with given time not found!");
                return;
            }
            for (Item item : result) {
                io.println(item);
            }
        }

    }

}
