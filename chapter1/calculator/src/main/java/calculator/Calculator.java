package calculator;


/**
*  This class made arithmetic operations with double
*
*/
public class Calculator
{
	
	private double result;

	/**
	* Add first to double and save it to result
	*/	
	public void add(double first, double second)
	{
		this.result = first + second;
	}

	/**
	* Substruct from first second and save it to result
	*/
	public void substruct(double first, double second)
	{
		this.result = first - second;
	}

	/*
	* Multiply first on second and save it to result
	*/
	public void multiply(double first, double second)
	{
		this.result = first * second;
	}

	/**
	* Divide first by second and save it to result
	*/
	public void div(double first, double second)
	{
		if(second == 0) second = 1;
		this.result = first/second;
	}

	/*
	* Return result of computing
	*/
	public double getResult()
	{
		return result;
	}
}