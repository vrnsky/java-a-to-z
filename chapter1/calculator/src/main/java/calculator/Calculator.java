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
	 * It fields hold result of previous calculation.
     */
	private double prevResult;

	/**
	 * Add one first to second and write to result field.
	 * @param number for adding.
     */
	public void add(double number) {
		this.result = this.prevResult + number;
		this.prevResult = this.result;
	}

	/**
	 * Deduct second from first and write to result field.
	 * @param number it number which will deduct.
     */
	public void deduct(double number) {
		this.result = this.prevResult - number;
		this.prevResult = this.result;
	}

	/**
	 * Multiply number on result of previous calculation and write to result field.
	 * @param number second factor.
     */
	public void multiply(double number) {
		this.result = this.prevResult * number;
		this.prevResult = this.result;
	}

	/**
	 * Divide first double by second double and write to result field.
	 * If second double equals 0 should set it in 1 for prevent exception.
	 * @param number divisor.
	 * @throws ArithmeticException if try div by zero.
     */
	public void div(double number) {
		if (number == 0) {
			throw new ArithmeticException("Div by zero is illegal");
		}
		this.result = this.prevResult / number;
		this.prevResult = this.result;
	}

	/**
	 * Calculate a sinus.
	 * @param number degrees.
     */
	public void sin(double number) {
		this.result = Math.sin(number);
		this.prevResult = this.result;
	}

	/**
	 * Calculate a cosinus.
	 * @param number degrees.
     */
	public void cos(double number) {
		this.result = Math.cos(number);
		this.prevResult = this.result;
	}

	/**
	 * Calculate decimal log of given number.
	 * @param number for caculation.
     */
	public void log(double number) {
		this.result = Math.log10(number);
		this.prevResult = this.result;
	}

	/**
	 * Calculate module of given number.
	 * @param number for this will calculate module.
     */
	public void abs(double number) {
		this.result = Math.abs(number);
		this.prevResult = this.result;
	}

	/**
	 * Return a result of previous calculation.
	 * @return result of previous calculation.
     */
	public double getResult() {
		return result;
	}

	/**
	 * Return result of previous calculation.
	 * @return result previous result.
     */
	public double getPrevResult() {
		return this.prevResult;
	}



}