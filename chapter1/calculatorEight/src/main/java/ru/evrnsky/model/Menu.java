package ru.evrnsky.model;

/**
 * This class is wrapper for Calculator API.
 */
public class Menu {

    /**
     * Instance of Calculator API.
     */
    private Calculator calculator;

    /**
     * Default constructor.
     */
    public Menu() {
        this.calculator = new Calculator();
    }

    /**
     * Execute math operation by accept two ints and string view of operand.
     * @param operand string view of math operand, such as + or  -.
     * @param one integer for operation.
     * @param two integer for operation.
     * @return result of calculation.
     */
    public int calculate(String operand, int one, int two) {
        int result = 0;
        if (operand.equals("+")) {
            result = calculator.execute((a, b) -> a + b, one, two);
        } else if (operand.equals("-")) {
            result = calculator.execute((a, b) -> a - b, one, two);
        } else if (operand.equals("*")) {
            result = calculator.execute((a, b) -> a * b, one, two);
        } else if (operand.equals("/")) {
            if (two == 0) {
                throw new IllegalArgumentException("Div by zero is illegal!");
            }
            result = calculator.execute((a, b) -> a / b, one, two);
        }
        return result;
    }
}
