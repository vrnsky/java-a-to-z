package ru.evrnsky.arrays;


public class BubbleSort
{
	
	public void sortByAscending(int[] array)
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
	
	public void sortByDescending(int[] array)
	{	
		for(int index = 0; index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index] < array[barrier])
				{
					int replaceValue = array[index];
					array[index] = array[barrier];
					array[barrier] = replaceValue;
				}
			}
		}
	}
}