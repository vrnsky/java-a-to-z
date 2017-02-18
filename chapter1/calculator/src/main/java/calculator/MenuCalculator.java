package calculator;

import start.IO;
import templates.BaseAction;
import templates.UserAction;

/**
 * Menu for Calculator it handle all query to calculator.
 */
public class MenuCalculator {

    /**
     * First command.
     */
    private static final int FIRST_COMMAND = 0;

    /**
     * Instance of calculator API.
     */
    protected final Calculator calculator;

    /**
     * Instance of IO system.
     */
    protected IO io;

    /**
     * For correct adding new operation.
     */
    protected int position = 0;

    /**
     * All possible action which make controllers.
     */
    protected UserAction[] actions;

    /**
     * Create a new menu.
     * @param calc instance of calculator API.
     * @param inOut instance of IO system, for handling input and show data.
     * @param size of possible user actions.
     */
    public MenuCalculator(final Calculator calc, IO inOut, int size) {
        this.calculator = calc;
        this.io = inOut;
        this.actions = new UserAction[size];
    }

    /**
     * Fill actions array.
     */
    public void fillActions() {
        actions[position++] = new Addition("Add");
        actions[position++] = new Deduct("Deduct");
        actions[position++] = new Multiply("Multiply");
        actions[position++] = new Divide("Divide");
    }

    /**
     * For correct adding new action use this method.
     * @param userAction instance of user interface.
     */
    public void addAction(UserAction userAction) {
        actions[position++] = userAction;
    }

    /**
     * This show menu to user by using io system.
     */
    public void showMenu() {
        for (UserAction action : actions) {
            if (action != null) {
                this.showItem(action);
            }
        }
    }

    /**
     * Show item.
     * @param action any actions from actions list.
     */
    private void showItem(UserAction action) {
        this.io.println(action.info());
    }

    /**
     * Find and execute action from actions array.
     * @param index number of action in actions array.
     */
    public void select(int index) {
        this.actions[index].execute(this.io);
    }

    /**
     * Return id of first command.
     * @return id first command.
     */
    public int getIdFirstCommand() {
        return FIRST_COMMAND;
    }

    /**
     * Return id of last command.
     * @return id last command.
     */
    public int getIdLastCommand() {
        return position;
    }

    /**
     * Addition operation.
     */
    private class Addition extends BaseAction {

        /**
         * Key of action.
         */
        private  final int key = 0;

        /**
         * Create addition action.
         * @param name of action.
         */
        Addition(String name) {
            super(name);
        }

        @Override
        public int key() {
            return key;
        }

        /**
         * Execute addition operation.
         * @param inOut instance of io system.
         */
        @Override
        public void execute(IO inOut) {
            double number = io.askForDouble("Enter a first number: ");
            double add = calculator.getPrevResult();
            calculator.add(number);
            io.println(String.format("%s %s %s = %s", add, "+", number, calculator.getResult()));
        }
    }

    /**
     * Deduct operation.
     */
    private class Deduct extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 1;

        /**
         * Create deduct action.
         * @param name of action.
         */
        Deduct(String name) {
            super(name);
        }

        /**
         * Unique number per action.
         * @return unique number among all actions.
         */
        @Override
        public int key() {
            return key;
        }

        /**
         * Execute deduct.
         * @param inOut instance of io interface.
         */
        public void execute(IO inOut) {
            double number = io.askForDouble("Enter a first number: ");
            double extract = calculator.getPrevResult();
            calculator.deduct(number);
            io.println(String.format("%s %s %s = %s", extract, "-", number, calculator.getResult()));
        }
    }

    /**
     * Multiply operation.
     */
    private class Multiply extends BaseAction {

        /**
         * Key of action.
         */
        private final int key = 2;

        /**
         * Create multiply action.
         * @param name of action.
         */
        Multiply(String name) {
            super(name);
        }

        @Override
        public int key() {
            return key;
        }

        /**
         * Execute a multiply operation.
         * @param inOut instance of io system.
         */
        public void execute(IO inOut) {
            double number = io.askForDouble("Enter a number: ");
            double factor = calculator.getPrevResult();
            calculator.multiply(number);
            io.println(String.format("%s %s %s = %s", factor, "*", number, calculator.getResult()));
        }
    }

    /**
     * Divide operation.
     */
    private class Divide extends BaseAction {

        /**
         * Name of action.
         */
        private final int key = 3;

        /**
         * Create divide action.
         * @param name of action.
         */
        Divide(String name) {
            super(name);
        }

        @Override
        public int key() {
            return key;
        }

        /**
         * Execute divide.
         * @param inOut - instance of io system.
         */
        @Override
        public void execute(IO inOut) {
            double number = io.askForDouble("Enter a first number: ");
            double divisor = calculator.getPrevResult();
            calculator.div(number);
            io.println(String.format("%s %s %s = %s", divisor, "/", number, calculator.getResult()));
        }
    }
}
