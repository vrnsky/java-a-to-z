package start;

import models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Unit test for Tracker.java.
 * It test all function from Tracker API.
 */
public class TrackerTest {

    /**
     * Instance of testing class.
     */
    private Tracker tracker;

    /**
     * Init instance of testing class, it placed there to reduce code in test.
     */
    @Before
    public final void setUp() {
        tracker = new Tracker();
    }

    /**
     * When try add item should check that item was added.
     */
    @Test
    public final void whenTryAddItemToTrackerShouldTryGetLastItemFromTracker() {
        Item item = new Item();

        Item result = tracker.addItem(item);

        assertThat(result, is(item));
    }

    /**
     * When try edit item should check that changes was saved.
     */
    @Test
    public final void whenTryEditItemShouldTryGetEditedItem() {
        Item item = new Item();
        tracker.addItem(item);
        String expectedResult = "Edited by me";


        item.setName(expectedResult);
        Item updateItem = tracker.editItem(item);
        String result = updateItem.getName();

        assertThat(result, is(expectedResult));
    }

    /**
     * When try remove item should check that item was removed.
     */
    @Test
    public final void whenTryRemoveItemShouldTrackerReturnDeletedItem() {
        Item item = new Item();
        tracker.addItem(item);

        Item removed = tracker.removeItem(item.getId());

        assertThat(removed, is(item));
    }

    /**
     * When try to get all items should check that items array not empty.
     */
    @Test
    public final void whenTryGetAllItemsShouldReturnNotNullArrayOfItems() {
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.addItem(new Item());

        Item[] allItems = tracker.getAllItems();
        boolean result = allItems.length > 0;

        assertThat(result, is(true));
    }

    /**
     * When find item with text should check tracker return correct items.
     */
    @Test
    public final void whenFindFilterTextItemShouldItemWithText() {
        tracker.addItem(new Item("Small bug", "Fix before next week"));
        tracker.addItem(new Item("Float bug", "Fix before 09.06.16"));
        tracker.addItem(new Item("Important bug", "Fix now"));

        Item[] filteredByText = tracker.getItemsFilteredByText("Fix");
        boolean result = filteredByText.length > 0;

        assertThat(result, is(true));
    }

    /**
     * When find item by create time should check tracker return correct item.
     */
    @Test
    public final void whenFindFilterTimeShouldItemCreatedAfterGivenTime() {
        tracker.addItem(new Item("First name", "First description"));
        tracker.addItem(new Item("Second task", "Second description"));
        tracker.addItem(new Item("Third name", "Third description"));

        Item[] filteredByTime = tracker.getItemsFilteredByTime(1L);
        boolean result = filteredByTime.length > 0;

        assertThat(result, is(true));
    }

    /**
     * When try get position of first item in array.
     * Should get position of first item in items array.
     */
    @Test
    public final void whenTryToGetIdOfFirstItemShouldReturnIdOfFirstItem() {
        tracker.addItem(new Item("First name", "First item"));
        final int expected = 0;

        int actual = tracker.getStart();

        assertThat(actual, is(expected));
    }

    /**
     * When try get id of last item.
     * should check that tracker return correct position.
     */
    @Test
    public final void whenTryToGetIdOfLastItemShouldReturnIfOfLastItem() {
        Item first = new Item("It is my first item", "It is my first item");
        Item second = new Item("It is my second item", "It is my second item");
        Item third = new Item("It is my third item", "It is my third item");
        tracker.addItem(first);
        tracker.addItem(second);
        tracker.addItem(third);
        int expected = 2;

        tracker.removeItem(second.getId());
        int actual = tracker.getFinish();

        assertThat(actual, is(expected));
    }
}
