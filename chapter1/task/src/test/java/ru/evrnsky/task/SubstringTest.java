package ru.evrnsky.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Substring.java.
 * It must check that one of string is substring for other.
 */
class SubstringTest {

    /**
     * Instance of testing class.
     */
    private Substring substr;

    /**
     * Init instance of testing class, it extract to there to reduce code in test.
     */
    @BeforeEach
    public void setUp() {
        substr = new Substring();
    }

    /**
     * When call isSubstring method from instance of substring class and given to it correct string
     * should check that method isSubstring return true.
     */
    @Test
    void whenCallIsSubstringMethodFromSubstringAndPassTwoCorrectStringShouldReturnTrue() {
        String fullString = "Hello";
        String partString = "el";

        boolean result = substr.isSubstring(fullString, partString);

        Assertions.assertTrue(result);
    }

    /**
     * When call is substring method from instance of Substring class and given it bad strings
     * Should check that is substring method return false.
     */
    @Test
    void whenCallIsSubstringMethodFromSubstringAndWrongArgumentShouldReturnFalse() {
        String fullString = "Bad string";
        String partString = "q";

        boolean result = substr.isSubstring(fullString, partString);

        Assertions.assertFalse(result);
    }

    /**
     * When call is substring method and sub string greater than original should check that false.
     */
    @Test
    void whenCallIsSubstringMethodAndSubstringGreaterThatOriginalShouldCheckThatFalseReturned() {
        String fullString = "String";
        String partString = "Good evening";

        boolean result = substr.isSubstring(fullString, partString);

        Assertions.assertFalse(result);
    }
}