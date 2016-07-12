package summ;


import start.*;
/**
 * Addition two integers.
 */
public class Addition {

    /**
     * Instance of io for input and output data.
     */
    private IO io;

    /**
     * Construct addition class by give it instance of io interface.
     * @param io - instance of IO interface.
     */
    public Addition(IO io) {
        this.io = io;
    }

    /**
     * Ask user about two integers and sum it.
     * @return return sum of two integers which get from user.
     */
    public int add() {
        int numberOne = this.io.ask("Enter a first number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int numberTwo = this.io.ask("Enter a second number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int result = numberOne + numberTwo;
        this.io.println(result);
        return result;
    }

}
