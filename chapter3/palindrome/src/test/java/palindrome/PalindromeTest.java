package palindrome;

import org.junit.Test;
import start.StubIO;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for Palindrome.java.
 */
public class PalindromeTest {

    /**
     * When user entered a correct word (correct means than
     * it is not empty and have five letter),
     * should check that it is palindrome.
     */
    @Test
    public void whenUserEnterCorrectWordShouldCheckThatItIsPalindrome() {
        String[] answer = new String[]{"Rotor"};
        StubIO stubIO = new StubIO(answer);
        Palindrome palindrome = new Palindrome(stubIO);

        boolean actual = palindrome.isPalindrome();

        assertThat(actual, is(true));
    }

    /**
     * When user add type a wrong word should check that app return false.
     */
    @Test
    public void whenUserEnterWrongWordShouldCheckThatIsNotPalindrome() {
        String[] answer = new String[]{"Vasya"};
        StubIO io = new StubIO(answer);
        Palindrome palindrome = new Palindrome(io);

        boolean actual = palindrome.isPalindrome();

        assertThat(actual, is(false));
    }

    /**
     * When user entered wrong(wrong means than is it may
     * be empty or have more or small letters than five),
     * should show user that it wrong data.
     */
    @Test
    public void whenUserEnterWrongWordShouldShowUserThatHeMadeMistake() {
        String[] answer = new String[]{"asd", "rotor"};
        StubIO stubIO = new StubIO(answer);
        Palindrome palindrome = new Palindrome(stubIO);
        String expected = "You made mistake: in words must be 5 letters";
        palindrome.isPalindrome();

        assertThat(stubIO.getOut(), containsString(expected));
    }


}
