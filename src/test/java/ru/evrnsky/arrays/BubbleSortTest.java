package ru.evrnsky.arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import org.junit.Test;
import ru.evrnsky.arrays.BubbleSort;


/**
	Unit test for BubbleSort.java
*/
public class BubbleSortTest
{
	/**
		When pass to method bubble sort by descending not null array of integer
		Should return sorted array by descending
	*/
	@Test
	public void whenPassInSortMethodNotNullArrayShouldSortingNumbersInArrayByDescending()
	{
		//Assign block
		BubbleSort sorter = new BubbleSort();
		int[] randomArray = new int[]{5,3,2,4,6,1,7};
		int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7};
		
		//Act block
		sorter.sortByAscending(randomArray);
		
		//Action block
		assertThat(Arrays.toString(randomArray), is(Arrays.toString(expectedArray)));
	}
	
	/**
		When pass to method bubble sort by ascending not null array of integer
		Should return sorted array by ascending
	*/
	@Test
	public void whenPassInSortMethodNotNullArrayShouldSortingNumbersInArrayByAscending()
	{
		//Assign block
		BubbleSort sorter = new BubbleSort();
		int[] randomArray = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] expectedArray = new int[]{10,9,8,7,6,5,4,3,2,1};
		
		//Act block
		sorter.sortByDescending(randomArray);
		
		//Action block
		assertThat(Arrays.toString(randomArray), is(Arrays.toString(expectedArray)));
	
	}
	
}