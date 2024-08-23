package ru.evrnsky.start;

/**
 * It is stub for testing user input/output.
 */
public class StubIO implements IO {

    /**
     * List of possible input from user.
     */
    private String[] answer;

    /**
     * For correct move across answer array.
     */
    private int position = 0;

    /**
     * For collect data which produce application.
     */
    private StringBuffer buffer;

    /**
     * Constructor for this class.
     * @param answerValues list of possible answers.
     */
    public StubIO(final String[] answerValues) {
        this.answer = answerValues;
        this.buffer = new StringBuffer();
    }

    /**
     * Show user question and return user input.
     * @param question string which show user.
     * @return string given from user.
     */
    @Override
    public String ask(final String question) {
        return answer[position++];
    }

    /**
     * Ask user about int and check number for range.
     * @param question question which show user.
     * @param from     start for range.
     * @param to       finish for range.
     * @return number which exist between from and to.
     */
    @Override
    public int ask(final String question, final int from, final int to) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        if (key >= from && key <= to) {
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
     * @param question show to user.
     * @return result of correct input.
     */
    @Override
    public long askForLong(final String question) {
        return Long.valueOf(this.ask(question));
    }

    /**
     * Ask user about double and return it.
     * @param question - info for user.
     * @return double which get from user.
     */
    @Override
    public double askForDouble(final String question) {
        return Double.valueOf(this.ask(question));
    }

    /**
     * Append to buffer value and move to new line.
     * @param value object for append.
     */
    @Override
    public void println(final Object value) {
        this.buffer.append(value + "\n");
    }

    /**
     * Return a buffer data.
     * @return all data from buffer
     */
    public final String getOut() {
        return buffer.toString();
    }
}
