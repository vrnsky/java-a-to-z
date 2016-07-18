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
        Food food = new Food("food", new GregorianCalendar(), new GregorianCalendar(), 1.0, 0);
        Shop shop = new Shop();
        String expected = "At this moment at the shop:\n" +
                          "Name:food\n" +
                          "Was added: 18.07.2016\n"+
                          "Expair date: 18.07.2016\n"+
                          "Price: 1.0\n" +
                          "Discount: 0";

        //Action block
        shop.addFood(food);

        //Assert block
        assertThat(shop.toString(), is(expected));
    }
}
