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

    private class Cosinus extends BaseAction {

        Cosinus(String name) {
            super(name);
        }


        @Override
        public int key() {
            return 4;
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

        Sinus(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 5;
        }

        /**
         * Execute sinus operation.
         * @param io instance of IO interface.
         */
        @Override
        public void execute(IO io) {
            double number = io.askForDouble("Enter a number for sin operation: ");
            calculator.sin(number);
            io.println(String.format("sin(%s) = %s", number, calculator.getResult()));
        }
    }

    /**
     * Log by 10 found operation.
     */
    private class Log extends BaseAction {

        Log(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 6;
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

        Abs(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 7;
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
