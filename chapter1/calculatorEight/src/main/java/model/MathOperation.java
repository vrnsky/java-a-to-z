package model;

/**
 * Simple interface for math operation such as addition, divide, deduct and multiply.
 */
@FunctionalInterface
public interface MathOperation {

    /**
     * All operations must implement this interface.
     * @param a one number.
     * @param b other number.
     * @return result of executing.
     */
    int calculate(int a, int b);
}
