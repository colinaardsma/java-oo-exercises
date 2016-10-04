import static org.junit.Assert.*;

import org.junit.Test;

public class BaseballPlayerTest {

	@Test
	public void setGamesTest() {
		BaseballPlayer bp = new BaseballPlayer("Addison Russell", 27, "R");
		bp.setGames(5);
		assertEquals("Number of games does not set properly.", "Addison Russell currently has 0 hits, 0 R, and 0 RBI over 5 games.", bp.toString());
	}

	@Test
	public void setHTest() {
		BaseballPlayer bp = new BaseballPlayer("Addison Russell", 27, "R");
		bp.setH(5);
		assertEquals("Number of games does not set properly.", "Addison Russell currently has 5 hits, 0 R, and 0 RBI over 0 games.", bp.toString());
	}

	@Test
	public void setRTest() {
		BaseballPlayer bp = new BaseballPlayer("Addison Russell", 27, "R");
		bp.setR(5);
		assertEquals("Number of games does not set properly.", "Addison Russell currently has 0 hits, 5 R, and 0 RBI over 0 games.", bp.toString());
	}

	@Test
	public void setRbiTest() {
		BaseballPlayer bp = new BaseballPlayer("Addison Russell", 27, "R");
		bp.setRbi(5);
		assertEquals("Number of games does not set properly.", "Addison Russell currently has 0 hits, 0 R, and 5 RBI over 0 games.", bp.toString());
	}

	@Test
	public void playGameTest() {
		BaseballPlayer bp = new BaseballPlayer("Addison Russell", 27, "R");
		bp.playGame(4, 3, 4);
		assertEquals("Number of games does not set properly.", "Addison Russell currently has 4 hits, 3 R, and 4 RBI over 1 games.", bp.toString());
	}

	
}
