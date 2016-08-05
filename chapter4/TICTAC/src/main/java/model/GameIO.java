package model;

import start.IO;


/**
 * Special IO system for game.
 */
public class GameIO {

    /**
     * Instance of io interface.
     */
    private IO io;

    /**
     * Create a new game io.
     * @param io instance of IO interface.
     */
    public GameIO(IO io) {
        this.io = io;
    }

    /**
     * Print at the io system question and return answer from user.
     * @param question
     * @return
     */
    public String ask(String question) {
        return this.io.ask(question);
    }

    /**
     * Println to user give value.
     * @param value object for print.
     */
    public void println(Object value) {
        this.io.println(value);
    }

    /**
     * Print at the current row.
     * @param value object for print.
     */
    public void print(Object value) {
        System.out.print(value);
    }

    /**
     * Ask user about some numbers and check that in correct range.
     * @param question it will show to user.
     * @param from start range.
     * @param to end range.
     * @return number for user.
     */
    public int ask(String question, int from, int to) {
        return this.io.ask(question,from, to);
    }
}
