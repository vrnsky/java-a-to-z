package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Shop.java.
 */
public class ShopTest {

    /**
     * When try add food to shop should check than shop save it.
     */
    @Test
    public void whenTryAddFoodToShopShouldCheckThatShopSaveIt() {
        DateTime createTime = new DateTime();
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusMonths(2);
        createTime = createTime.minusDays(19);
        Food food = new Food("food", createTime, expaireTime, 1.0, 0);
        Shop shop = new Shop();
        String expected = String.format("At this moment at the shop:\n%s", food.toString());

        shop.addFood(food);

        assertThat(shop.toString(), is(expected));
    }
}
