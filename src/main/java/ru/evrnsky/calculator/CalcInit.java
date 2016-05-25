package ru.evrnsky.calculator;

import java.io.*;

/**
* Small calculator class
*
*/
public class CalcInit
{
	

	public static void main(String[] args) throws Exception
	{
		CalcInit calcInit = new CalcInit();
		calcInit.start();
		
	}


	/**
	*  This method use to start computing
	*
	*/
	public void start() throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calculator calculator = new Calculator();
		double second, first;
		String operand = "";
		int answer = 0;

		while(answer != -1)
		{

			System.out.println("Enter first digit");
			first = Double.parseDouble(reader.readLine());
			System.out.println("Enter second digit");
			second = Double.parseDouble(reader.readLine());
			
			System.out.println("Type operand");
			operand = reader.readLine();
			if(operand.equals("+")) calculator.add(first, second);
			else if (operand.equals("*")) calculator.multiply(first, second);
			else if (operand.equals("/")) calculator.div(first, second);
			else if (operand.equals("-")) calculator.substruct(first, second);
			
			
			
			System.out.printf("Result: %s\n", calculator.getResult());
			System.out.println("Type any digit to continue or -1 for exit");
			answer = Integer.parseInt(reader.readLine());
		}
	}
	
}