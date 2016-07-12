package arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import java.util.Arrays;
import arrays.Rotate;

/**
 * Unit test for Rotate.java.
 * It test algorithm of rotating quad matrix on to 90 degrees.
 */
public class RotateTest {
	/**
	 * When pass to rotate method not null matrix
	 * should return a rotated at 90 degree matrix.
	 */
	@Test
	public void whenWeTryRotate90DegreeNotNullMatrixShouldMethodReturnRotatedMatrix() {
		//Assign block
		Rotate rotater = new Rotate();
		int[][] values = {{1,2},{3,4}};
		int[][] expected = {{1,3},{2,4}};
		
		//Act block
		int[][] result = rotater.rotate90(values);
		
		//Action block
		assertThat(Arrays.deepEquals(expected,result),is(true));
	}
	
}