package task;

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
		char[] fullSub = find.toCharArray();
		char[] charArray = string.toCharArray();
		boolean result = false;
		if(fullSub.length > charArray.length)
			result = false;
		int count = 0;

		for(int index = 0; index < charArray.length; index++)
		{
			for(int barrier = 0; barrier < fullSub.length; barrier++)
			{
				if(charArray[index] == fullSub[barrier])
				{
					count++;
					result = count > 0;
				}
				
			}
		}

		return result;
	}
}