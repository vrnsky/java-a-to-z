package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Trash.java.
 */
class TrashTest {

    /**
     * When try adding food to trash should check that trash save it.
     */
    @Test
    void whenTryAddFoodToTrashShouldCheckThatTrashSaveIt() {

        //Assign block
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusDays(1).plusHours(23);
        DateTime createTime = new DateTime();
        createTime = createTime.minusDays(1);
        Food food = new Food("food", createTime, expaireTime, 1.0, 0);
        Trash trash = new Trash();
        String expected = String.format("At this moment at the trash:\n%s", food.toString());

        //Action block
        trash.addFood(food);

        //Assert block
        assertThat(trash.toString(), is(expected));
    }
}
