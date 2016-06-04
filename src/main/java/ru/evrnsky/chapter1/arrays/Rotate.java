package ru.evrnsky.chapter1.arrays;

/**
	This class rotate matrix on 90 degree left and 90 degree right
*/

public class Rotate
{
	/**
		Rotate matrix on to 90 degree right
		@param: int[][] matrix - it is matrix for rotation
	*/
	public int[][] rotate90(int[][] matrix)
	{
		int[][] resultMatrix = new int[matrix[0].length][matrix.length];
		
		for(int index = 0; index < matrix[0].length; index++)
		{
			for(int barrier = matrix.length - 1; barrier >= 0; barrier--)
			{
				resultMatrix[index][barrier] = matrix[barrier][index];
			}
		}
		return resultMatrix;
	}
	
}