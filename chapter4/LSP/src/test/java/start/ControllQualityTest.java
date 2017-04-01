package start;

import food.Food;
import org.joda.time.DateTime;
import org.junit.Test;
import storage.Shop;
import storage.Trash;
import storage.Warehouse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for ControllQuiality.java.
 * It test moving food in trash, shop and warehouse.
 */
public class ControllQualityTest {


    /**
     * When try move good fruit to warehouse should check than warehouse save it.
     */
    @Test
    public void whenTryMoveGoodFruitToWarehouseShouldCheckThatAtWarehouse() {
        ControllQuality control = new ControllQuality();
        DateTime expairTime = new DateTime();
        expairTime = expairTime.plusMonths(3);
        Food food = new Food("food", expairTime, 3.5, 0);
        String expected = "At this moment at the warehouse:\n" + food.toString();

        control.addStorage(new Warehouse());
        control.moveFood(food);
        Warehouse warehouse = (Warehouse) control.getStorage(0);

        assertThat(warehouse.toString(), is(expected));
    }

    /**
     * When try move some food to shop should check than shop is save it.
     */
    @Test
    public void whenTryMoveSomeFoodToShopShouldCheckThatFoodOnTheShop() {

        ControllQuality control = new ControllQuality();
        DateTime createTime = new DateTime();
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusMonths(2);
        createTime = createTime.minusDays(17);
        Food food = new Food("food", createTime, expaireTime, 3.5, 0);
        String expected = "At this moment at the shop:\n" + food.toString();

        control.addStorage(new Shop());
        control.moveFood(food);
        Shop shop = (Shop) control.getStorage(0);

        assertThat(shop.toString(), is(expected));
    }

    /**
     * When try move some food which must with discount should check that shop save it.
     */
    @Test
    public void whenTryMoveSomeFoodWhichMustWithDiscountShouldCheckThatIsCorrect() {
        ControllQuality control = new ControllQuality();
        DateTime createTime = new DateTime();
        createTime = createTime.plusDays(4);
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusDays(10);
        Food food = new Food("food", createTime, expaireTime, 3.5, 0);

        control.addStorage(new Shop());
        control.moveFood(food);
        String expected = "At this moment at the shop:\n" + food.toString();
        Shop shop = (Shop) control.getStorage(0);

        assertThat(shop.toString(), is(expected));
    }

    /**
     * When try move some food which must be at the trash should check that controller move it to trash.
     */
    @Test
    public void whenTryMoveSomeFoodWhichMustAtTheTrashShouldCheckThatTrashHaveIt() {
        ControllQuality control = new ControllQuality();
        DateTime expaireTime = new DateTime();
        expaireTime = expaireTime.plusDays(1).plusHours(23);
        DateTime createTime = new DateTime();
        createTime = createTime.minusDays(1);
        Food food = new Food("food", createTime, expaireTime, 3.5, 0);
        String expected = "At this moment at the trash:\n" + food.toString();

        control.addStorage(new Trash());
        control.moveFood(food);
        Trash trash = (Trash) control.getStorage(0);
        assertThat(trash.toString(), is(expected));
    }

}
