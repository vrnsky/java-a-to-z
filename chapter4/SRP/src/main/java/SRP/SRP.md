#Возможные нарушения SRP
1. [Класс CalcInit.java](https://github.com/vrnsky/java-a-to-z/blob/master/chapter1/calculator/src/main/java/calculator/CalcInit.java)
```
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
```
Данный метод выполняет сразу две функции - принимает данные и обрабатывает, необходимо использовать для чтения данных от пользователя другой класс, например, [Класс Validator](https://github.com/vrnsky/java-a-to-z/blob/master/chapter2/start/src/main/java/start/Validator.java).

2. [Класс Item](https://github.com/vrnsky/java-a-to-z/blob/master/chapter2/models/src/main/java/models/Item.java)
```
/**
	 * Unique string for each item.
	 */
	protected String id;
	/**
	 * Name of item.
	 */
	protected String name;

	/**
	 * Description of item.
	 */
	protected String description;

	/**
	 * Time when item was created.
	 */
	protected long createTime;

	/**
	 * Comments for item.
	 */
	protected Comment[] comments;

	/**
	 * For correct adding new comment should use pointer.
	 */
	protected int commentPointer;

	/**
	 * For generate random number for id.
	 */
	private static final Random RN = new Random();
   ```

3. Something