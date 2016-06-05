package ru.evrnsky.chapter1.task;

/**
 * Functionality of substring method from class String
 */
public class Substring
{

	/**
	 * Check is an find sub string of string
	 * @param string - In this string will search
	 * @param find - Sub string for search
     * @return - true if find is an substring, otherwise false
     */
	public boolean isSubstring(String string, String find)
	{
		char[] fullSub = alignment(string, find);
		char[] charArray = string.toCharArray();
		int count = 0;

		for(int index = 0; index < charArray.length; index++)
		{
			for(int barrier = 0; barrier < charArray.length; barrier++)
			{
				if(fullSub[barrier] != '\u0000')
				{
					if(charArray[index] == fullSub[barrier])
						count++;
				}
			}
		}

		return count > 0;
	}


	/**
	 * Alignment for char arrays
	 * @param string - Use for calculate length of new array
	 * @param find - From it copy data
     * @return - char[] with data from find, other position filled by '_'
     */
	public char[] alignment(String string, String find)
	{
		char[] result = new char[string.length()];
		char[] findChar = find.toCharArray();

		System.arraycopy(findChar,0,result,0,findChar.length);

		for(int index = findChar.length; index < result.length; index++)
			result[index] = '\u0000';

		return result;
	}
}