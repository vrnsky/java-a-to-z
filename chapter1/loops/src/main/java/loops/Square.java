package loops;

import static java.lang.Math.*;
import java.lang.StringBuffer;

/**
	Calculate value of function
*/

public class Square
{
	private int a;
	private int b;
	private int c;
	
	/**
		@param: int a, b, c - ratio for function
		
	*/
	public Square(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
		Calculate value of function in x point
		@param: int x - coord for calculate value of function
		@return float - value of function at the x point
	*/
	public float calculate(int x)
	{
		return (float)(a * pow(x , 2.0) + b * pow(x,2.0) + c);
	}
	
	/**
		Return string view of value function
		@param:	 int from - start point for calculate
				 int to - finish point for calculate
				 int step - for calculate next x point
		@return: String str - it string view of function values	
	*/
	public String getStringView(int from, int to, int step)
	{
		StringBuffer strBuffer = new StringBuffer();
		for(int start = from; start <= to; start+=step)
		{
			strBuffer.append((int)calculate(start) + " ");
		}
		
		return strBuffer.toString();
	}
}