
public class AggresiveAttackRobot extends AttackBot implements RobotBehavior {

	public AggresiveAttackRobot(String name, int xPos, int yPos, int speed, String orientation, int health, int strength, int defense, String weapon) {
		super(name, xPos, yPos, speed, orientation, health, strength, defense, weapon);
	}

	@Override
	public String doNextMove(AttackBot r) {
		if (this.howFar(r) > 3.0) {
			if (r.getXPos() > this.getXPos()) { //if X distance between robots is greater than 3.0 then move closer
				while (this.getOrientation() != "E") {
					this.rotate();
				}
				this.moveUser(r.getXPos() - this.getXPos() - 3);
			} else if (r.getXPos() < this.getXPos()) {
				while (this.getOrientation() != "W") {
					this.rotate();
				}
				this.moveUser(this.getXPos() - r.getXPos() - 3);
			}
			if (r.getYPos() > this.getYPos()) { //if Y distance between robots is greater than 3.0 then move closer
				while (this.getOrientation() != "N") {
					this.rotate();
				}
				this.moveUser(r.getYPos() - this.getYPos() - 3);
			} else if (r.getYPos() < this.getYPos()) {
				while (this.getOrientation() != "S") {
					this.rotate();
				}
				this.moveUser(this.getYPos() - r.getYPos() - 3);
			}
		}
		return this.fight(r);
	}


	public static void main (String[] args) {
		AggresiveAttackRobot ar = new AggresiveAttackRobot("carl", 7, 11, 3, "N", 100, 13, 2, "taco");
		DefensiveAttackRobot dr = new DefensiveAttackRobot("lola", 18, 22, 5, "W", 100, 4, 10, "mustard");
//		System.out.println(dr.doNextMove(ar)); //dr will not attack since overall distance is greater than 5.0
//		System.out.println(ar.doNextMove(dr)); //ar will move to 3.0 away (or less) on the X and Y and attack
//		System.out.println(dr.doNextMove(ar)); //dr will attack since overall distance is less than 5.0
		while(ar.getHealth() > 0 && dr.getHealth() > 0) {
			System.out.println(ar.doNextMove(dr));
			System.out.println(dr.doNextMove(ar));
			if (ar.getHealth() <= 0) {
				System.out.println("Defense Robot Wins!");
			} else if (dr.getHealth() <= 0) {
				System.out.println("Attack Robot Wins!");
			}
		}
	}

}
