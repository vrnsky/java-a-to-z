package loops;

import static java.lang.Math.pow;

/**
 * Calculate value of quad function.
 */
public class Square {

    /**
     * a member of function.
     */
    private int a;

    /**
     * b member of function.
     */
    private int b;

    /**
     * c member of function.
     */
    private int c;

    /**
     * Construct new square function with given members.
     * @param ax first member of square function, in math it stay before x^2.
     * @param bx second member of square function, in math it stay before x.
     * @param cx third member of square function.
     */
    public Square(final int ax, final int bx, final int cx) {
        this.a = ax;
        this.b = bx;
        this.c = cx;
    }

    /**
     * Calculate value of square function at x point.
     * @param x point for calculate value of square function.
     * @return value of square function at the x point.
     */
    public final float calculate(final int x) {
        return (float) (a * pow(x, 2.0) + b * pow(x, 2.0) + c);
    }

    /**
     * Create a string which contains value of square function.
     * @param x point for start calculation, also may called x0.
     * @param y   point for finish calculation, also may called xn.
     * @param z difference between two x points.
     * @return string value of function between from and to, div by step.
     */
    public final String getStringView(final int x, final int y, final int z) {
        StringBuffer strBuffer = new StringBuffer();
        for (int start = x; start <= y; start += z) {
            strBuffer.append((int) calculate(start) + " ");
        }
        return strBuffer.toString();
    }
}
