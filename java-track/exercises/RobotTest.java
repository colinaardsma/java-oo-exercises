import static org.junit.Assert.*;
import java.lang.Math;

import org.junit.Test;

public class RobotTest {

	@Test
	public void setOrientationTest() {
		Robot r = new Robot("test", 5, 5, 5, "N");

		try {
			r.setOrientation("t");
			fail("Invalid entry was not caught");
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		
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

	@Test
	public void buildTest() {
		AssemblyBot ab = new AssemblyBot("Builder", 5, 12, 3, "N", "Buttons", 7000);
		AssemblyBot ab2 = new AssemblyBot("Builder", 5, 12, 3, "N", "Buttons", 7000);
		AssemblyBot ab3 = new AssemblyBot("Builder", 5, 12, 3, "N", "Buttons", 7000);

		assertEquals("Incorrectly allows user to build too many products", "There are only 7000 parts left. 7000 Buttons have been built out of your request for 7005. You now have 0 parts left.", ab.build(7005));
		ab2.build(7000);
		assertEquals("Allows user to build products when there are 0 parts left", "There are no parts left. The robot was unable to build any of the 7005 Buttons you requested.", ab2.build(7005));
		assertEquals("Incorrectly allows user to build too many products", "42 Buttons have been built. You now have 6958 parts left.", ab3.build(42));	
	}

	@Test
	public void attackTest() {
		AttackBot atb = new AttackBot("Fighter 1", 5, 12, 3, "N", 100, 12, 4, "Axe");
		AttackBot atb2 = new AttackBot("Fighter 2", 8, 11, 5, "N", 100, 6, 9, "Spear");
		AttackBot atb3 = new AttackBot("Fighter 3", 8, 11, 5, "N", 100, 16, 2, "Sword");
		AttackBot atb4 = new AttackBot("Fighter 4", 8, 11, 5, "N", 100, 1, 1, "Unarmed");
		AttackBot atb5 = new AttackBot("Fighter 5", 8, 11, 5, "N", 100, 25, 10, "Gun");


		assertEquals("Damage is not calculated properly", 3, atb.attack(atb2), 0.0);
		atb.defend(7);
		assertEquals("Defense value is not calculated properly", 93, atb.getHealth(), 0.0);
		assertEquals("One round of fighting is not calculated properly", "Fighter 3: 96 / Fighter 2: 93", atb3.fight(atb2));
		assertEquals("Can't have negative damage", 0, atb4.attack(atb5));
	}

	@Test
	public void attackTestRandom() {
		AttackBot atb = new AttackBot("Fighter 1", 5, 12, 3, "N", 100, 12, 4, "Axe");
		AttackBot atb2 = new AttackBot("Fighter 2", 8, 11, 5, "N", 100, 6, 9, "Spear");
		AttackBot atb3 = new AttackBot("Fighter 3", 8, 11, 5, "N", 100, 16, 2, "Sword");
		AttackBot atb4 = new AttackBot("Fighter 4", 8, 11, 5, "N", 100, 1, 1, "Unarmed");
		AttackBot atb5 = new AttackBot("Fighter 5", 8, 11, 5, "N", 100, 25, 10, "Gun");


		assertEquals("Damage is not calculated properly", 3, atb.attackRandom(atb2), atb.getStrength());
		atb.defend(7);
		assertEquals("Defense value is not calculated properly", 93, atb.getHealth(), 0.0);
		assertEquals("One round of fighting is not calculated properly", "Fighter 3: 96 / Fighter 2: 93", atb3.fight(atb2));
		assertEquals("Can't have negative damage", 0, atb4.attackRandom(atb5));
	}

	@Test
	public void TestBadOrientation() {
		try {
			Robot myRobot = new Robot("Henry", 7, 12, 2, "f");
			fail("Invalid entry was not caught");
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
