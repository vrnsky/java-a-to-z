package start;

import food.Food;
import org.junit.Test;
import storage.Shop;
import storage.Trash;
import storage.Warehouse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for ControllQuiality.java
 * It test moving food in trash, shop and warehouse
 */
public class ControllQualityTest {


    /**
     * When try move good fruit to warehouse should check than warehouse save it
     */
    @Test
    public void whenTryMoveGoodFruitToWarehouseShouldCheckThatAtWarehouse() {

        //Assign block
        ControllQuality control = new ControllQuality();
        Calendar expairTime = new GregorianCalendar();
        expairTime.add(Calendar.MONTH, 3);
        Food food = new Food("food", expairTime , 3.5, 0);
        String expected = "At this moment at the warehouse:\n" + food.toString();

        //Action block
        control.addStorage(new Warehouse());
        control.moveFood(food);
        Warehouse warehouse = (Warehouse)control.getStorage(0);

        //Assert block
        assertThat(warehouse.toString(), is(expected));
    }

    /**
     * When try move some food to shop should check than shop is save it.
     */
    @Test
    public void whenTryMoveSomeFoodToShopShouldCheckThatFoodOnTheShop() {

        //Assign block
        ControllQuality control = new ControllQuality();
        Calendar expaireTime = new GregorianCalendar();
        expaireTime.add(Calendar.HOUR, 1000);
        Calendar creationDate = new GregorianCalendar();
        creationDate.add(Calendar.HOUR, 215);
        Food food = new Food("food", creationDate, expaireTime, 3.5, 0);
        String expected = "At this moment at the shop:\n" + food.toString();

        //Action block
        control.addStorage(new Shop());
        control.moveFood(food);
        Shop shop = (Shop)control.getStorage(0);

        //Assert block
        assertThat(shop.toString(), is(expected));
    }

    /**
     * When try move some food which must with discount should check that shop save it.
     */
    @Test
    public void whenTryMoveSomeFoodWhichMustWithDiscountShouldCheckThatIsCorrect() {

        //Assign block
        ControllQuality control = new ControllQuality();
        Calendar createTime = new GregorianCalendar();
        createTime.roll(Calendar.DAY_OF_MONTH, 4);
        Calendar expaireTime = new GregorianCalendar();
        expaireTime.add(Calendar.DAY_OF_MONTH, 10);
        Food food = new Food("food", createTime, expaireTime, 3.5, 0);


        //Action block
        control.addStorage(new Shop());
        control.moveFood(food);
        String expected = "At this moment at the shop:\n" + food.toString();
        Shop shop = (Shop)control.getStorage(0);

        //Assert block
        assertThat(shop.toString(), is(expected));
    }

    /**
     * When try move some food which must be at the trash should check that controller move it to trash.
     */
    @Test
    public void whenTryMoveSomeFoodWhichMustAtTheTrashShouldCheckThatTrashHaveIt() {

        //Assign block
        ControllQuality control = new ControllQuality();
        Calendar createTime = new GregorianCalendar();
        createTime.add(Calendar.DAY_OF_MONTH, -5);
        Calendar expaireTime = new GregorianCalendar();
        expaireTime.add(Calendar.DAY_OF_MONTH, -2);
        Food food = new Food("food", createTime, expaireTime, 3.5, 0);
        String expected = "At this moment at the trash:\n" + food.toString();

        //Action block
        control.addStorage(new Trash());
        control.moveFood(food);
        Trash trash = (Trash)control.getStorage(0);
        System.out.println(trash.isSuitable(food));
        //Assign block
        assertThat(trash.toString(), is(expected));
    }

}
