package calculator;

import java.io.*;

/**
 * It class interact with user by accept data,
 * call API of calculator and show to user result.
 */

//TODO делегировать другому классу ввод и вывод из метода start()
public class CalcInit {

	/**
	 * Entry point of application.
	 * @param args - key and values from start.
	 * @throws Exception throw if reader from console fail.
     */
	public static void main(String[] args) throws Exception {
		CalcInit calcInit = new CalcInit();
		calcInit.start();
		
	}

	/**
	 * Main loop of program, it handles input and call api.
	 * @throws Exception if reader fail.
     */
	public void start() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calculator calculator = new Calculator();
		double second, first;
		String operand = "";
		int answer = 0;

		while(answer != -1) {
			System.out.println("Enter first digit");
			first = Double.parseDouble(reader.readLine());
			System.out.println("Enter second digit");
			second = Double.parseDouble(reader.readLine());
			
			System.out.println("Type operand");
			operand = reader.readLine();
			if(operand.equals("+")) calculator.add(first, second);
			else if (operand.equals("*")) calculator.multiply(first, second);
			else if (operand.equals("/")) calculator.div(first, second);
			else if (operand.equals("-")) calculator.deduct(first, second);
			
			System.out.printf("Result: %s\n", calculator.getResult());
			System.out.println("Type any digit to continue or -1 for exit");
			answer = Integer.parseInt(reader.readLine());
		}
	}
	
}