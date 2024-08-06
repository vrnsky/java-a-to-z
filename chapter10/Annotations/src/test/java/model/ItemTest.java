package model;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.hamcrest.core.Is.is;

/**
 * Unit test for Item.java.
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 */
class ItemTest {

    /**
     * When try to create item should check that item created.
     */
    @Test
    void whenTryCreateItemShouldCheckThatItemCreated() {
        Item item = new Item();
        assertThat(item, is(notNullValue()));
    }

    /**
     * When try set id should check that id saved.
     */
    @Test
    void whenTrySetIdShouldCheckThatIdSaved() {
        Item item = new Item();
        item.setId(1);
        assertThat(item.getId(), is(1));
    }

    /**
     * When try set text should check that text saved.
     */
    @Test
    void whenTrySetTextShouldCheckThatTextSaved() {
        Item item = new Item();
        item.setDescription("desc");
        assertThat(item.getDescription(), is("desc"));
    }

    /**
     * When try set author should check that author saved.
     */
    @Test
    void whenTrySetAuthorShouldCheckThatAuthorSaved() {
        Item item = new Item();
        User user = new User();
        item.setAuthor(user);
        assertThat(item.getAuthor(), is(user));
    }

    /**
     * When try set comments list should check that item saved list.
     */
    @Test
    void whenTrySetCommentsListShouldCheckThatItemSavedList() {
        List<Comment> comments = new ArrayList<>();
        Comment comment = new Comment();
        comment.setText("value");
        Item item = new Item();
        item.setComments(comments);
        assertThat(item.getComments(), is(comments));
    }

    /**
     * When try to string item should check that all is ok.
     */
    @Test
    void whenTryToStringItemShouldCheckThatAllIsOk() {
        User user = new User();
        user.setEmail("vrnsky@vrnsky.com");
        Item item = new Item();
        item.setAuthor(user);
        item.setDescription("desc");
        String expected = String.format("%s create next: %s", "vrnsky@vrnsky.com", "desc");
        assertThat(item.toString(), is(expected));
    }
}