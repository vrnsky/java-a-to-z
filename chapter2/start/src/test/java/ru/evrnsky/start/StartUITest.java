package ru.evrnsky.start;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.IsNot.not;

/**
 * Unit test for StartUI.java.
 * It test whatever to show user.
 */
class StartUITest {

    /**
     * When user try add item should check that item was added.
     */
    @Test
     void whenAddItemToAppUseUIShouldAddItemToTracker() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 2 - show all items
         * y - exit now
         */
        String[] answer = new String[]
                {"0", "New item", "New item",
                        "n", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);

        //Act block
        launch.init();

        assertThat(stubIO.getOut(), containsString("New item"));
    }

    /**
     * When try to remove item should check that item was removed.
     */
    @Test
    void whenRemoveItemFromAppUseUIShouldRemoveItemFromTracker() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 1 - remove item command
         * 1 - number of item in list which show user
         * n - no exit now
         * 2 - show all items. At this moment tracker must have 0 items
         * y - exit now
         */
        String[] answer = new String[]
                {"0", "New item", "New item",
                        "n", "1", "1", "n", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);

        launch.init();

        assertThat(stubIO.getOut(), not(containsString("New item")));
    }

    /**
     * When edit item should check that item was updated.
     */
    @Test
    final void whenEditItemUseUIShouldUpdateInTracker() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 3 - edit item command
         * 1 - number of item which will be edited
         * n - no exit now
         * 2 - show all items
         * y - exit now
         */
        String[] answer = new String[]
                {"0", "New item", "New item", "n", "3",
                        "1", "Updated item", "Updated item", "n", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);

        launch.init();

        assertThat(stubIO.getOut(), containsString("Updated item"));
    }

    /**
     * When try to commend item should check that comment was attached to item.
     */
    @Test
    void whenCommentItemShouldAttachCommentToTracker() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 4 - comment command
         * 1 - number of item in list
         * n - no exit now
         * 5 - show comments command
         * 1 - number of item in list which show user
         * y - exit now
         */
        String[] answer = new String[]
                {"0", "New item", "New item", "n", "4",
                        "1", "It is my first comment", "n", "5", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);
        String expected = "Comment: It is my first comment\n";

        launch.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try find item by text data should check that app show correct items.
     */
    @Test
    void whenFindItemByTextShouldShowItemsWithGivenText() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 6 - find by text data command
         * item - text
         * y - exit now
         */

        String[] answer = new String[]
                {"0", "It is my first item",
                        "It is your item?", "n", "6", "item", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);
        String expected = "It is my first item";

        launch.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When find items by time should check that app show correct item.
     */
    @Test
    void whenTryFindItemsByTimeShouldShowItemsWithGivenTime() {

        /** Assign block
         * in variable answer write next command:
         * 0 - add item, further two strings are name and description
         * n - no exit now
         * 7 - find items by time
         * 1 - time for search
         * y - exit now
         */
        String[] answer = new String[]
                {"0", "It is my second item",
                 "It is my second item", "n", "7", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        StartUI launch = new StartUI(stubIO);
        String expected = "It is my second item";

        launch.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }
}

