package models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Item.java.
 */
public class ItemTest {


    /**
     * When create item should check it is not null.
     */
    @Test
    public final void whenCreateItemShouldCheckItIsNotNull() {
        Item item = new Item("It is my first item", "It is my first item");
        boolean expected = true;

        assertThat(item != null, is(true));
    }

    /**
     * When create item should check the name of item saved.
     */
    @Test
    public final void whenCreateItemShouldCheckItemSaveData() {
        Item item = new Item("first item", "It is my first item");
        String expected = "first item";

        String actual = item.getName();

        assertThat(actual, is(expected));
    }

    /**
     * When create item should check the desc is saved.
     */
    @Test
    public final void whenCreateItemShouldCheckItemSaveDescription() {
        Item item = new Item("asd", "item");
        String expected = "item";


        String actual = item.getDescription();

        assertThat(actual, is(expected));
    }

    /**
     * When update item should check item saved.
     */
    @Test
    public final void whenUpdateItemNameShouldCheckItSaved() {
        Item item = new Item();
        String expected = "It is name";

        item.setName("It is name");
        String actual = item.getName();

        assertThat(actual, is(expected));
    }

    /**
     * When update item description should check it saved.
     */
    @Test
    public final void whenUpdateItemDescShouldCheckItSaved() {
        Item item = new Item();
        String expected = "It is desc";

        item.setDescription("It is desc");
        String actual = item.getDescription();

        assertThat(actual, is(expected));
    }

    /**
     * When create item should check than generateTime works correct.
     */
    @Test
    public final void whenCreateItemShouldCheckTimeOfCreateCorrect() {
        Item item = new Item();

        long time = item.getCreateTime();
        boolean actual = time > 1L;

        assertThat(actual, is(true));
    }

    /**
     * When try attach comment to item should check the comment is saved.
     */
    @Test
    public final void whenTryAttachCommentToItemShouldCheckCommentSave() {
        Item item = new Item();
        Comment comm = new Comment("It is my first comment:");
        String expected = "Comment: It is my first comment:";

        item.addComment(comm);
        Comment actual = item.getComments()[0];

        assertThat(actual.toString(), is(expected));
    }
}
