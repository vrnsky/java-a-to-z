package task;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Substring.java.
 * It must check that one of string is substring for other.
 */
public class SubstringTest {

	/**
	 * Instance of testing class.
	 */
	private Substring substr;

	/**
	 * Init instance of testing class, it extract to there to reduce code in test.
	 */
	@Before
	public void setUp() {
		substr = new Substring();
	}

	/**
	 * When call isSubstring method from instance of substring class and given to it correct string
	 * should check that method isSubstring return true.
	 */
	@Test
	public void whenCallIsSubstringMethodFromSubtringAndPassTwoCorrectStringShouldReturnTrue() {
		//Assign block
		String fullString = "Hello";
		String partString = "el";

		//Act block
		boolean result = substr.isSubstring(fullString, partString);

		//Action block
		assertThat(result, is(true));
	}

	/**
	 * When call is substring method from instance of Substring class and given it bad strings
	 * Should check that is substring method return false.
	 */
	@Test
	public void whenCallIsSubtringMethodFromSubstringAndWrongArgumentShouldReturnFalse() {
		//Assign block
		String fullString = "Bad string";
		String partString = "q";

		//Act block
		boolean result = substr.isSubstring(fullString, partString);

		//Action block
		assertThat(result, is(false));
	}
}