import java.lang.Math;

public class AttackBot extends Robot{
	
	private int health;
	private int strength;
	private int defense;
	private String weapon;

	public AttackBot(String name, int xPos, int yPos, int speed, String orientation, int health, int strength, int defense, String weapon) {
		super(name, xPos, yPos, speed, orientation);
		this.health = health;
		this.strength = strength;
		this.defense = defense;
		this.weapon = weapon;
	}

	public int getStrength() {
		return this.strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getWeapon() {
		return this.weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getHealth() {
		return this.health;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public int attack(AttackBot atb) {
		int damage = 0;
		if (atb.getDefense() < this.strength) {
			damage = this.strength - atb.getDefense();
		}
		return damage;
	}
	
	public int attackRandom(AttackBot atb) {
		int damage = 0;
		int strengthRoll = (int) (Math.random() * this.strength);
		int defenseRoll = (int) (Math.random() * atb.getDefense());
		if (defenseRoll < strengthRoll) {
			damage = strengthRoll - defenseRoll;
		}
		return damage;
	}
		
	public void defend(int damage) {
		this.health -= damage;
	}
	
	public String fight(AttackBot atb) {
		atb.defend(this.attack(atb));
		this.defend(atb.attack(this));
		return this.name + ": " + this.health + " / " + atb.name + ": " + atb.getHealth();
	}

	public static void main(String[] args) {

	}

}
