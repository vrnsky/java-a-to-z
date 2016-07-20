package food;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Avocado.java.
 */
public class AvocadoTest {

    /**
     * Check that constructor works correct.
     */
    @Test
    public void whenCreateAvocadoObjectShouldCheckThatAllFieldAreCorrectFill() {

        //Assign block
        Food food = new Avocado("Avocado", new GregorianCalendar(), new GregorianCalendar(2016,11,18), 100.0, 0);
        String expected = "Name:Avocado\nWas added: 18.07.2016\nExpair date: 18.12.2016\nPrice: 100.0\nDiscount: 0";

        //Assert block
        assertThat(food.toString(), is(expected));
    }

    /**
     * When try to set discount for food should check that product save it.
     */
    @Test
    public void whenTryToSetDiscountShouldCheckThatIsWorkCorrect() {

        //Assign block
        Food food = new Avocado("Avocado", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
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
    public void whenTryGetNameOfFoodShouldCheckThatIsCorrectWorks() {

        //Assign block
        Food food = new Avocado("Avocado", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
        String expected = "Avocado";

        //Action block
        String actual = food.getName();

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try get price for food should check that is correct price for food.
     */
    @Test
    public void whenTryGetPriceForFoodShouldCheckThatIsCorrectWorks() {

        //Assign block
        Food food = new Avocado("Avocado", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
        double expected = 100.0;

        //Action block
        double actual = food.getPrice();

        //Assert block
        assertThat(actual, is(expected));
    }
}