package jcstress;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.infra.results.BooleanResult2;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.10.2016
 * This test case demo shared object problem.
 */
public class SharedObject {

    /**
     * Some object for testing.
     */
    public static class Shell {

        /**
         * It variable will changes.
         */
        private int value;

        /**
         * Default.
         */
        public Shell() {
            final int initValue = 100;
            this.value = initValue;
        }

        /**
         * Set value on to zero.
         */
        public void toZero() {
            final int change = 0;
            this.value = change;
        }

        /**
         * Return value.
         * @return value.
         */
        public int getValue() {
            return this.value;
        }
    }


    /**
     * Class for test case.
     */
    @org.openjdk.jcstress.annotations.State
    public static class State {

        /**
         * Instance of testing class.
         */
        private final Shell shell = new Shell();

        /**
         * Return shell.
         * @return instance of testing API.
         */
        public Shell getShell() {
            return this.shell;
        }
    }

    /**
     * It a stress test.
     */
    @JCStressTest
    @Description("This test show problem with concurrent programming at the Java. This problem named shared object")
    @Outcome(id = "true, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "right results")
    @Outcome(id = "false, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object condition detected")
    @Outcome(id = "true, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object problem detected")
    @Outcome(id = "false, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object problem detected")
    public static class TestOne {

        /**
         * At this place will be catch one thread.
         * @param state for change.
         * @param result at this place will put result.
         */
        @Actor
        public void actor1(State state, BooleanResult2 result) {
            final int hundred = 100;
            int valueBefore = state.shell.value;
            state.shell.toZero();
            result.r1 = (valueBefore == hundred) && (state.shell.value != hundred);

        }

        /**
         * At this place will be catch one thread.
         * @param state for change.
         * @param result at this place will put result.
         */
        @Actor
        public void actor2(State state, BooleanResult2 result) {
            final int hundred = 100;
            int value = state.shell.value;
            state.shell.toZero();
            result.r2 = (value == hundred && state.shell.value != hundred);
        }
    }
}
