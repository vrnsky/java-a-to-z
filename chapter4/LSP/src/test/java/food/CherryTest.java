package food;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Unit test for Cherry.java
 */
public class CherryTest {

    /**
     * Check that constructor works correct.
     */
    @Test
    public void whenCreateFoodObjectShouldCheckThatAllFieldAreCorrectFill() {

        //Assign block
        Food food = new Cherry("Cherry", new GregorianCalendar(), new GregorianCalendar(2016,11,18), 100.0, 0);
        String expected = "Name:Cherry\nWas added: 18.07.2016\nExpair date: 18.12.2016\nPrice: 100.0\nDiscount: 0";

        //Assert block
        assertThat(food.toString(), is(expected));
    }

    /**
     * When try to set discount for food should check that product save it.
     */
    @Test
    public void whenTryToSetDiscountShouldCheckThatIsWorkCorrect() {

        //Assign block
        Food food = new Cherry("Cherry", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
        int expected = 20;

        //Action block
        food.setDiscount(20);

        //Assert block
        assertThat(food.getDiscount(), is(expected));
    }

    /**
     * When try to get create time should check that is works correct.
     */
    @Test
    public void whenTryToGetCreateTimeShouldCheckThatIsWorksCorrect() {

        //Assign block
        Food food = new Cherry("Cherry", new GregorianCalendar(2016,6, 18), new GregorianCalendar(), 100.0, 0);
        String expected = "18.07.2016";

        //Action block
        String actual = food.getStringViewOfTime(food.getCreateTime());

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * When try get name of food should check that is correct name of food.
     */
    @Test
    public void whenTryGetNameOfFoodShouldCheckThatIsCorrectWorks() {

        //Assign block
        Food food = new Cherry("Chery", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
        String expected = "Chery";

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
        Food food = new Cherry("Chery", new GregorianCalendar(), new GregorianCalendar(), 100.0, 0);
        double expected = 100.0;

        //Action block
        double actual = food.getPrice();

        //Assert block
        assertThat(actual, is(expected));
    }
}
