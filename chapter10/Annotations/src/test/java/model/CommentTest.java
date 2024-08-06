package model;



import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 *
 * Unit test for comments.
 */
class CommentTest {

    /**
     * When try to create comment should check that all is ok.
     */
    @Test
    void whenTryCreateCommentShouldCheckThatAllOK() {
        Comment comment = new Comment();
        assertThat(comment, is(notNullValue()));
    }

    /**
     * When try set id should check that id saved.
     */
    @Test
    void whenTrySetIdShouldCheckThatIdSaved() {
        Comment comment = new Comment();
        comment.setId(1);
        assertThat(comment.getId(), is(1));
    }

    /**
     * When try set text should check that text saved.
     */
    @Test
    void whenTrySetTextShouldCheckThatTextSaved() {
        Comment comment = new Comment();
        comment.setText("new text");
        assertThat(comment.getText(), is("new text"));
    }

    /**
     * When try set author should check that author is saved.
     */
    @Test
    void whenTrySetAuthorShouldCheckThatAuthorIsSaved() {
        Comment comment = new Comment();
        User user = new User();
        comment.setAuthor(user);
        assertThat(comment.getAuthor(), is(user));
    }
}