package geometry;

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
		if(triangle.area() > 0.0) {
			if(triangle.firstSide > triangle.secondSide && triangle.firstSide > triangle.thirdSide)
				result = triangle.firstSide;
			else if (triangle.secondSide > triangle.firstSide && triangle.secondSide > triangle.thirdSide)
				result = triangle.secondSide;
			else
				result = triangle.thirdSide;
		}
		return result;
	}
}