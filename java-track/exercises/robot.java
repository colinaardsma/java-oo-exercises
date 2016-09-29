import java.lang.Math;

public class robot {
	
	//Fields:
	private String name;
	private int xPos;
	private int yPos;
	private int speed;
	private String orientation;
	
	//Constructor:
	public robot(String name, int xPos, int yPos, int speed, String orientation) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.orientation = orientation.toUpperCase();
	}
	
	//Getters:
	public String getName() {
		return this.name;
	}
	
	public String getPosition() {
		return this.xPos + ", " + this.yPos;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public int getSpeed() {
		return this.speed;
	}

	public String getOrientation() {
		return this.orientation;
	}
	
	//Setters:
	public String setOrientation(String orientation) {
		orientation = orientation.toUpperCase();
		if (orientation != "N" && orientation != "S" && orientation != "E" && orientation != "W")
			return "Orientation must be 'N, S, E, W'";
		else {
			this.orientation = orientation;
			return "Orientation is now " + this.orientation;
		}
	}

	//Modifiers:
//	It can move. Where it ends up depends on its current position, its orientation, and its speed.
	public String move() {
		if (this.orientation == "N") {
			this.xPos += this.speed;
		} else if (this.orientation == "E") {
			this.yPos += this.speed;
		} else if (this.orientation == "S") {
			this.xPos -= speed;
		} else {
			this.yPos -= speed;
		}
		return "Position is now: " + this.xPos + ", " + this.yPos;
	}
	
//	It can rotate. This changes the robot's orientation. Each rotation should be exactly 90 degrees to the left or the right.
	public String rotate() {
		if (this.orientation == "N") {
			this.orientation = "E";
		} else if (this.orientation == "E") {
			this.orientation = "S";
		} else if (this.orientation == "S") {
			this.orientation = "W";
		} else {
			this.orientation = "N";
		}
		return "Orientation is now: " + this.orientation;
	}
	
//	Our Robot can determine how far away it is from another Robot object.
	public double howFar(robot otherRobot) {
		int xDist = this.getXPos() - otherRobot.getXPos();
		int yDist = this.getYPos() - otherRobot.getYPos();
		double distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		return distance;
	}
	
//	Our Robot can return a String that contains its name, position, speed, and orientation.
	public String toString() {
		return "Name: " + this.name + "; Position: (" + this.getPosition() + "); Speed: " + this.speed + "; Orientation: " + this.orientation;
	}

//	Use this information to design your Robot class. Once you are satisfied with your design, you should implement it and create a simple main method to test your robot's functionality.
	public static void main(String args[]) {
		robot myRobot = new robot("Henry", 7, 12, 2, "N");
		System.out.println(myRobot);
		myRobot.rotate();
		System.out.println(myRobot);
		myRobot.move();
		System.out.println(myRobot);
		robot yourRobot = new robot("Carlos", 12, 9, 4, "E");
		System.out.println(yourRobot);
		System.out.println(myRobot.howFar(yourRobot));
	}
}
