package ru.evrnsky.start;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import start.Comment;
import start.Item;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for tracker which work with database.
 */
class TrackerTest {

    /**
     * System under test.
     */
    private ru.evrnsky.start.Tracker tracker;

    /**
     * Helper for creating database.
     */
    private DBTestUtil util;

    /**
     * Before each test deploy new schema to database.
     */
    @BeforeEach
    public void setUp() {
        this.tracker = new Tracker(Settings.class.getClassLoader().getResourceAsStream("db.properties"));
        this.util = new DBTestUtil();
        util.createItemTable();
        util.createCommentTable();
    }

    /**
     * When try to add item to the database should check that was added.
     *
     * @throws Exception if some happended.
     */
    @Test
    void whenTryAddItemShouldCheckThatAllIsOk() throws Exception {
        Item item = new Item();
        item.setId(String.valueOf("-1"));
        item.setName("My First Item");
        item.setDescription("My First Description");
        this.tracker.addItem(item);
        assertThat(item.getId(), is(String.valueOf(1)));
    }

    /**
     * When try edit item should check that data saved.
     */
    @Test
    public void whenTryEditItemShouldCheckThatDataSaved() {
        Item item = new Item();
        item.setId("example");
        item.setName("First bug");
        item.setName("When tap on the button does not happen anything");
        this.tracker.addItem(item);
        item.setName("First serious bug");
        this.tracker.editItem(item);
        assertThat(this.tracker.getAllItems().get(0).getName(), is(item.getName()));
    }

    /**
     * When try remove item should check that data was removed.
     */
    @Test
    public void whenTryRemoveItemShouldCheckThatItemWasRemoved() {
        Item item = new Item();
        item.setName("new item");
        item.setDescription("new description");
        this.tracker.addItem(item);
        this.tracker.removeItem(item.getId());
        assertThat(this.tracker.getAllItems().size(), is(0));
    }

    /**
     * When try add comment to item should check that comment was added.
     */
    @Test
    public void whenTryAddCommentToItemShouldCheckThatCommentWasAdded() {
        Item item = new Item();
        item.setName("Item with comment");
        item.setDescription("It is my first item at this place");
        this.tracker.addItem(item);
        tracker.addComment(item, "my comment");
        Comment actual = tracker.getComments(item).get(0);
        assertThat(actual.toString(), is("Comment: my comment"));
    }

    /**
     * When try search item by text should check that tracker found it.
     */
    @Test
    public void whenTrySearchItemByTextShouldCheckThatTrackerFoundIt() {
        Item item = new Item();
        item.setName("item");
        item.setDescription("New item");
        item.setCreateTime(1L);
        this.tracker.addItem(item);
        List<Item> items = this.tracker.filteringByTime(0L);
        assertThat(items.get(0).getName(), is("item"));
    }

    /**
     * When try get comment by item should check that all is ok.
     */
    @Test
    public void whenTryGetLastAndFirstOfItemShouldCheckThatAllIsOk() {
        Item item = new Item();
        item.setName("item");
        item.setDescription("new Desc");
        this.tracker.addItem(item);
        int start = this.tracker.getStart();
        assertThat(start, is(0));
    }

    /**
     * When try get items by text data should check that items received.
     */
    @Test
    public void whenTryGetItemByTextDataShouldCheckThatItemsReceived() {
        Item item = new Item();
        item.setName("item");
        item.setDescription("any");
        this.tracker.addItem(item);
        List<Item> items = this.tracker.filteringByText("item");
        assertThat(items.get(0).getDescription(), is("any"));
    }

    /**
     * After each test drop schema from database.
     */
    @AfterEach
    public void tearDown() {
        this.util.dropTable("items");
    }
}