package arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import org.junit.Test;
import arrays.BubbleSort;

/**
 * Unit test for BubbleSort.java.
 * It test implementation of bubble sort algorithm.
 */
public class BubbleSortTest
{
	/**
	 * When pass to method bubble sort by descending not null array of integer
	 * should return sorted array by ascending.
	 */
	@Test
	public void whenPassInSortMethodNotNullArrayShouldSortingNumbersInArrayByAscending() {
		//Assign block
		BubbleSort sorter = new BubbleSort();
		int[] randomArray = new int[]{5,3,2,4,6,1,7};
		int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7};
		
		//Act block
		sorter.sort(randomArray);
		
		//Action block
		assertThat(Arrays.toString(randomArray), is(Arrays.toString(expectedArray)));
	}
}