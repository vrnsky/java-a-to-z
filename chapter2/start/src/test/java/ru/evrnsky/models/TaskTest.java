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
class TaskTest {

    /**
     * When create task should check that created.
     */
    @Test
    void whenCreateTaskShouldCheckThatCreated() {
        Task task = new Task("task", "desc");
        Assertions.assertNotNull(task);
    }

    /**
     * When create task should check data saved.
     */
    @Test
    void whenCreateTaskShouldCheckDataSaved() {
        Task task = new Task("task", "desc");
        assertThat(task.getName(), is("task"));
        assertThat(task.getDescription(), is("desc"));
    }

    /**
     * When update name should check that data saved.
     */
    @Test
    void whenUpdateNameShouldCheckData() {
        Task task = new Task("task", "desc");
        task.setName("new task");
        assertThat(task.getName(), is("new task"));
    }

    /**
     * When update desc should check data.
     */
    @Test
    void whenUpdateDescShouldCheckData() {
        Task task = new Task("task", "desc");
        task.setDescription("new desc");
        assertThat(task.getDescription(), is("new desc"));
    }

    /**
     * When check create time should check that is correct.
     */
    @Test
    void whenCheckCreateTimeShouldCheckThatIsCorrect() {
        Task task = new Task("task", "desc");
        assertThat(task.getCreateTime() > 1L, is(true));
    }

    /**
     * When add comment should check that comment add.
     */
    @Test
    void whenAddCommentShouldCheckThatCommentAdd() {
        Task task = new Task("task", "desc");
        final String comment = "comment";
        task.addComment(new Comment(comment));
        assertThat(task.getComments()[0].toString(), is(String.format("%s: %s", "Comment", comment)));
    }

}
