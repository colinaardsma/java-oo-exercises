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
	
	public AttackBot setBehavior(int aggression) {
		if (aggression > 10  || aggression < 1) {
			throw new IllegalArgumentException();
		}
		if (aggression <= 5) {
			AggresiveAttackRobot r = new AggresiveAttackRobot(this.name, this.xPos, this.yPos, this.speed, this.orientation, this.health, this.strength, this.defense, this.weapon);
			return r;
		} else {
		DefensiveAttackRobot r = new DefensiveAttackRobot(this.name, this.xPos, this.yPos, this.speed, this.orientation, this.health, this.strength, this.defense, this.weapon);
		return r;
		}
	}

	public static void main(String[] args) {
		System.out.println("test1");

		try{
			AttackBot ar = new AttackBot("carl", 7, 11, 3, "N", 100, 13, 2, "taco");
			AttackBot dr = new AttackBot("lola", 18, 22, 5, "W", 100, 4, 10, "mustard");
			AttackBot ar2 = ar.setBehavior(11);
			AttackBot dr2 = dr.setBehavior(3);
			System.out.println("test");
			while(ar2.getHealth() > 0 && dr2.getHealth() > 0) {
//				System.out.println(ar2.doNextMove(dr2));
//				System.out.println(dr2.doNextMove(ar2));
//				System.out.println(ar2);
//				System.out.println(dr2);
				if (ar2.health <= 0) {
					System.out.println("Defense Robot Wins!");
				} else if (dr2.health <= 0) {
					System.out.println("Attack Robot Wins!");
				}
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Cannot set aggression");
			e.printStackTrace();
		}





	}

}
