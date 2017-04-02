package task;

/**
 * Functionality of substring method from class String.
 * Get two string and check that second string is substring of first string.
 */
public class Substring {
	/**
	 * Check is an part sub fullString of fullString.
	 * @param fullString  In this fullString will search.
	 * @param part Sub fullString for search.
     * @return  true if part is an substring, otherwise false.
	 */
	public boolean isSubstring(String fullString, String part) {
		char[] partArray = part.toCharArray();
		char[] fullArray = fullString.toCharArray();
		int count = 0;
		boolean result = false;
		if (partArray.length > fullArray.length) {
			result = false;
		} else {

			for (int index = 0; index < fullArray.length; index++) {
				for (int barrier = 0; barrier < partArray.length; barrier++) {
					if (fullArray[index] == partArray[barrier]) {
						count++;
						result = count > 0;
					}
				}
			}
		}
		return result;
	}
}