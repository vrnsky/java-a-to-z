package storage;

import food.Food;
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
        Food food = new Food("food", new GregorianCalendar(2016,6, 25), new GregorianCalendar(2016, 11,25), 1.0, 0);
        Warehouse warehouse = new Warehouse();
        String expected = String.format("At this moment at the warehouse:\n%s", food.toString());

        //Action block
        warehouse.addFood(food);

        //Assert block
        assertThat(warehouse.toString(), is(expected));
    }
}
