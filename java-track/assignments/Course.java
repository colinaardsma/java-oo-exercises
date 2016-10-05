import java.util.ArrayList;

public class Course {
	
	private String name;
	private int credits;
	private int remainingSeats;
	private Student[] roster;
	private double avgGPA;
	
	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.roster = new Student[this.remainingSeats];
		this.avgGPA = 0;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getRemainingSeats() {
		return this.remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public Student[] getRoster() {
		return this.roster;
	}

	public void setRoster(Student[] roster) {
		this.roster = roster;
	}
	
	public Boolean addStudent(Student s) {
		if(this.remainingSeats > 0) {
			int rosterSpot = this.roster.length - this.remainingSeats;
			this.roster[rosterSpot] = s;
			this.remainingSeats--;
			return true;
		}
		return false;
	}

	public double averageGPA() {
		int studentCount = this.roster.length - this.remainingSeats;
		int count = 0;
		double cumGPA = 0;
		for(int i = 0; i < studentCount; i++) {
			cumGPA += this.roster[i].getGPA();
			count++;
		}
		this.avgGPA = cumGPA / count;
		return this.avgGPA;
	}

	public String toString() {
		return this.name + " is worth " + this.credits + " credits and has " + this.remainingSeats + " seats remaining.";
	}

	public static void main(String[] args) {
		Course c = new Course("test", 3, 15);
		System.out.println(c.getRoster());

	}

}
