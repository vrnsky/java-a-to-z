package ru.evrnsky.model;

/**
 * Simple calculator.
 * This calculator may execute math operations such as addition, deduct, multiply and divide.
 */
public class Calculator {

    /**
     * Execute math operation which accept two arguments.
     * @param operation implementation of MathOperation interface.
     * @param a one integer for operation.
     * @param b second integer for operation.
     * @return result of calculation.
     */
    public int execute(MathOperation operation, int a, int b) {
        return operation.calculate(a, b);
    }
}
