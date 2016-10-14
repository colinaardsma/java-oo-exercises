
public class DefensiveBehavior implements RobotBehavior{

	private int aggression;

	public DefensiveBehavior(int aggression) {
		this.aggression = aggression;
	}

	public void doNextMove(AttackBot attacker, AttackBot defender) {
		if (attacker.howFar(defender) < 5.0) { //if overall distance between robots is greater than 5.0 then do nothing
			attacker.fight(defender);
		}
	}
	
}
