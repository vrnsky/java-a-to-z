package start;

import org.junit.Before;
import org.junit.Test;
import models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Unit test for Tracker.java.
 * It test next functionality: add, edit, remove, comment, filtered by text and time options.
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
    public void setUp()
    {
        tracker = new Tracker();
    }

    /**
     * When try add item should check that item was added.
     */
    @Test
    public void whenTryAddItemToTrackerShouldTryGetLastItemFromTracker() {
        //Assign block
        Item item = new Item();

        //Act block
        Item result = tracker.addItem(item);

        //Action block
        assertThat(result, is(item));
    }

    /**
     * When try edit item should check that changes was saved.
     */
    @Test
    public void whenTryEditItemShouldTryGetEditedItem() {
        //Assign block
        Item item = new Item();
        tracker.addItem(item);
		String expectedResult = "Edited by me";
		

        //Act block
		item.setName(expectedResult);
        Item updateItem = tracker.editItem(item);
		String result = updateItem.getName();


        //Check some component of item will be changed
		assertThat(result, is(expectedResult));
    }

    /**
     * When try remove item should check that item was removed.
     */
    @Test
    public void whenTryRemoveItemShouldTrackerReturnDeletedItem() {
        //Assign block
        Item item = new Item();
        tracker.addItem(item);

        //Act block
        Item removed = tracker.removeItem(item.getId()); 

        //Action block
        assertThat(removed, is(item));
    }

    /**
     * When try to get all items should check that items array not empty.
     */
    @Test
    public void whenTryGetAllItemsShouldReturnNotNullArrayOfItems() {
        //Assign block
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.addItem(new Item());

        //Act block
        Item[] allItems = tracker.getAllItems();
        boolean result = allItems.length > 0;

        //Action block
        assertThat(result, is(true));
    }

    /**
     * When try to find items with given text data should check that tracker return correct items.
     */
    @Test
    public void whenTryFindFilteredByTextItemsShouldReturnItemsWhichContainsString() {
        //Assign block
        tracker.addItem(new Item("Small bug", "Fix before next week"));
        tracker.addItem(new Item("Float bug", "Fix before 09.06.16"));
        tracker.addItem(new Item("Important bug", "Fix now"));

        //Act block
        Item[] filteredByText = tracker.getItemsFilteredByText("Fix");
        boolean result = filteredByText.length > 0;

        //Action block
        assertThat(result, is(true));
    }

    /**
     * When try find items which created after given time should check that tracker return correct items.
     */
    @Test
    public void whenTryFindFilteredByTimeCreatingShouldReturnItemsWhichWereCreatedAfterGivenMiliseconds() {
        //Assign block
        tracker.addItem(new Item("First name", "First description"));
        tracker.addItem(new Item("Second task", "Second description"));
        tracker.addItem(new Item("Third name", "Third description"));

        //Act block
        Item[] filteredByTime = tracker.getItemsFilteredByTime(1L);
        boolean result = filteredByTime.length > 0;

        //Action block
        assertThat(result, is(true));
    }

    /**
     * When try get position of first item in array should get position of first item in items array.
     */
	@Test
	public void whenTryToGetIdOfFirstItemShouldReturnIdOfFirstItem() {
		
		//Assign block
		tracker.addItem(new Item("First name", "First item"));
		int expected = 0;

        //Act block
		int actual = tracker.getStart();

        //Action block
		assertThat(actual, is(expected));
	}

    /**
     * When try get id of last item should check that tracker return correct position.
     */
    @Test
	public void whenTryToGetIdOfLastItemShouldReturnIfOfLastItem() {
		
		//Assign block
		Item first = new Item("It is my first item", "It is my first item");
		Item second = new Item("It is my second item", "It is my second item");
		Item third = new Item("It is my third item", "It is my third item");
		tracker.addItem(first);
		tracker.addItem(second);
		tracker.addItem(third);
		int expected = 2;
			
		//Act block
		tracker.removeItem(second.getId());
		int actual = tracker.getFinish();
		
		//Assign block
		assertThat(actual, is(expected));
	}
}