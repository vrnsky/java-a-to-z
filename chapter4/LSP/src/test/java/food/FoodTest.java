package food;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Food.java.
 * It is testing correct fill fields of food model.
 */
class FoodTest {


    /**
     * Check that constructor works correct.
     */
    @Test
    void whenCreateFoodObjectShouldCheckThatAllFieldAreCorrectFill() {
        Food food = new Food("Food", new DateTime(2016, 7, 18, 0, 0, 0), new DateTime(2016, 12, 18, 0, 0, 0), 100.0, 0);
        String expected = "Name:Food\nWas added: 18.07.2016\nExpair date: 18.12.2016\nPrice: 100.0\nDiscount: 0";

        assertThat(food.toString(), is(expected));
    }

    /**
     * When try to set discount for food should check that product save it.
     */
    @Test
    void whenTryToSetDiscountShouldCheckThatIsWorkCorrect() {
        Food food = new Food("Food", new DateTime(), new DateTime(), 100.0, 0);
        int expected = 20;

        food.setDiscount(20);

        assertThat(food.getDiscount(), is(expected));
    }

    /**
     * When try getting name of food should check that is correct name of food.
     */
    @Test
    void whenTryGetNameOfFoodShouldCheckThatIsCorrectWorks() {

        Food food = new Food("food", new DateTime(), new DateTime(), 100.0, 0);
        String expected = "food";

        String actual = food.getName();

        assertThat(actual, is(expected));
    }

    /**
     * When try get price for food should check that is correct price for food.
     */
    @Test
    void whenTryGetPriceForFoodShouldCheckThatIsCorrectWorks() {
        Food food = new Food("food", new DateTime(), new DateTime(), 100.0, 0);
        double expected = 100.0;

        double actual = food.getPrice();

        assertThat(actual, is(expected));
    }
}
