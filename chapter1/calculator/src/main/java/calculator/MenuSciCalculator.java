package calculator;

import start.IO;
import templates.BaseAction;

/**
 * More complex calculator.
 */
public class MenuSciCalculator extends MenuCalculator {

    /**
     * Create a new scientific calculator.
     * @param calculator instance of calculator API.
     * @param io system for handling input and show data.
     * @param size of possible actions.
     */
    public MenuSciCalculator(Calculator calculator, IO io, int size) {
        super(calculator, io, size);
    }

    /**
     * Call this method before start invoke method select.
     * Add all action from parent and add new actions.
     */
    @Override
    public void fillActions() {
        super.fillActions();
        super.addAction(new Cosinus("Cos"));
        super.addAction(new Sinus("Sin"));
        super.addAction(new Log("Log"));
        super.addAction(new Abs("Abs"));

    }

    /**
     * Cosin action.
     */
    private class Cosinus extends BaseAction {

        /**
         * Unique number of action.
         */
        private final int key = 4;

        /**
         * Create cosin operation.
         * @param name of action.
         */
        Cosinus(String name) {
            super(name);
        }

        /**
         * Return unique number among all actions.
         * @return unique number.
         */
        @Override
        public int key() {
            return key;
        }

        /**
         * Execute cosinus operation.
         * @param io instance of io system.
         */
        @Override
        public void execute(IO io) {
            double number = io.askForDouble("Enter a number for cos operation: ");
            calculator.cos(number);
            io.println(String.format("cos(%s) = %s", number, calculator.getResult()));
        }
    }

    /**
     * Instance of sinus operation.
     */
    private class Sinus extends BaseAction {

        /**
         * Unique key.
         */
        private final int  key = 5;

        /**
         * Create sinus operation.
         * @param name of action.
         */
        Sinus(String name) {
            super(name);
        }

        /**
         * Return unique number among actions.
         * @return unique number.
         */
        @Override
        public int key() {
            return key;
        }

        /**
         * Execute sinus operation.
         * @param inOut instance of IO interface.
         */
        @Override
        public void execute(IO inOut) {
            double number = io.askForDouble("Enter a number for sin operation: ");
            calculator.sin(number);
            io.println(String.format("sin(%s) = %s", number, calculator.getResult()));
        }
    }

    /**
     * Log by 10 found operation.
     */
    private class Log extends BaseAction {


        /**
         * Unique number among all actions.
         */
        private final int key = 6;


        /**
         * Create log action.
         * @param name of action.
         */
        Log(String name) {
            super(name);
        }

        /**
         * Return unique number among all actions.
         * @return unique number.
         */
        @Override
        public int key() {
            return key;
        }

        /**
         * Calculate decimal log.
         * @param io instance of IO interface.
         */
        @Override
        public void execute(IO io) {
            double number = io.askForDouble("Enter a number for log 10 operation: ");
            calculator.log(number);
            io.println(String.format("log10(%s) = %s", number, calculator.getResult()));
        }
    }

    /**
     * Abs operation.
     */
    private class Abs extends BaseAction {

        /**
         * Unique key.
         */
        private final int key = 7;

        /**
         * Create absolute action.
         * @param name of action.
         */
        Abs(String name) {
            super(name);
        }

        /**
         * Return unqiue string among all actions.
         * @return unique string.
         */
        @Override
        public int key() {
            return key;
        }

        /**
         * Execute abs operation.
         * @param io instance of io system.
         */
        @Override
        public void execute(IO io) {
            double number = io.askForDouble("Enter a number for abs operation: ");
            calculator.abs(number);
            io.println(String.format("abs(%s) = %s", number, calculator.getResult()));
        }
    }
}
