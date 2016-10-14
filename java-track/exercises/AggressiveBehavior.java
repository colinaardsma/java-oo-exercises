
public class AggressiveBehavior implements RobotBehavior{

	private int aggression;
	
	public AggressiveBehavior(int aggression) {
		this.aggression = aggression;
	}
	
	public void doNextMove(AttackBot attacker, AttackBot defender) {
		if (attacker.howFar(defender) > 3.0) {
			if (defender.getXPos() > attacker.getXPos()) { //if X distance between robots is greater than 3.0 then move closer
				while (attacker.getOrientation() != "E") {
					attacker.rotate();
				}
				attacker.moveUser(defender.getXPos() - attacker.getXPos() - 3);
			} else if (defender.getXPos() < attacker.getXPos()) {
				while (attacker.getOrientation() != "W") {
					attacker.rotate();
				}
				attacker.moveUser(attacker.getXPos() - defender.getXPos() - 3);
			}
			if (defender.getYPos() > attacker.getYPos()) { //if Y distance between robots is greater than 3.0 then move closer
				while (attacker.getOrientation() != "N") {
					attacker.rotate();
				}
				attacker.moveUser(defender.getYPos() - attacker.getYPos() - 3);
			} else if (defender.getYPos() < attacker.getYPos()) {
				while (attacker.getOrientation() != "S") {
					attacker.rotate();
				}
				attacker.moveUser(attacker.getYPos() - defender.getYPos() - 3);
			}
		}
		attacker.fight(defender);
	}
	
}
