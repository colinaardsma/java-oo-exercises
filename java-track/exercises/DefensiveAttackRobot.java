
public class DefensiveAttackRobot extends AttackBot implements RobotBehavior {

	public DefensiveAttackRobot(String name, int xPos, int yPos, int speed, String orientation, int health, int strength, int defense, String weapon) {
		super(name, xPos, yPos, speed, orientation, health, strength, defense, weapon);
	}

	@Override
	public String doNextMove(AttackBot r) {
		if (this.howFar(r) < 5.0) { //if overall distance between robots is greater than 5.0 then do nothing
			return this.fight(r);
		}
		return "";
	}

}
