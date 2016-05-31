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
		sort(array);

		int currentElem = 0;
		int nextElem = 1;
		if(array.length < 2){
			return array;
		}
		while(nextElem < array.length){
			
			if(array[nextElem].equals(array[currentElem]))
				nextElem++;
			
			else
				array[++currentElem] = array[nextElem++];
		}
		String[] output = new String[currentElem+1];
		for(int index = 0; index < output.length; index++){
			output[index] = array[index];
		}

		return output;
	}

	/**
	 * Sort string array
	 * @param array - array for sorting
	 */
	private void sort(String[] array)
	{
		for(int index = 0; index < array.length; index++)
		{
			for(int barrier = index + 1; barrier < array.length; barrier++)
			{
				if(array[index].compareTo(array[barrier]) > 0)
				{
					String copyString = array[barrier];
					array[barrier] = array[index];
					array[index] = copyString;
				}
			}
		}
	}
}