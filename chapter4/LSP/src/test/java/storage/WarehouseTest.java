package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for Warehouse.java
 */
public class WarehouseTest {

    /**
     * When try add food to warehouse should check that is works correct.
     */
    @Test
    public void whenTryAddFoodToWarehouseShouldCheckThatWarehouseSaveIt() {

        //Assign block
        DateTime today = new DateTime().minusDays(9);
        DateTime expair = new DateTime().plusYears(1);
        Food food = new Food("food", today, expair, 1.0, 0);
        Warehouse warehouse = new Warehouse();
        String expected = String.format("At this moment at the warehouse:\n%s", food.toString());

        //Action block
        warehouse.addFood(food);

        //Assert block
        assertThat(warehouse.toString(), is(expected));
    }
}
