package model;

import org.junit.Ignore;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for demo how to work garbage collection.
 * There is ignored test, because it especially machine specific test.
 * You should configure JVM properly for this test
 */
@Ignore
public class StarterTest {

    /**
     * When try call finalize method should check that object print.
     * @throws Throwable if some error happens.
     */
    @Test
    public void whenTryFinalizeUserShouldCheckThatInConsolePrintInfo() throws Throwable {
        Starter.User usr = new Starter.User("Yegor", "Voronyansky", 20);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        usr.finalize();
        assertThat(outputStream.toString(), containsString(String.format("%s%s", "User object was removed", System.getProperty("line.separator"))));
    }

    /**
     * When try call try gc method should check that one as min object has removed.
     */
    @Test
    public void whenTryCallGcMethodShouldCheckThatAsMinGarbageCollectionRemoveOneObject() {
        Starter starter = new Starter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        starter.tryGC();
        assertThat(out.toString(), containsString("User object was removed"));
    }

    /**
     * When try call method main should check that other part starts.
     */
    @Test
    public void whenTryCallMethodMainShouldCheckThatAllIsOk() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Starter.main(new String[]{"key", "key"});
        assertThat(out.toString(), containsString("User object was removed"));
    }
}