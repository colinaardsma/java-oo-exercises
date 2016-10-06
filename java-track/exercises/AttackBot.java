
public class AttackBot extends Robot{
	
	private int health;
	private int strength;
	private String weapon;

	public AttackBot(String name, int xPos, int yPos, int speed, String orientation, int health, int strength, String weapon) {
		super(name, xPos, yPos, speed, orientation);
		this.health = health;
		this.strength = strength;
		this.weapon = weapon;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getHealth() {
		return health;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
