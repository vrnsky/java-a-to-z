package real;

import start.IO;
import static java.lang.Math.abs;

/**
 * Find min at the three double values
 */
public class Real {

    /**
     * Instance of IO interface for handle user input and output
     */
    private IO io;

    /**
     * Create object with instance of io for handle io
     * @param io - instance of io
     */
    public Real(IO io) {
        this.io = io;
    }

    /**
     * Ask user about double three times and find at its min abs value
     * @return - min value in three double values
     */
    public double getMin() {
        double min = Double.MIN_VALUE;
        double one = this.io.askForDouble("Enter a double number: ");
        double two = this.io.askForDouble("Enter a double number: ");
        double three = this.io.askForDouble("Enter a double number: ");
        min = findMinimum(one,two,three);
        this.io.println(min);
        return min;
    }

    /**
     * Find min value in three double value and return it
     * In method uses modules of numbers
     * @param one - first double from user
     * @param two - second double from user
     * @param three - third double from user
     * @return - min value among three double
     */
    private double findMinimum(double one, double two, double three) {
        double min = 0.00;
        double absOne = abs(one);
        double absTwo = abs(two);
        double absThree = abs(three);

        if(absOne < absTwo && absOne < absThree)
            min = one;
        else if(absTwo < absOne && absTwo < absThree)
            min = two;
        else if(absThree < absOne && absThree < absOne)
            min = three;
        return min;
    }

}
