package start;

import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Unit test for TrackerMenu.java.
 * It must check all operations from TrackerMenu.
 */
class TrackerMenuTest {

    /**
     * When use new menu should check that is show correct.
     */
    @Test
    void whenTryUseNewMenuShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"1", "Java", "Course", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menuTracker = new TrackerMenu(stubIO);
        String expected = "1.Add new item \n"
                +
                "2.Remove item \n"
                +
                "3.Show all items \n"
                +
                "4.Edit item \n"
                +
                "5.Comment item \n"
                +
                "6.Show comments \n"
                +
                "7.Filtering by text \n"
                +
                "8.Filtering by date \n";
        menuTracker.init();

        assertThat(stubIO.getOut(), is(expected));
    }

    /**
     * When try using new menu for add new item should check that is works.
     */
    @Test
    void whenTryUseNewMenuForAddNewItemShouldCheckThatWorks() {
        String[] answer = new String[]{"1", "test", "test", "n", "3", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menuTracker = new TrackerMenu(stubIO);
        String expected = "\tName:test\nDesc:test";

        menuTracker.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try using new menu for remove item should check that works.
     */
    @Test
    void whenTryUseNewMenuForRemoveItemShouldCheckThatWorks() {
        String[] answer = new String[]{"1", "test", "test", "n", "2", "1", "n", "2", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menuTracker = new TrackerMenu(stubIO);
        String expected = "Nothing to delete!";

        menuTracker.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try using new menu for show all items should check that all items will show.
     */
    @Test
    void whenTryUseNewMenuForShowAllItemsShouldCheckThatItsWorksCorrect() {
        String[] answer = new String[]{"1", "It is new item", "It is new item", "n", "3", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menu = new TrackerMenu(stubIO);
        String expected = "\tName:It is new item\nDesc:It is new item\n";

        menu.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try using new menu for edit item should check that is works correct.
     */
    @Test
    void whenTryUseNewMenuForEditItemShouldCheckThatIsWorksCorrect() {
        String[] answer = new String[]{"1", "Not edit", "Not edit", "n", "4", "1", "Edited", "Edited", "n", "3", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menuTracker = new TrackerMenu(stubIO);
        String expected = "\tName:Edited\nDesc:Edited\n";

        menuTracker.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try using new menu for comment item should check that works correct.
     */
    @Test
    void whenTryUseNewMenuForCommentItemShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"1", "Will comments", "Will comments", "n", "5", "1", "first comment", "n", "6", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menuTracker = new TrackerMenu(stubIO);
        String expected = "Comment: first comment\n";

        menuTracker.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try use new menu for search item by text should check that works correct.
     */
    @Test
    void whenTryUseNewMenuForSearchItemsByTextShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"1", "find me", "find me", "n", "7", "find me", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menu = new TrackerMenu(stubIO);
        String expected = "\tName:find me\n"
                +
                "Desc:find me";

        menu.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

    /**
     * When try using new menu for search items by time should check that works correct.
     */
    @Test
    void whenTryUseNewMenuForSearchItemsByTimeShouldCheckThatWorksCorrect() {
        String[] answer = new String[]{"1", "timeout", "timeout", "n", "8", "1", "y"};
        StubIO stubIO = new StubIO(answer);
        TrackerMenu menu = new TrackerMenu(stubIO);
        String expected = "\tName:timeout\n"
                +
                "Desc:timeout";

        menu.init();

        assertThat(stubIO.getOut(), containsString(expected));
    }

}
