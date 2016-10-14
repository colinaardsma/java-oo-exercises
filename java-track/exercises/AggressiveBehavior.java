
public class AggressiveBehavior implements RobotBehavior{

	public void doNextMove(AttackBot r) {
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
		this.fight(r);
	}
	
}
