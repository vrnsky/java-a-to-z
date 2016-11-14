package geometry;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 * Unit test for Maxside.java.
 * It test algorithm of find max side int triangle.
 */
public class MaxsideTest {

	/**
	 * Delta of error.
	 */
	private final double delta = 0.01;

	/**
	 * When give to maxside correct object triangle
	 * Should check that max side return correct length of side.
	 */
	@Test
	public void whenGiveMaxsideObjectCorrectTriangleShouldGetLengthOfMaxSideInTriangle() {
		Triangle goodTriangle = new Triangle(new Point(4.0, 0.0),
				          new Point(8.0, 3.0), new Point(5.0, 8.0));
		final double expectedMax = 8.06D;
		Maxside maxSide = new Maxside();

		double actualMax = maxSide.max(goodTriangle);

		assertThat(actualMax, closeTo(expectedMax, delta));
	}


	/**
	 * When give to maxside bad object triangle
	 * Should that max side return 0.0 - which means that triangle not exist.
	 */
	@Test
	public void whenGiveMaxsideObjectWrongTriangleShouldGetZeroLength() {
		Triangle badTriangle = new Triangle(new Point(0.0, 0.0),
				       new Point(0.0 ,3.0), new Point(0.0, 0.0));
		final double expectedMax = 0.0;
		Maxside maxSide = new Maxside();

		double actualMax = maxSide.max(badTriangle);

		assertThat(actualMax, closeTo(expectedMax, delta));
	}
}