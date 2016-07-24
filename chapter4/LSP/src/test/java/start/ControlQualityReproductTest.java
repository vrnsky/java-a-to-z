package start;

import food.Apple;
import food.Food;
import food.ReproductFood;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import storage.ReproductWarehouse;
import java.util.GregorianCalendar;

/**
 * Control quality reproduct unit test.
 */
public class ControlQualityReproductTest {

    /**
     * When try add reproduct food to the reproduct warehouse should check that works is correct.
     */
    @Test
    public void whenTryAddSomeReproductFoodToReproductWarehouseShouldCheckThatIsWorksCorrect() {

        //Assign block
        ControlQualityReproduct control = new ControlQualityReproduct();
        control.addStorage(new ReproductWarehouse());
        Food food = new Apple("Apple", new GregorianCalendar(), new GregorianCalendar(), 100.55, 0);
        ReproductFood reproductFood = new ReproductFood(food, true);
        String expected = "At this moment at the reproduct warehouse: \n" +
                          "Name:Apple\n" +
                          "Was added: 24.07.2016\n" +
                          "Expair date: 24.07.2016\n" +
                          "Price: 100.55\n" +
                          "Discount: 0\n" +
                          "Can reproduct: true";

        //Action block
        control.moveFood(reproductFood);
        ReproductWarehouse warehouse = (ReproductWarehouse)control.getStorage(0);

        //Assert block
        assertThat(warehouse.toString(), is(expected));
    }
}
