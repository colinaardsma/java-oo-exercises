import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	private ArrayList<Robot> robots;
	private Scanner s;

	public RobotMenu() {
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}

	public static void main(String[] args) {
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
	}

	public int startMenu(){
		System.out.println("Welcome to the robot menu!");
		System.out.println("1. Create Robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option: ");

		int selection = s.nextInt();
		while(selection < 1 || selection > 6) {
			System.out.println("Invalid selection. Please select a number between 1 and 6: ");
			selection = s.nextInt();
		}
		return selection;
	}

	public void processInput(int selection) {
		if(selection == 1) {
			createRobot();
		} else if (selection == 2) {
			displayRobots();
		} else if (selection == 3) {
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Distance to move robot: ");
			int m = s.nextInt();
			while(m < 1) {
				System.out.println("Invalid value. Must be positive. Enter distance: ");
				m = s.nextInt();
			}
			r.moveUser(m); //this will only move the robot by the stock distance(speed), need to adjust to use user input
			System.out.println("Here is the robot's status after moving:");
			System.out.println(r);
			System.out.println();
		} else if (selection == 4) {
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Enter number of clockwise rotations: ");
			int ro = s.nextInt();
			while(ro < 1) {
				System.out.println("Invalid value. Must be positive. Enter number of clockwise rotations: ");
				ro = s.nextInt();
			}
			for (int i = 0; i < ro; i++) {
				r.rotate();
			}
			System.out.println("Here is the robot's status after rotating:");
			System.out.println(r);
			System.out.println();
		} else if (selection == 5) {
			while(robots.size() < 2) {
				System.out.println("Less than 2 robots. Please create another.");
				createRobot();
			}
			displayRobots();
			Robot r = selectRobot();
			displayRobots();
			Robot r2 = selectRobot();
			while (r == r2) {
				System.out.println("Select 2 different robots");
				displayRobots();
				r2 = selectRobot();
			}
			System.out.println("Distance between Robot 1 and Robot 2: " + r.howFar(r2));
		}
	}

	public void displayRobots() {
		for(int i = 0; i < robots.size(); i++) {
			System.out.println(i+1 + ". " + robots.get(i));
			System.out.println();
		}
	}

	private Robot selectRobot() {
		System.out.println("Please select a robot: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > robots.size()) {
			System.out.println("Invalid selection. Please select again: ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}

	private void createRobot() {
		System.out.println("Please enter a name: ");
		String name = s.next();
		
		System.out.println("Please enter an X position: ");
		int xPos = s.nextInt();
		
		System.out.println("Please enter a Y position: ");
		int yPos = s.nextInt();
		
		System.out.println("Please enter a speed: ");
		int speed = s.nextInt();
		
		System.out.println("Please enter an orientation (N,S,E,W): ");
		String orientation = s.next();
		orientation = orientation.toUpperCase();
		int x = 0;
		while(x != 1) {
			switch (orientation) {
			case "N": 
			case "S":
			case "E":
			case "W":
				x = 1;
				break;
			default:
				System.out.println("Invalid entry. Please enter an orientation (N,S,E,W): ");
				orientation = s.next();
				orientation = orientation.toUpperCase();
			}
		}
		
		robots.add(new Robot(name, xPos, yPos, speed, orientation));
	}
}