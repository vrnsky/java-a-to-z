package food;

import org.joda.time.DateTime;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Apple.java.
 */
public class AppleTest {

    /**
     * Check that constructor works correct.
     */
    @Test
    public void whenCreateAppleObjectShouldCheckThatAllFieldAreCorrectFill() {
        Food food = new Apple("Apple", new DateTime(2016, 7, 18, 0, 0, 0), new DateTime(2016, 12, 18, 0, 0, 0), 100.0, 0);
        String expected = "Name:Apple\nWas added: 18.07.2016\nExpair date: 18.12.2016\nPrice: 100.0\nDiscount: 0";

        assertThat(food.toString(), is(expected));
    }

    /**
     * When try to set discount for food should check that product save it.
     */
    @Test
    public void whenTryToSetDiscountShouldCheckThatIsWorkCorrect() {
        Food food = new Apple("Apple", new DateTime(), new DateTime(), 100.0, 0);
        int expected = 20;

        food.setDiscount(20);

        assertThat(food.getDiscount(), is(expected));
    }


    /**
     * When try get name of food should check that is correct name of food.
     */
    @Test
    public void whenTryGetNameOfAppleShouldCheckThatIsCorrectWorks() {

        Food food = new Apple("Apple", new DateTime(), new DateTime(), 100.0, 0);
        String expected = "Apple";

        String actual = food.getName();

        assertThat(actual, is(expected));
    }

    /**
     * When try get price for food should check that is correct price for food.
     */
    @Test
    public void whenTryGetPriceForAppleShouldCheckThatIsCorrectWorks() {
        Food food = new Apple("Apple", new DateTime(), new DateTime(), 100.0, 0);
        double expected = 100.0;

        double actual = food.getPrice();

        assertThat(actual, is(expected));
    }
}

