package models;

import org.junit.Test;
import start.Comment;
import start.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.11.2016
 */
public class TaskTest {

    /**
     * When create task should check that created.
     */
    @Test
    public final void whenCreateTaskShouldCheckThatCreated() {
        start.Task task = new start.Task("task", "desc");
        assertThat(task != null, is(true));
    }

    /**
     * When create task should check data saved.
     */
    @Test
    public final void whenCreateTaskShouldCheckDataSaved() {
        start.Task task = new start.Task("task", "desc");
        assertThat(task.getName(), is("task"));
        assertThat(task.getDescription(), is("desc"));
    }

    /**
     * When update name should check that data saved.
     */
    @Test
    public final void whenUpdateNameShouldCheckData() {
        start.Task task = new start.Task("task", "desc");
        task.setName("new task");
        assertThat(task.getName(), is("new task"));
    }

    /**
     * When update desc should check data.
     */
    @Test
    public final void whenUpdateDescShouldCheckData() {
        start.Task task = new start.Task("task", "desc");
        task.setDescription("new desc");
        assertThat(task.getDescription(), is("new desc"));
    }

    /**
     * When check create time should check that is correct.
     */
    @Test
    public final void whenCheckCreateTimeShouldCheckThatIsCorrect() {
        start.Task task = new start.Task("task", "desc");
        assertThat(task.getCreateTime() > 1L, is(true));
    }

    /**
     * When add comment should check that comment add.
     */
    @Test
    public final void whenAddCommentShouldCheckThatCommentAdd() {
        start.Task task = new Task("task", "desc");
        final String comment = "comment";
        task.addComment(new Comment(comment));
        assertThat(task.getComments()[0].toString(), is(String.format("%s: %s", "Comment", comment)));
    }

}
