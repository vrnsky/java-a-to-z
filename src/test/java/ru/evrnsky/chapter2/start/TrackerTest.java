package ru.evrnsky.chapter2.start;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.evrnsky.chapter2.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 Unit test for Tracker.java
 */
public class TrackerTest
{
    private Tracker tracker;

    /**
     JUnit call this method before each test
     Uses for init instance of tracker
     */
    @Before
    public void setUp()
    {
        tracker = new Tracker();
    }

    /**
     When try add item to tracked should get last item from tracker
     It will be equals created item
     */
    @Test
    public void whenTryAddItemToTrackerShouldTryGetLastItemFromTracker()
    {
        //Assign block
        Item item = new Item();

        //Act block
        Item result = tracker.addItem(item);

        //Action block
        assertThat(result, is(item));
    }


    /**
     When try edit item should check that changes was saved
     */
    @Test
    public void whenTryEditItemShouldTryGetEditedItem()
    {
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
     When try remove item should check item was removed
     */
    @Test
    @Ignore
    public void whenTryRemoveItemShouldTrackerReturnDeletedItem()
    {
        //Assign block
        Item item = new Item();
        tracker.addItem(item);

        //Act block
        Item removed = tracker.removeItem(item.getId()); //I do not know how it will works

        //Action block
        assertThat(removed, is(item));
    }

    /**
     When try to get all items from tracker - it should be not null
     */
    @Test
    public void whenTryGetAllItemsShouldReturnNotNullArrayOfItems()
    {
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
     When try to find items which name or description contain given string
     Should return all items which contatins given string
     */
    @Test
    public void whenTryFindFilteredByTextItemsShouldReturnItemsWhichContainsString()
    {
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
     When try to find items which created after given time
     Should return array of items which were created before given time
     */
    @Test
    public void whenTryFindFilteredByTimeCreatingShouldReturnItemsWhichWereCreatedAfterGivenMiliseconds()
    {
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
}