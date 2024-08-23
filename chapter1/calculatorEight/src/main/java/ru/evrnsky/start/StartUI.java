package ru.evrnsky.start;
import ru.evrnsky.model.Menu;


/**
 * UI for calculator, it accept data from user and call to the Calculator across the wrapper.
 */
public class StartUI {

    /**
     * Instance of io interface.
     */
    private IO io;

    /**
     * Create a new ui with given io implementation.
     * @param io implementation of io interface.
     */
    public StartUI(IO io) {
        this.io = io;
    }

    /**
     * Entry point of application.
     * @param args input params.
     */
    public static void main(String[] args)  {
        new StartUI(new ConsoleIO()).init();
    }

    /**
     * Main program loop.
     */
    public void init() {
        Menu menu = new Menu();
        do {
            String operand = this.io.ask("Enter a operand: ");
            int one = this.io.ask("Enter a first number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int two = this.io.ask("Enter a second number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int result = menu.calculate(operand, one, two);
            this.io.println(String.format("%s %s %s = %s", one, operand, two, result));
        } while (!"y".equals(this.io.ask("Exit now ? (y/n)")));
    }
}
