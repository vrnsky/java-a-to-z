package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.BooleanResult2;

/**
 * @author evrnsky
 * @version 0.1
 * @since 09.10.2016
 */
public class SharedObject {

    public static class Shell {
        int value;

        public Shell() {
            this.value = 100;
        }


        public void toZero() {
            this.value = 0;
        }
    }

    @org.openjdk.jcstress.annotations.State
    public static class State {
        public final Shell shell = new Shell();
    }

    @JCStressTest
    @Description("This test show problem with concurrent programming at the Java. This problem named shared object")
    @Outcome(id="true, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "right results")
    @Outcome(id="false, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object condition detected")
    @Outcome(id="true, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object problem detected")
    @Outcome(id="false, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "shared object problem detected")
    public static class TestOne {

        @Actor
        public void actor1(State state, BooleanResult2 result) {
            int valueBefore = state.shell.value;
            state.shell.toZero();
            result.r1 = (valueBefore == 100) && (state.shell.value != 100);

        }

        @Actor
        public void actor2(State state, BooleanResult2 result) {
            int value = state.shell.value;
            state.shell.toZero();
            result.r2 = (value == 100 && state.shell.value != 100);
        }
    }
}
