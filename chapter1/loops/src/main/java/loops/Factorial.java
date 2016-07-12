package loops;

/**
 * Calculate factorial of integer number.
 */
public class Factorial {

	/**
	 * Calculate factorial recursive while number bigger that one.
	 * If number equals one return one.
	 * @param number for this will calculate factorial.
	 * @return factorial of the number.
     */
	public int calculate(int number) {
		int result = 1;
		if(number == 0) {
			result = 1;
		} else {
			for(int index = 1; index <= number; index++) {
				result *= index;
			}
		}
		return result;
	}
}