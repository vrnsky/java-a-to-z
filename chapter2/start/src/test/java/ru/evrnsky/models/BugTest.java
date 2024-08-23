package ru.evrnsky.models;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.11.2016
 */
class BugTest {

    /**
     * when try create bug should check that is created.
     */
    @Test
    void whenTryCreateBugShouldCheckThatIsCreated() {
        Bug bug = new Bug();
        Assertions.assertNotNull(bug);
    }

    /**
     * when try set name for bug should check correct.
     */
    @Test
    void whenSetNameBugShouldCheckCorrect() {
        Bug bug = new Bug();
        final String expected = "Issue";
        bug.setName(expected);
        assertThat(bug.getName(), is(expected));
    }

    /**
     * When try set desc for bug should check correct.
     */
    @Test
    void whenSetDescShouldCheckCorrect() {
        Bug bug = new Bug();
        final String desc = "Issue";
        bug.setDescription(desc);
        assertThat(bug.getDescription(), is(desc));
    }

    /**
     * When check create time should check that correct.
     */
    @Test
    void whenCheckCreateTimeShouldCheckThatIsCorrect() {
        Bug bug = new Bug();
        boolean correct = bug.getCreateTime() > 1L;
        assertThat(correct, is(true));
    }

    /**
     * When add comment should check that comment was add.
     */
    @Test
    void whenAddCommentShouldCheckThatCommentWasAdd() {
        Bug bug = new Bug();
        final String comment = "First comment";
        bug.addComment(new Comment(comment));
        assertThat(bug.getComments()[0].toString(), is(String.format("%s: %s", "Comment", comment)));
    }
}
