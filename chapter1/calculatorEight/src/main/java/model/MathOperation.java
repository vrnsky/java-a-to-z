package model;

/**
 * Simple interface for math operation such as addition, divide, deduct and multiply.
 */
@FunctionalInterface
public interface MathOperation {

    int calculate(int a, int b);
}
