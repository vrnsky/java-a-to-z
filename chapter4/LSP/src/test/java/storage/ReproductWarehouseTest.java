package storage;

import food.Food;
import food.ReproductFood;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for ReproductWarehouse.
 */
public class ReproductWarehouseTest {

    /**
     * When try add food to reproduct warehouse should check than shop save it.
     */
    @Test
    public void whenTryAddFoodToReproductWarehouseShouldCheckThatShopSaveIt() {

        //Assign block
        Food food = new ReproductFood("food", new GregorianCalendar(2016,6,1), new GregorianCalendar(2016,7,1), 1.0, 0, true);
        ReproductWarehouse reproductWarehouse = new ReproductWarehouse();
        reproductWarehouse.setTemperature(10);
        String expected = "At this moment at the reproduct warehouse: \n" +
                          "Name:food\n" +
                          "Was added: 01.07.2016\n"+
                          "Expair date: 01.08.2016\n"+
                          "Price: 1.0\n" +
                          "Discount: 0\n" +
                          "Can reproduct: true";

        //Action block
        reproductWarehouse.addFood(food);

        //Assert block
        assertThat(reproductWarehouse.toString(), is(expected));
    }
}
