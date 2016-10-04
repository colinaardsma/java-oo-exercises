
public class Course {
	
	private String name;
	private int credits;
	private int remainingSeats;
	private String[] roster;
	
	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.roster = new String[this.remainingSeats];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public String[] getRoster() {
		return roster;
	}

	public void setRoster(String[] roster) {
		this.roster = roster;
	}
	
	public Boolean addStudent(Student s) {
		int seats = 0;
		for(int i = 0; i < this.roster.length; i++) {
			if(this.roster[i] == "") {
				this.roster[i] = s.getName();
				seats++;
				this.remainingSeats -= seats;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.name + " is worth " + this.credits + " credits and has " + this.remainingSeats + " seats remaining.";
	}

	public static void main(String[] args) {
		Course c = new Course("test", 3, 15);
		System.out.println(c.getRoster());

	}

}
