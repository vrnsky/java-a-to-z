package start;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
     * Object which deploy and drop database to and from server.
     */
    private static final Preparator PREPARATOR = new Preparator();


    /**
     * Init instance of testing class, it placed there to reduce code in test.
     * @throws IOException if problem with io.
     * @throws SQLException if problem with access to the database or connection or statement already closed.
     */
    @Before
    public final void setUp() throws IOException, SQLException {
        tracker = new Tracker();
    }

    /**
     * Before all tests need create database.
     * @throws SQLException if problem with access to the database or connection or statement already closed.
     */
    @BeforeClass
    public static void createBase() throws SQLException {
        PREPARATOR.createDatabase();
    }

    /**
     * After all tests need drop database.
     * @throws SQLException if problem with access to the database or connection or statement already closed.
     */
    @AfterClass
    public static void dropBase() throws SQLException {
        PREPARATOR.dropDatabase();
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

        int removed = tracker.removeItem(item.getId());

        assertThat(removed, is(1));
    }

    /**
     * When try to get all items should check that items array not empty.
     */
    @Test
    public final void whenTryGetAllItemsShouldReturnNotNullArrayOfItems() {
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.addItem(new Item());

        List<Item> allItems = tracker.getAllItems();
        boolean result = allItems.size() > 0;

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

        List<Item> filteredByText = tracker.filteringByText("F");
        boolean result = filteredByText.size() > 0;

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

        List<Item> filteredByTime = tracker.filteringByTime(1L);
        boolean result = filteredByTime.size() > 0;

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
        Item second = new Item("It is my second item", "It is my second item");
        tracker.addItem(second);
        int expected = tracker.getFinish() - 1;
        tracker.removeItem(second.getId());
        int actual = tracker.getFinish();
        assertThat(actual, is(expected));
    }


}
