package storage;

import food.Food;
import org.junit.Test;

import java.util.GregorianCalendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Unit test for Shop.java.
 */
public class ShopTest {

    /**
     * When try add food to shop should check than shop save it.
     */
    @Test
    public void whenTryAddFoodToShopShouldCheckThatShopSaveIt() {

        //Assign block
        Food food = new Food("food", new GregorianCalendar(2016,6,1), new GregorianCalendar(2016,7,1), 1.0, 0);
        Shop shop = new Shop();
        String expected = "At this moment at the shop:\n" +
                          "Name:food\n" +
                          "Was added: 01.07.2016\n"+
                          "Expair date: 01.08.2016\n"+
                          "Price: 1.0\n" +
                          "Discount: 0";

        //Action block
        shop.addFood(food);

        //Assert block
        assertThat(shop.toString(), is(expected));
    }
}
