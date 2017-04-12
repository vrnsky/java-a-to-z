package repository;

import database.DBManager;
import model.Item;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


/**
 * @author evrnsky <vrnsky at protonmail.ch>
 * @version 0.1
 * @since 11.04.2017
 *
 * Unit test for item repository.
 */
public class ItemRepositoryTest {

    /**
     * Before each test case we need to build session factory.
     */
    @BeforeClass
    public static void setUp() {
        DBManager.getInstance().buildSessionFactory();
    }

    /**
     * When try add item should check that item was added.
     */
    @Test
    public void whenTryAddItemShouldCheckThatItemWasAdded() {
        Item item = new Item("Value");
        ItemRepository.getInstance().addItem(item);
        assertThat(item.getId() != 0, is(true));
        assertThat(item.getCreationTime(), is(notNullValue()));
    }

    /**
     * When try edit item should check that data saved.
     */
    @Test
    public void whenTryEditItemShouldCheckThatDataSaved() {
        Item item = new Item("value");
        ItemRepository.getInstance().addItem(item);
        item.setDesc("new value");
        ItemRepository.getInstance().editItem(item);
        assertThat(ItemRepository.getInstance().getById(item.getId()).getDesc(), is(item.getDesc()));
    }

    /**
     * When try remove item should check that item removed.
     */
    @Test
    public void whenTryRemoveItemShouldCheckThatItemRemoved() {
        Item item = new Item("value");
        ItemRepository.getInstance().addItem(item);
        ItemRepository.getInstance().addItem(item);
        ItemRepository.getInstance().remove(item);
        assertEquals(ItemRepository.getInstance().getAll(false).size(), 1);
    }

    /**
     * When try to show only done task should check that correct.
     */
    @Test
    public void whenTryToShowOnlyAlreadyDoneTaskShouldCheckThatAllIsOk() {
        Item item = new Item("not done");
        item.setDone(false);
        Item twoItem = new Item("done");
        twoItem.setDone(true);
        ItemRepository.getInstance().addItem(item);
        ItemRepository.getInstance().addItem(twoItem);
        assertEquals(ItemRepository.getInstance().getAll(true).size(), 1);

    }

    /**
     * When try get item by id should check that all is ok.
     */
    @Test
    public void whenTryGetItemByIdShouldCheckThatIsCorrectItem() {
        Item item = new Item("value");
        ItemRepository.getInstance().addItem(item);
        assertEquals(ItemRepository.getInstance().getById(item.getId()).getDesc(), "value");
    }

    /**
     * After each test close session factory.
     */
    @AfterClass
    public static   void tearDown() {
        DBManager.getInstance().closeSessionFactory();
    }
}