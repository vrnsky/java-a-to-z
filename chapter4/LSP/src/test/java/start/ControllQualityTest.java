package start;

import food.Food;
import org.junit.Test;
import storage.Shop;
import storage.Trash;
import storage.Warehouse;

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
        Food food = new Food("food", new GregorianCalendar(2016,6,20), new GregorianCalendar(2016,6,30), 3.5, 0);
        String expected =  "At this moment at the warehouse:\n" +
                           "Name:food\n"+
                           "Was added: 20.07.2016\n" +
                           "Expair date: 30.07.2016\n" +
                           "Price: 3.5\nDiscount: 0";

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
        Food food = new Food("food", new GregorianCalendar(2016,6,17), new GregorianCalendar(2016, 6, 24), 3.5, 0);
        String expected = "At this moment at the shop:\n"+"" +
                          "Name:food\n" +
                          "Was added: 17.07.2016\n" +
                          "Expair date: 24.07.2016\n" +
                          "Price: 3.5\n" +
                          "Discount: 0";

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
        Food food = new Food("food", new GregorianCalendar(2016, 5, 10), new GregorianCalendar(2016,6,31), 3.5, 0);
        String expected = "At this moment at the shop:\n" +
                          "Name:food\n" +
                          "Was added: 10.06.2016\n" +
                          "Expair date: 31.07.2016\n" +
                          "Price: 3.5\n" +
                          "Discount: 20";
        //Action block
        control.addStorage(new Shop());
        control.moveFood(food);
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
        Food food = new Food("food", new GregorianCalendar(2016,4,1), new GregorianCalendar(2016,6,15), 3.5, 0);
        String expected = "At this moment at the trash:\n" +
                          "Name:food\n" +
                          "Was added: 01.05.2016\n" +
                          "Expair date: 15.07.2016\n" +
                          "Price: 3.5\nDiscount: 0";

        //Action block
        control.addStorage(new Trash());
        control.moveFood(food);
        Trash trash = (Trash)control.getStorage(0);

        //Assign block
        assertThat(trash.toString(), is(expected));
    }
}
