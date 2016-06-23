package loops;

/**
	Calculate factorial of number
*/

public class Factorial
{
	/**
		@param: int number for calculate factorial
	*/
	public int calculate(int number)
	{
		int result = 1;
		if(number == 0)
			result = 1;
		else {
			for(int index = 1; index <= number; index++)
			{
				result *= index;
			}
		}
		
		return result;
	}
}