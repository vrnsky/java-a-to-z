package ru.evrnsky.start;

/**
 * Implementation of validator, is handle bad and good input.
 * @author evrnsky <vrnsky@protonmail.ch>
 * @version 0.2
 */
public class Validator implements IO {

    /**
     * Message about using correct option.
     */
    private static final String USE_CORRECT_OPTION = String.format("%s",
            "Dear user, please choose correct options of menu");

    /**
     * Message about using number.
     */
    private static final String USE_NUMBER = "Dear user, please type a number";

    /**
     * Message about using a double.
     */
    private static final String USE_DOUBLE = "Dear user, please type a double!";

    /**
     * It is decorator pattern, use already created class.
     */
    private IO io;

    /**
     * Create a new validator.
     * @param io implementation of io interface.
     */
    public Validator(IO io) {
        this.io = io;
    }
    /**
     * Ask user about int and return it.
     * @param question - it is String which will show to user.
     * @param to       high point to range.
     * @param from     low point to range.
     * @return result of correct input.
     */
    @Override
    public final int ask(final String question, final int from, final int to) {
        int number = -1;
        boolean invalid = true;
        do {
            try {
                number = this.io.ask(question, from, to);
                if (number >= from && number <= to) {
                    invalid = false;
                }
            } catch (NumberFormatException nfe) {
                this.io.println("Dear user, please type a number");
            } catch (MenuOutException moe) {
                this.io.println(USE_CORRECT_OPTION);
            }
        } while (invalid);

        return number;
    }

    /**
     * Ask user about long and return it.
     * @param question will show to user.
     * @return result of correct input.
     */
    @Override
    public final long askForLong(final String question) {
        long result = -1;
        boolean invalid = true;
        do {
            try {
                result = this.io.ask(question, Integer.MIN_VALUE, Integer.MAX_VALUE);
                invalid = false;
            } catch (NumberFormatException nfe) {
                this.io.println(USE_NUMBER);
            }
        } while (invalid);
        return result;
    }

    /**
     * Return double number from user.
     * @param question - info for user.
     * @return double number from user input.
     */
    @Override
    public final double askForDouble(final String question) {
        double result = -1.00;
        boolean invalid = true;
        do {
            try {
                result = this.io.askForDouble(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                this.io.println(USE_DOUBLE);
            }
        } while (invalid);
        return result;
    }

    /**
     * Print object.
     * @param value for print.
     */
    @Override
    public void println(Object value) {
        this.io.println(value);
    }

    /**
     * Print string for user and return answer from user.
     * @param question info for user.
     * @return string which typed by user.
     */
    @Override
    public String ask(String question) {
        return this.io.ask(question);
    }

}
