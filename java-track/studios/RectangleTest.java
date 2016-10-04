import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void isSquareTest() {
		Rectangle r = new Rectangle(6, 3);
		assertEquals("Cannot tell if square.", false, r.isSquare());
	}

	@Test
	public void perimeterTest() {
		Rectangle r = new Rectangle(6, 3);
		assertEquals("Perimeter calculation is incorrect.", 18, r.perimeter(), 0);
	}

	@Test
	public void areaTest() {
		Rectangle r = new Rectangle(6, 3);
		assertEquals("Area calculation is incorrect.", 18, r.area(), 0);
	}

	@Test
	public void areaCompareTest() {
		Rectangle r = new Rectangle(6, 3);
		Rectangle r2 = new Rectangle(9, 4);
		assertEquals("Imporperly compares rectangles.", "Your rectangle is smaller", r.areaCompare(r2));
	}
	
	@Test
	public void addHeightTest() {
		Rectangle r = new Rectangle(6, 3);
		r.addHeight(6);
		assertEquals("Imporperly compares rectangles.", "Your width is 6, your height is 9", r.toString());
	}
	
	@Test
	public void addWidthTest() {
		Rectangle r = new Rectangle(6, 3);
		r.addWidth(6);
		assertEquals("Imporperly compares rectangles.", "Your width is 12, your height is 3", r.toString());
	}
	
}
