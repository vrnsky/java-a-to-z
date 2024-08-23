package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Shop.java.
 */
class ShopTest {

    /**
     * When try adding food to shop should check than shop save it.
     */
    @Test
    void whenTryAddFoodToShopShouldCheckThatShopSaveIt() {
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
