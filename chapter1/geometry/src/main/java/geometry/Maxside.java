package geometry;


import geometry.Triangle;
/**
	Class for find max side in triangle
*/
public class Maxside
{
	
	/**
		Find max side in triangle and return it's length
		@param: Triangle triangle - triangle for search maxium side
		@return double result - length of max side in triangle
	*/
	public double max(Triangle triangle)
	{
		double result = 0.0;
		if(triangle.area() > 0.0)
		{
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