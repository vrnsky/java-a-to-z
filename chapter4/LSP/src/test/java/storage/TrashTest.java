package storage;

import food.Food;
import org.junit.Test;

import java.util.GregorianCalendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for Trash.java.
 */
public class TrashTest {

    /**
     * When try add food to trash should check that trash save it.
     */
    @Test
    public void whenTryAddFoodToTrashShouldCheckThatTrashSaveIt() {

        //Assign block
        Food food = new Food("food", new GregorianCalendar(2016,6,1), new GregorianCalendar(2016,6,15), 1.0, 0);
        Trash trash = new Trash();
        String expected = "At this moment at the trash:\n" +
                          "Name:food\n" +
                          "Was added: 01.07.2016\n" +
                          "Expair date: 15.07.2016\n" +
                          "Price: 1.0\n" +
                          "Discount: 0";

        //Action block
        trash.addFood(food);

        //Assert block
        assertThat(trash.toString(), is(expected));
    }
}
