package ru.evrnsky.start;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Unit test for MenuTracker.java.
 * It test all operations from class and check correct perform of its.
 */
public class MenuTrackerTest {

    /**
     * Id for command which show all items.
     */
    private static final int SHOW_ALL_ITEMS = 2;

    /**
     * When application start it must show to user menu
     * Should check that menu is correct.
     */
    @Test
    void whenWeShowUserMenuShouldShowCorrectMenu() {
        String[] answer = new String[]{""};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        String expected = String.format("%s%s%s%s%s%s%s%s",
                "0. Add a new item\n",
                "1. Remove item\n",
                "2. Show all items\n",
                "3. Edit item\n",
                "4. Comment item\n",
                "5. Show comments\n",
                "6. Search by text data\n",
                "7. Search by time\n");

        menuTracker.fillActions();
        menuTracker.show();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When user try add new item to the tracker
     * Should check that item added.
     */
    @Test
    void whenTryAddItemToTrackerUseMenuTrackerShouldAddItem() {

        /** Assign block
         Which command will execute - see variable answer:
         0 - key for add operation
         It is my first item - name of item
         Item - description for item
         */
        String[] answer = new String[]{"0", "It is my first", "Item"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        String expected = "Name:It is my first\nDesc:Item\n";

        menuTracker.fillActions();
        String command = stubIO.ask("Type a command for Tracker: ");
        int comm = Integer.valueOf(command);
        menuTracker.select(comm);
        menuTracker.select(SHOW_ALL_ITEMS);

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try remove item from tracker
     * Should check that item was removed.
     */
    @Test
    void whenRemoveItemFromTrackerShouldRemoveItem() {

        /** Assign block
         Which command will execute - see variable answer
         0 - key for add operation
         It is my second item - name for item
         Item - description for item
         1 - key for remove operation
         1 - position of items which will remove
         */
        String[] answer = new String[]
                {"0", "It is my second item",
                "Item", "1", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        String expected = "";

        menuTracker.fillActions();
        int start = menuTracker.getIdFirstCommand();
        int finish = menuTracker.getIdLastCommand();
        int comm = stubIO.ask("Type a command for Tracker: ", start, finish);
        menuTracker.select(comm);
        comm = stubIO.ask("Type a command for Tracker: ", start, finish);
        menuTracker.select(comm);
        menuTracker.select(SHOW_ALL_ITEMS);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try edit item should check that app correctly edit item.
     */
    @Test
    void whenEditItemFromTrackerShouldEditTrackerItem() {

        /** Assign block
         Which command will execute - see variable answer:
         0 - key for add operation
         It is my third item - name for item
         Item - description for item
         3 - key for editing operation
         1 - position of editing items in list, which show user
         Update - new name for item
         Update - new description for item
         */
        String[] answer = new String[]
                {"0", "It is my third item", "Item",
                "3", "1", "Update", "Update item"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        String expected = "Name:Update\nDesc:Update item\n";
        final String question = "Type a command for Tracker: ";

        menuTracker.fillActions();
        int command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);
        command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);
        menuTracker.select(SHOW_ALL_ITEMS);

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When comment item should check that app attach comment.
     */
    @Test
    void whenTryCommentItemShouldCommentItemAndSaveToTracker() {

        /** Assign block
         Which command will execute - see variable answer:
         0 - key for add operation
         First item - name for item
         First desc - description for item
         4 - key for commenting operation
         1 - position of editing items in list, which show user
         It is my first comment - comment for item
         5 - key for show comments operation
         1 - position of item in list which show user
         */
        final String comment = "It is my first comment";
        final String itemName = "First item";
        final String itemDesc = "First desc";
        String[] answer = new String[]
                        {"0", itemName, itemDesc,
                        "4", "1", comment, "5", "1"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        String expected = "Comment: It is my first comment\n";
        final String question = "Type a command for Tracker: ";

        menuTracker.fillActions();
        int command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);
        command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);
        command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try to get items filtered by text data
     * Should check that app find item with given text.
     */
    @Test
    void whenGetItemsFilterByTextShouldShowItemsWithTextData() {

        /** Assign block
         Which command will execute - see variable answer:
         0 - key for add operation
         Item for search - name for item
         Please, find me - description for item
         6 - key for find by text operation
         find - text for search
         */
        final String testString = "Please, find me!";
        String[] answer = new String[]
                {"0", "Item for search",
                 testString, "6", "find"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        final String expected = "find me";
        final String question = "Type a command for Tracker: ";


        menuTracker.fillActions();
        int command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);
        command = Integer.valueOf(stubIO.ask(question));
        menuTracker.select(command);

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try get items filtered by time
     * Should check that app give items with correct create time.
     */
    @Test
    public final void whenGetItemsFilterByTimeShouldShowItemsWithGivenTime() {

        /** Assign block
         Which command will execute - see variable answer:
         0 - key for add operation
         Time item - name for item
         Time item - description for item
         7 - key for find by time operation
         1 - time for user
         */
        String[] answer = new String[]{"0", "Time item", "Time item", "7", "1"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        final String expected = "Time item";
        final String timeOperation = "Type a command for tracker: ";

        menuTracker.fillActions();
        int command = Integer.valueOf(stubIO.ask(timeOperation));
        menuTracker.select(command);
        command = Integer.valueOf(stubIO.ask(timeOperation));
        menuTracker.select(command);

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try get id of first command
     * Should check that id of first command is zero.
     */
    @Test
    void whenTryGetIdFirstCommandShouldReturnIdOfFirstCommand() {
        String[] answer = new String[]{"Answer"};
        StubIO stubIO = new StubIO(answer);
        MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
        final int expected = 0;

        menuTracker.fillActions();
        int actual = menuTracker.getIdFirstCommand();

        assertThat(actual, is(expected));
    }

    /**
     * When try get id of last command
     * Should check that id of last command is equals seven.
     */
    @Test
    void whenGetIdLastCommandShouldIdOfLastCommand() {
        String[] answer = new String[]{"answer"};
        StubIO stubIO = new StubIO(answer);
        final Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(stubIO, tracker);
        final int expected = 7;

        menuTracker.fillActions();
        int actual = menuTracker.getIdLastCommand();

        assertThat(actual, is(expected));
    }
}

