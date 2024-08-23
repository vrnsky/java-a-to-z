package ru.evrnsky.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Egor on 13.08.2016.
 */
class MenuTest {

    /**
     * Instance of testing.
     */
    private Menu menu;

    /**
     * Before each test.
     */
    @BeforeEach
    public void setUp() {
        this.menu = new Menu();
    }

    /**
     * Sum.
     */
    @Test
    void whenTryAddTwoIntegerShouldCheckThatAppReturnCorrectAnswer() {

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
    void whenTryDeductOneIntegerFromOtherIntegerShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 1;
        int actual = menu.calculate("-", 100, 99);
        assertThat(actual, is(expected));
    }

    /**
     * Multiply.
     */
    @Test
    void whenTryMultiplyTwoNumbersShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 10;
        int actual = menu.calculate("*", 5, 2);
        assertThat(actual, is(expected));
    }

    /**
     * Division.
     */
    @Test
    void whenTryDivOneIntegerByOtherNotNullIntegerShouldCheckThatAppReturnCorrectAnswer() {
        int expected = 10;
        int actual = menu.calculate("/", 100, 10);
        assertThat(actual, is(expected));
    }

    /**
     * Bad division.
     */
    @Test
    void whenTryDivOneIntegerByZeroShouldCheckThatAppThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> menu.calculate("/", 100, 0));
    }
}
