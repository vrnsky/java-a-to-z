package arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import org.junit.Test;
import arrays.Duplicator;

/**
 * Unit test for Duplicator.java.
 * It test algorithm of removing duplicates from string array.
 */
public class DuplicatorTest {
	/**
	 * When pass to method for delete duplicates not null string array
	 * Should return string of array without duplicates.
	 */
	@Test
	public void whenPassToMethodDeleteDuplicatesNotEmptyStringShouldDeleteAllDuplicatesByAssignItNull() {
		//Assign block
		Duplicator deleteDuplicator = new Duplicator();
		String[] values = new String[]{"A", "C", "C", "A", "B", "A"};
		String[] expectedValues = new String[]{"A","C","B"};
		
		//Act block
		String[] result = deleteDuplicator.removeDuplicates(values);
		
		//Action block
		assertThat(Arrays.toString(result),is(Arrays.toString(expectedValues)));
	}
}