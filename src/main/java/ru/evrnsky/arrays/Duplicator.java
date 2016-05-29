package ru.evrnsky.arrays;

/**
	This class needed for remove duplicates in string array
	Delete is replaced string into "null"
*/
public class Duplicator
{
	/**
		Removed duplicates from string array
		@param: String[] array - array for deleting duplicates
	*/
	public String[] removeDuplicates(String[] array)
	{
		String[] result = null;
		StringBuffer strBuffer = new StringBuffer();
		markDuplicates(array);

		for(int index = 0; index < array.length; index++)
		{
			if(array[index] != null)
				strBuffer.append(array[index] + " ");
		}
		return strBuffer.toString().split(" ");
	}

	/**
		Mark all duplicates null for next deleting
		@param: String[] array  - array for marking duplicates cell in array as null
	*/
	private void markDuplicates(String[] array)
	{

		for(int index = 0; index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index] != null && array[index].equalsIgnoreCase(array[barrier]))
				{
					array[barrier] = null;
				}
			}
		}
	}
}