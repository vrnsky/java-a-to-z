package loops;

import static java.lang.Math.*;
import java.lang.StringBuffer;

/**
 *  Calculate value of quad function.
 */
public class Square {

	/**
	 *  Members of square function.
	 */
	private int a, b, c;

	/**
	 * Construct new square function with given members.
	 * @param a first member of square function, in math it stay before x^2.
	 * @param b second member of square function, in math it stay before x.
     * @param c third member of square function, in math it stay in last position.
     */
	public Square(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Calculate value of square function at x point.
	 * @param x point for calculate value of square function.
	 * @return value of square fucntion at the x point.
     */
	public float calculate(int x)
	{
		return (float)(a * pow(x , 2.0) + b * pow(x,2.0) + c);
	}

	/**
	 * Create a string which contains value of square function.
	 * @param from point for start calculation, also may called x0.
	 * @param to point for finish calculation, also may called xn.
	 * @param step difference between two x points.
     * @return string which contains value of square function between from and to, div by step.
     */
	public String getStringView(int from, int to, int step) {
		StringBuffer strBuffer = new StringBuffer();
		for(int start = from; start <= to; start+=step) {
			strBuffer.append((int)calculate(start) + " ");
		}
		return strBuffer.toString();
	}
}