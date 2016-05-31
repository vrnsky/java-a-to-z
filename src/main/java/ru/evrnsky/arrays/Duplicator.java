package ru.evrnsky.arrays;

/**
	This class needed for remove duplicates in string array
	Delete is replaced string into "null"
*/
public class Duplicator
{
	/**
	 * This method removed duplicates from String array
	 * @param array for remove duplicates
	 * @return array without duplicates
	 */
	public String[] removeDuplicates(String[] array)
	{
		int length = markDuplicates(array);
		replaceNullToEnd(array);
		String[] result = new String[length];

		for(int index = 0; index < length; index++)
			result[index] = array[index];

		return result;

	}

	/**
		Mark all duplicates null
		@param: String[] array - array for marking duplicates
		@return int length - count of unique values in array
	*/
	private int markDuplicates(String[] array)
	{
		int length = 0;
		for(int index = 0; index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index] != null)
				{
					if(array[index].equals(array[barrier])) {
						array[barrier] = null;
						length++;
					}
				}
			}
		}
		return length;
	}

	/**
		Move all null to end of array
		@param: String[] array - array for replacing null
	*/
	private void replaceNullToEnd(String[] array)
	{
		for(int index = 0; index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index] == null && array[barrier] != null)
				{
					String copyString = array[barrier];
					array[index] = copyString;
					array[barrier] = null;
				}
			}
		}
	}



}