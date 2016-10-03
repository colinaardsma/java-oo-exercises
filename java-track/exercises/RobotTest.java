import static org.junit.Assert.*;
import java.lang.Math;

import org.junit.Test;

public class RobotTest {

	@Test
	public void setOrientationTest() {
		Robot r = new Robot("test", 5, 5, 5, "N");

		assertEquals("Does not correct user input to N/S/E/W", "Orientation must be 'N, S, E, W'", r.setOrientation("T"));
		assertEquals("Does not set orientation to newly entered value", "Orientation is now N", r.setOrientation("N"));
	}

	@Test
	public void moveTest() {
		Robot r = new Robot("test", 5, 5, 5, "N");

		assertEquals("Does not set position to correct cordinates", "Position is now: 5, 10", r.move());
	}

	@Test
	public void moveUserTest() {
		Robot r = new Robot("test", 5, 5, 5, "N");

		assertEquals("Does not set position to correct cordinates", "Position is now: 5, 10", r.moveUser(5));
	}
	
	@Test
	public void howFarTest() {
		Robot r = new Robot("test", 5, 5, 5, "N");
		Robot r2 = new Robot("test", 10, 10, 10, "S");

		assertEquals("Does not calculate distance properly", Math.sqrt(50), r.howFar(r2), 0.0);
	}

}
