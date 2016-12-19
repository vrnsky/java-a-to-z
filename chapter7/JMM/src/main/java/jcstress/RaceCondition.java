package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.BooleanResult2;

/**
 * @author evrnsky
 * @version 0.1
 * @since 11.10.2016
 * This test case demo race condition problem.
 */
public class RaceCondition {


    /**
     * Init state.
     */
    @State
    public static class MyState {
        /**
         * Instance of testing API.
         */
        private final Counter counter = new Counter();

        /**
         * Return instance of counter.
         * @return instance of counter.
         */
        public Counter getCounter() {
            return this.counter;
        }
    }

    /**
     * Some test.
     */
    @JCStressTest
    @Description("Show problem with concurrency")
    @Outcome(id = "true, false", expect = Expect.ACCEPTABLE_INTERESTING, desc = "all is ok")
    @Outcome(id = "false, true", expect = Expect.ACCEPTABLE_INTERESTING, desc = "race detect")
    public static class StressTest {

        /**
         * At this method may execute by one thread.
         * @param state it will change at the proccess of thread execution.
         */
        @Actor
        public void actor1(MyState state) {
            state.getCounter().incrementTwice();
        }

        /**
         * At this method may execute by one thread.
         * @param state it will change at the proccess of thread execution.
         */
        @Actor
        public void actor2(MyState state) {
            state.getCounter().incrementTwice();
        }

        /**
         * Compare result.
         * @param state instance of state class.
         * @param result at this storage put result.
         */
        @Arbiter
        public void arbiter(MyState state, BooleanResult2 result) {
            final int max = 5;
            final int min = 1;
            result.r1 = state.getCounter().getCount() == max;
            result.r2 = state.getCounter().getCount() >= min && state.getCounter().getCount() < max;
        }
    }

    /**
     * Simple counter.
     */
    public static class Counter {

        /**
         * Counter.
         */
        private int count;

        /**
         * Default constructor.
         */
        public Counter() {
            this.count = 0;
        }

        /**
         * Increment twice. It is not atomic operation.
         */
        public void incrementTwice() {
            this.count++;
            this.count++;
        }

        /**
         * Return count of counter.
         * @return count.
         */
        public int getCount() {
            return this.count;
        }
    }
}