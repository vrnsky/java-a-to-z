package start;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * This class acceptance data from console.
 */
public class ConsoleIO implements IO {

    /**
     * For reading data from console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * For write data to console.
     */
    private PrintStream out = new PrintStream(System.out);

    /**
     * Show user console ask and return data from user.
     * @param question show to user.
     * @return string given from user.
     */
    @Override
    public String ask(final String question) {
        this.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Ask user about int and ranged it.
     * @param question - it is string which will show to user.
     * @param a        low point to range.
     * @param b        high point to range.
     * @return result of user input if correct input, otherwise throw exception
     * @throws MenuOutException - signal user choose wrong menu options.
     */
    @Override
    public int ask(final String question, final int a, final int b) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        if (key >= a && key <= b) {
            exist = true;
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

    /**
     * Ask user about long and return it.
     * @param question which will show to user.
     * @return long result - it result of correct input
     */
    @Override
    public long askForLong(final String question) {
        return Long.valueOf(this.ask(question));
    }


    /**
     * Ask user about double and return it.
     * @param question which will show to user.
     * @return long result - it result of correct input
     */
    @Override
    public double askForDouble(final String question) {
        return Double.valueOf(this.ask(question));
    }

    /**
     * Show string view of object.
     * @param value object for print.
     */

    @Override
    public void println(final Object value) {
        this.out.println(value);
    }
}
