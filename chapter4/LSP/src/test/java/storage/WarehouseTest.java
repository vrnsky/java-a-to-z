package storage;

import food.Food;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Warehouse.java.
 */
class WarehouseTest {

    /**
     * When try adding food to warehouse should check that is works correct.
     */
    @Test
    void whenTryAddFoodToWarehouseShouldCheckThatWarehouseSaveIt() {
        DateTime today = new DateTime().minusDays(9);
        DateTime expiry = new DateTime().plusYears(1);
        Food food = new Food("food", today, expiry, 1.0, 0);
        Warehouse warehouse = new Warehouse();
        String expected = String.format("At this moment at the warehouse:\n%s", food);

        warehouse.addFood(food);

        assertThat(warehouse.toString(), is(expected));
    }
}
