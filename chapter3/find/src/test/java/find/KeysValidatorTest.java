package find;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for KeysValidator.java.
 */
public class KeysValidatorTest {

    /**
     * When user give us key should check that is correct.
     */
    @Test
    public void whenTryUseCorrectKeyShouldKeyValidatorReturnATrue() {

        //Assign block
        String[] keys = new String[]{"-d", "c:/", "-n", "*.txt", "-n", "-o", "log.txt"};
        KeysValidator keysValidator = new KeysValidator();
        boolean expected = true;

        //Act block
        boolean actual = keysValidator.isValidKeys(keys);

        //Action block
        assertThat(actual, is(expected));
    }

    /**
     * When user give us bad key should show user hint and show which key is bad.
     */
    @Test
    public void whenTryUseWrongKeyShouldKeyValidatorReturnAFalse() {

        //Assign block
        String[] keys = new String[]{"-g", "c:/", "-n", "*.txt", "-n", "-o", "log.txt"};
        KeysValidator keysValidator = new KeysValidator();

        //Act block
        boolean actual = keysValidator.isValidKeys(keys);

        //Action block
        assertThat(actual, is(false));

    }
}
