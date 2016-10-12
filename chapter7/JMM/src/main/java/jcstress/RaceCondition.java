package jcstress;


import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.BooleanResult2;
import org.openjdk.jcstress.infra.results.BooleanResult4;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.10.2016
 */
public class RaceCondition {


    @org.openjdk.jcstress.annotations.State
    public static class MyState {
        public final Counter counter = new Counter();
    }


    @JCStressTest
    @Outcome(id = "true, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "all is ok")
    @Outcome(id = "false, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "race detect")
    public static class StressTest {

        @Actor
        public void actor1(MyState state) {
            state.counter.incrementTwice();
        }

        @Actor
        public void actor2(MyState state) {
            state.counter.incrementTwice();
        }

        @Arbiter
        public void arbiter(MyState state, BooleanResult2 result) {
            result.r1 = state.counter.count == 5;
            result.r2 = state.counter.count != 5;
        }
    }
    public static class Counter {
        int count;

        public Counter() {
            this.count = 0;
        }

        public void incrementTwice() {
            this.count++;
            this.count++;
        }
    }
}