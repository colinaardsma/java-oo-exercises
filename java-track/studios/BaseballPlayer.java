
public class BaseballPlayer {

	private String name;
	private Integer num;
	private String hand;
	private Integer games;
	private Integer h;
	private Integer rbi;
	private Integer r;
	
	
	public BaseballPlayer(String name, Integer num, String hand) {
		this.name = name;
		this.num = num;
		this.hand = hand;
		this.games = 0;
		this.h = 0;
		this.rbi = 0;
		this.r = 0;
	}
	
	public Integer getGames() {
		return games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}

	public Integer getH() {
		return h;
	}

	public void setH(Integer h) {
		this.h = h;
	}

	public Integer getRbi() {
		return rbi;
	}

	public void setRbi(Integer rbi) {
		this.rbi = rbi;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	public String getName() {
		return name;
	}

	public Integer getNum() {
		return num;
	}

	public String getHand() {
		return hand;
	}
	
	public void playGame(Integer h, Integer r, Integer rbi) {
		this.games ++;
		this.h += h;
		this.r += r;
		this.rbi += rbi;
	}
	
	public String toString() {
		return this.name + " currently has " + this.h + " hits, " + this.r + " R, and " + this.rbi + " RBI over " + this.games + " games.";
	}

	public static void main(String[] args) {
		BaseballPlayer krisBryant = new BaseballPlayer("Kris Bryant", 17, "Right");
		krisBryant.playGame(4, 3, 4);
		System.out.println(krisBryant);

	}

}
