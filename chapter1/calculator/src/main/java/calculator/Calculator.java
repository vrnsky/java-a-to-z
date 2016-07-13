package calculator;
/**
 * Usually calculator it may add, deduct, multiply and divide.
 * Use it for execute arithmetic operations with double numbers.
 */
public class Calculator {

	/**
	 * Hold result of calculation.
	 */
	private double result;

	/**
	 * Find correct arithmetic operation and execute it by invoke method of this class.
	 * @param operation string view of math operator.
	 * @param first value for calculate.
	 * @param second value for calculate.
     */
	public void calc(String operation, double first, double second) {
		if(operation.equals("+")) this.add(first, second);
		else if (operation.equals("*")) this.multiply(first, second);
		else if (operation.equals("/")) this.div(first, second);
		else if (operation.equals("-")) this.deduct(first, second);
	}

	/**
	 * Add one first to second and write to result field.
	 * @param first number for adding.
	 * @param second number for adding.
     */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * Deduct second from first and write to result field.
	 * @param first from it will deduct.
	 * @param second it is what deduct.
     */
	public void deduct(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Multiply first on second and write to result field.
	 * @param first  first factor.
	 * @param second second factor.
     */
	public void multiply(double first, double second) {
		this.result = first * second;
	}

	/**
	 * Divide first double by second double and write to result field.
	 * If second double equals 0 should set it in 1 for prevent exception.
	 * @param first dividend.
	 * @param second divider.
     */
	public void div(double first, double second) {
		if(second == 0) second = 1;
		this.result = first/second;
	}

	/**
	 * Return a result of previous calculation.
	 * @return result of previous calculation.
     */
	public double getResult() {
		return result;
	}
}