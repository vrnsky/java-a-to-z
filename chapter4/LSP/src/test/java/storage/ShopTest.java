package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Calendar;
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
        DateTime createTime = new DateTime();
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusMonths(2);
        createTime = createTime.minusDays(16);
        Food food = new Food("food", createTime, expaireTime, 1.0, 0);
        Shop shop = new Shop();
        String expected = String.format("At this moment at the shop:\n%s", food.toString());

        //Action block
        shop.addFood(food);

        //Assert block
        assertThat(shop.toString(), is(expected));
    }
}
