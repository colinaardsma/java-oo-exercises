
public class Student {

	private String fName;
	private String lName;
	private int sID;
	private int credits;
	private double gpa;
	private double qScore;
	private double tuition;
	
	public Student(String fName, String lName, int sID) {
		this.fName = fName;
		this.lName = lName;
		this.sID = sID;
		this.credits = 0;
		this.gpa = 0;
		this.qScore = 0;
		this.tuition = 0;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getGPA() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return fName + " " + lName;
	}

	public int getStudentID() {
		return sID;
	}
	
	public String getClassStanding() {
		String standing;
		switch(this.credits) {
		case 30:
			standing = "Sophomore";
			break;
		case 60:
			standing = "Junior";
			break;
		case 90:
			standing = "Senior";
			break;
		default:
			standing = "Freshman";
			break;
		}
		return standing;
	}
	
	public void computeTuition() {
		double semester = this.credits / 15;
		this.tuition = 20000 * semester;
	}
	
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		double courseQscore = grade * (double) credits; 
		this.qScore += courseQscore;
		this.gpa = this.qScore / this.credits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
