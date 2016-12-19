package find;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for KeysValidator.java.
 * @author vrnsky
 * @version 0.1
 */
public class KeysValidatorTest {

    /**
     * When user give us key should check that is correct.
     */
    @Test
    public void whenTryUseCorrectKeyShouldKeyValidatorReturnATrue() {
        String[] keys = new String[]{"-d", "c:/", "-n", "*.txt", "-n", "-o", "log.txt"};
        KeysValidator keysValidator = new KeysValidator();

        boolean actual = keysValidator.isValidKeys(keys);

        assertThat(actual, is(true));
    }

    /**
     * When user give us bad key should show user hint and show which key is bad.
     */
    @Test
    public void whenTryUseWrongKeyShouldKeyValidatorReturnAFalse() {
        String[] keys = new String[]{"-g", "c:/", "-n", "*.txt", "-n", "-o", "log.txt"};
        KeysValidator keysValidator = new KeysValidator();

        boolean actual = keysValidator.isValidKeys(keys);

        assertThat(actual, is(false));

    }
}
