package model;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Egor on 13.08.2016.
 */
public class MenuTest {

    private Menu menu;

    @Before
    public void setUp() {
        this.menu = new Menu();
    }

    @Test
    public void whenTryAddTwoIntegerShouldCheckThatAppReturnCorrectAnswer() {

        //Assign block
        int expected = 10;

        //Action block
        int actual = menu.calculate("+", 5,5);

        //Assert block
        assertThat(actual, is(expected));
    }

    @Test
    public void whenTryDeductOneIntegerFromOtherIntegerShouldCheckThatAppReturnCorrectAnswer() {

        //Assign block
        int expected = 1;

        //Action block
        int actual = menu.calculate("-", 100,99);

        //Assert block
        assertThat(actual, is(expected));
    }

    @Test
    public void whenTryMultiplyTwoNumbersShouldCheckThatAppReturnCorrectAnswer() {

        //Assign block
        int expected = 10;

        //Action block
        int actual = menu.calculate("*", 5, 2);

        //Assert block
        assertThat(actual, is(expected));

    }

    @Test
    public void whenTryDivOneIntegerByOtherNotNullIntegerShouldCheckThatAppReturnCorrectAnswer() {

        //Assign block
        int expected = 10;

        //Action block
        int actual = menu.calculate("/", 100, 10);

        //Assert block
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryDivOneIntegerByZeroShouldCheckThatAppThrowException() {

        //Assign block
        int expected = 1;

        //Action block
        int actual= menu.calculate("/", 100, 0);
    }
}
