package ru.evrnsky.geometry;

/**
 * Goal of this class is find a max side in triangle figure.
 */
public class Maxside {

	/**
	 * Return a length of max side from given triangle.
	 * @param triangle triangle for search maximum side.
	 * @return length of max side in triangle.
     */
	public double max(Triangle triangle) {
		double result = 0.0;
		double one = triangle.getFirstSide();
		double two = triangle.getSecondSide();
		double three = triangle.getThirdSide();
		if (triangle.area() > 0.0) {
			if (one > two && one > three) {
				result = one;
			} else if (two > one && two > three) {
				result = two;
			} else {
				result = three;
			}
		}
		return result;
	}
}