package model;



import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.Is.is;


/**
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 *
 * It is unit test for item.java.
 */
class ItemTest {

    /**
     * When try to create item should check that item was created.
     */
    @Test
    void whenTryCreateItemShouldCheckThatItemWasCreated() {
        Item item = new Item();
        assertThat(item, is(notNullValue()));
    }

    /**
     * When try set id should check that item save id.
     */
    @Test
    void whenTrySetIdShouldCheckThatItemSaveId() {
        Item item = new Item();
        item.setId(1);
        assertThat(item.getId(), is(1));
    }

    /**
     * When try set description should check that item return description.
     */
    @Test
    void whenTrySetDescriptionShouldCheckThatItemReturnDesc() {
        Item item = new Item();
        item.setDesc("test");
        assertThat(item.getDesc(), is("test"));
    }

    /**
     * When try set timestamp should check that is correct.
     */
    @Test
    void whenTryGetTimestampShouldCheckThatIsCorrect() {
        Item item = new Item();
        Timestamp time = new Timestamp(1L);
        item.setCreationTime(time);
        assertThat(item.getCreationTime(), is(time));
    }

    /**
     * When try set done should check that item save done flag.
     */
    @Test
    void whenTrySetDoneShouldCheckThatItemSaveDoneFlag() {
        Item item = new Item();
        item.setDone(true);
        assertThat(item.isDone(), is(true));
    }
}