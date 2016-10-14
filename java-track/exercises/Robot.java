import java.lang.Math;

public class Robot {
	
	//Fields:
	protected String name;
	protected int xPos;
	protected int yPos;
	protected int speed;
	protected String orientation;
	
	//Constructor:
	public Robot(String name, int xPos, int yPos, int speed, String orientation) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		
		if (orientation != "N" && orientation != "S" && orientation != "E" && orientation != "W" && orientation != "n" && orientation != "s" && orientation != "e" && orientation != "w") {
			throw new IllegalArgumentException();
		}
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
		if (orientation != "N" && orientation != "S" && orientation != "E" && orientation != "W" && orientation != "n" && orientation != "s" && orientation != "e" && orientation != "w") {
			throw new IllegalArgumentException();
		}
		this.orientation = orientation.toUpperCase();
		return "Orientation is now " + this.orientation;
	}

	//Modifiers:
//	It can move. Where it ends up depends on its current position, its orientation, and its speed.
	public String move() {
		switch(this.orientation) {
		case "N":
			this.yPos += this.speed;
			break;
		case "E":
			this.xPos += this.speed;
			break;
		case "S":
			this.yPos -= this.speed;
			break;
		case "W":
			this.xPos -= this.speed;
			break;
		default:
			break;
		}
		return "Position is now: " + this.xPos + ", " + this.yPos;
	}

	public String moveUser(int dist) {
		switch(this.orientation) {
		case "N":
			this.yPos += dist;
			break;
		case "E":
			this.xPos += dist;
			break;
		case "S":
			this.yPos -= dist;
			break;
		case "W":
			this.xPos -= dist;
			break;
		default:
			break;
		}
		return "Position is now: " + this.xPos + ", " + this.yPos;
	}
	
//	It can rotate. This changes the robot's orientation. Each rotation should be exactly 90 degrees to the left or the right.
	public void rotate() {
		switch(this.orientation) {
		case "N":
			this.orientation = "E";
			break;
		case "E":
			this.orientation = "S";
			break;
		case "S":
			this.orientation = "W";
			break;
		case "W":
			this.orientation = "N";
			break;
		default:
			this.orientation = "ERROR";
			break;
		}
	}
	
//	Our Robot can determine how far away it is from another Robot object.
	public double howFar(Robot otherRobot) {
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
		try {
			Robot myRobot = new Robot("Henry", 7, 12, 2, "s");
			System.out.println(myRobot);
			myRobot.rotate();
			myRobot.move();
			System.out.println(myRobot);
			Robot yourRobot = new Robot("Carlos", 12, 9, 4, "E");
			System.out.println(yourRobot);
			yourRobot.rotate();
			yourRobot.move();
			System.out.println(yourRobot);
			System.out.println("Distance between robots: " + myRobot.howFar(yourRobot));
		}
		catch(IllegalArgumentException e) {
			System.out.println("Cannot create robot");
			e.printStackTrace();
		}
	}

}
