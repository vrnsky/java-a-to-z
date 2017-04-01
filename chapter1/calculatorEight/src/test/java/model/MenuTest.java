package model;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Egor on 13.08.2016.
 */
public class MenuTest {

    /**
     * Instance of testing.
     */
    private Menu menu;

    /**
     * Before each test.
     */
    @Before
    public void setUp() {
        this.menu = new Menu();
    }

    /**
     * Sum.
     */
    @Test
    public void whenTryAddTwoIntegerShouldCheckThatAppReturnCorrectAnswer() {

        //Assign block
        int expected = 10;

        //Action block
        int actual = menu.calculate("+", 5, 5);

        //Assert block
        assertThat(actual, is(expected));
    }

    /**
     * Deduct.
     */
    @Test
    public void whenTryDeductOneIntegerFromOtherIntegerShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 1;
        int actual = menu.calculate("-", 100, 99);
        assertThat(actual, is(expected));
    }

    /**
     * Multiply.
     */
    @Test
    public void whenTryMultiplyTwoNumbersShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 10;
        int actual = menu.calculate("*", 5, 2);
        assertThat(actual, is(expected));
    }

    /**
     * Division.
     */
    @Test
    public void whenTryDivOneIntegerByOtherNotNullIntegerShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 10;
        int actual = menu.calculate("/", 100, 10);
        assertThat(actual, is(expected));
    }

    /**
     * Bad division.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryDivOneIntegerByZeroShouldCheckThatAppThrowException() {
        int expected = 1;
        int actual = menu.calculate("/", 100, 0);
    }
}
