import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void addTest() {
		Fraction f1 = new Fraction(7, 23);
		Fraction f2 = new Fraction(13, 31);
		Fraction f = new Fraction(20, 54);
		assertEquals("Fractions do not add properly.", f.toString(), f1.add(f2).toString());
	}

	@Test
	public void multiplyTest() {
		Fraction f1 = new Fraction(7, 23);
		Fraction f2 = new Fraction(13, 31);
		Fraction f = new Fraction(91, 713);
		assertEquals("Fractions do not multiply properly.", f.toString(), f1.multiply(f2).toString());
	}

	@Test
	public void reciprocalTest() {
		Fraction f = new Fraction(7, 23);
		assertEquals("Fractions do not create proper reciprocal.", "23/7", f.reciprocal().toString());
	}

	@Test
	public void simplifyTest() {
		Fraction f = new Fraction(12, 32);
		assertEquals("Fractions do not simplify properly.", "3/8", f.simplify().toString());
	}

}
