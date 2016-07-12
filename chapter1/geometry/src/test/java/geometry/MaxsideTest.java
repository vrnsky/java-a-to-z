package geometry;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 * Unit test for Maxside.java.
 * It test algorithm of find max side int triangle.
 */
public class MaxsideTest {

	/**
	 * When give to maxside correct object triangle
	 * Should check that max side return correct length of side.
	 */
	@Test
	public void whenGiveMaxsideObjectCorrectTriangleShouldGetLengthOfMaxSideInTriangle() {
		//Assign block
		Triangle goodTriangle = new Triangle(new Point(4.0,0.0), new Point(8.0,3.0), new Point(5.0,8.0));
		double expectedMax = 8.06;
		Maxside maxSide = new Maxside();
		
		//Act block
		double actualMax = maxSide.max(goodTriangle);
		
		//Action block
		assertThat(expectedMax, closeTo(actualMax,0.01));
	}


	/**
	 * When give to maxside bad object triangle
	 * Should that max side return 0.0 - which means that triangle not exist.
	 */
	@Test
	public void whenGiveMaxsideObjectWrongTriangleShouldGetZeroLength() {
		//Assign block
		Triangle badTriangle = new Triangle(new Point(0.0,0.0), new Point(0.0,3.0), new Point(0.0,0.0));
		double expectedMax = 0.0;
		Maxside maxSide = new Maxside();
		
		//Act block
		double actualMax = maxSide.max(badTriangle);
		
		//Action block
		assertThat(expectedMax, closeTo(actualMax,0.01));
	}
}