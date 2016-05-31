package ru.evrnsky.arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import org.junit.Test;

/**
	Unit test for Duplicator.java
*/
public class DuplicatorTest
{
	/**
		When pass to method for delete duplicates not null string array
		Should return string of array without duplicates
	*/
	@Test
	public void whenPassToMethodDeleteDuplicatesNotEmptyStringShouldDeleteAllDuplicatesByAssignItNull()
	{
		//Assign block
		Duplicator deleteDuplicator = new Duplicator();
		String[] values = new String[]{"A", "C", "C", "A", "B", "A"};
		String[] expectedValues = new String[]{"A","B","C"};
		
		//Act block
		String[] resultArray = deleteDuplicator.removeDuplicates(values);
		
		//Action block
		assertThat(Arrays.toString(resultArray),is(Arrays.toString(expectedValues)));
	}
	
}