package food;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Unit test for ReproductFood.java
 */
public class ReproductFoodTest {
    /**
     * Check that constructor works correct.
     */
    @Test
    public void whenCreateReproductFoodObjectShouldCheckThatAllFieldAreCorrectFill() {

        //Assign block
        Food food = new ReproductFood("Reproduct", new GregorianCalendar(2016, 6, 18), new GregorianCalendar(2016,11,18), 100.0, 0, true);
        String expected = "Name:Reproduct\n" +
                          "Was added: 18.07.2016\n" +
                          "Expair date: 18.12.2016\n" +
                          "Price: 100.0\n" +
                          "Discount: 0\n" +
                          "Can reproduct: true";

        //Assert block
        assertThat(food.toString(), is(expected));
    }

    /**
     * When try to set discount for food should check that product save it.
     */
    @Test
    public void whenTryToSetDiscountShouldCheckThatIsWorkCorrect() {

        //Assign block
        Food food = new ReproductFood("Reproduct", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0, true);
        int expected = 20;

        //Action block
        food.setDiscount(20);

        //Assert block
        assertThat(food.getDiscount(), is(expected));
    }


    /**
     * When try get name of food should check that is correct name of food.
     */
    @Test
    public void whenTryGetNameOfAppleShouldCheckThatIsCorrectWorks() {

        //Assign block
        Food food = new ReproductFood("Reproduct", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0, true);
        String expected = "Reproduct";

        //Action block
        String actual = food.getName();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try get price for food should check that is correct price for food.
     */
    @Test
    public void whenTryGetPriceForReproductFoodShouldCheckThatIsCorrectWorks() {

        //Assign block
        Food food = new ReproductFood("Reproduct", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0, true);
        double expected = 100.0;

        //Action block
        double actual = food.getPrice();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * Check that flag reproduct works correct.
     */
    @Test
    public void whenTryGetCanReproductFlagShouldCheckThatIsCorrectFlag() {

        //Assign block
        Food food = new ReproductFood("Reproduct", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0, true);
        //Action block
        ReproductFood reproductFood =(ReproductFood)food;
        boolean actual = reproductFood.getRecovery();

        //Assert block
        assertThat(actual, is(true));

    }

    /**
     * Check that flag can reproduct works correct.
     */
    @Test
    public void whenTrySetCanReproductFlagShouldCheckThatFoodSaveIt() {

        //Assign block
       Food food = new ReproductFood("Reproduct", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0, true);

       //Action block
       ReproductFood reproductFood =(ReproductFood)food;
       reproductFood.setRecovery(false);
       boolean actual = reproductFood.getRecovery();

       //Assert block
       assertThat(actual, is(false));
    }

}
