package models;

import org.junit.Test;
import start.Bug;
import start.Comment;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.11.2016
 */
public class BugTest {

    /**
     * when try create bug should check that is created.
     */
    @Test
    public final void whenTryCreateBugShouldCheckThatIsCreated() {
        start.Bug bug = new start.Bug();
        assertThat(bug != null, is(true));
    }

    /**
     * when try set name for bug should check correct.
     */
    @Test
    public final void whenSetNameBugShouldCheckCorrect() {
        start.Bug bug = new start.Bug();
        final String expected = "Issue";
        bug.setName(expected);
        assertThat(bug.getName(), is(expected));
    }

    /**
     * When try set desc for bug should check correct.
     */
    @Test
    public final void whenSetDescShouldCheckCorrect() {
        start.Bug bug = new start.Bug();
        final String desc = "Issue";
        bug.setDescription(desc);
        assertThat(bug.getDescription(), is(desc));
    }

    /**
     * When check create time should check that correct.
     */
    @Test
    public void whenCheckCreateTimeShouldCheckThatIsCorrect() {
        start.Bug bug = new start.Bug();
        boolean correct = bug.getCreateTime() > 1L;
        assertThat(correct, is(true));
    }

    /**
     * When add comment should check that comment was add.
     */
    @Test
    public void whenAddCommentShouldCheckThatCommentWasAdd() {
        start.Bug bug = new Bug();
        final String comment = "First comment";
        bug.addComment(new Comment(comment));
        assertThat(bug.getComments()[0].toString(), is(String.format("%s: %s", "Comment", comment)));
    }



}
