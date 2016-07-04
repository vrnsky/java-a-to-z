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


    private double currentMin = Double.MAX_VALUE;
    private String userValue;

    /**
     * Ask user about double while he don't type empty string
     * Find min from all input doubles
     * @return - min value in three double values
     */
    public double getMin() {
      double resultMin = 0.0;
      while(!"".equalsIgnoreCase(userValue = this.io.ask("Enter a double"))) {
          try {
              resultMin = this.updateMinimumOrNot(Double.parseDouble(userValue));
              currentMin = resultMin;
          } catch(NumberFormatException exp) {
              this.io.println("You should enter a double number, nothing else!");
          }
      }
        this.io.println(resultMin);
        return resultMin;
    }


    /**
     * Return a new minimum
     * @param min - value from user
     * @return new value of min or old value of min
     */
    private double updateMinimumOrNot(double min) {
        double newMin = 0.0;
        if(abs(min) < abs(currentMin)) {
            newMin = min;
        } else {
            newMin = currentMin;
        }
        return newMin;
    }

}
