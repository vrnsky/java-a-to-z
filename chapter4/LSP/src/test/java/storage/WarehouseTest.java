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
        Food food = new Food("food", new GregorianCalendar(), new GregorianCalendar(), 1.0, 0);
        Warehouse warehouse = new Warehouse();
        String expected = "At this moment at the warehouse:\n" +
                          "Name:food\n" +
                          "Was added: 18.07.2016\n" +
                          "Expair date: 18.07.2016\n" +
                          "Price: 1.0\n" +
                          "Discount: 0";

        //Action block
        warehouse.addFood(food);

        //Assert block
        assertThat(warehouse.toString(), is(expected));
    }
}
