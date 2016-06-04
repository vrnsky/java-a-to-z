package ru.evrnsky.chapter1.arrays;

/**
 * Implementation of bubble sort
 */

public class BubbleSort
{

	/**
	 * Sorting integer array by ascending
	 * @param array for sorting
	 */
	public void sort(int[] array)
	{
		for(int index = 0;index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index] > array[barrier])
				{
					int replaceValue = array[barrier];
					array[barrier] = array[index];
					array[index] = replaceValue;
				}
			}
		}
	}
	
}