import java.lang.Math;

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
		if(this.credits < 30) {
			standing = "Freshman";
		} else if(this.credits < 60) {
			standing = "Sophomore";
		} else if(this.credits < 90) {
			standing = "Junior";
		} else {
			standing = "Senior";
		}
		return standing;
	}
	
	public double computeTuition() {
		double costPerCredit = Math.round((20000.0 / 15.0) * 100.0) / 100.0;
		if(this.credits % 15 == 0) {
			this.tuition = this.credits * costPerCredit;
			this.tuition = Math.round(this.tuition * 100.0) / 100.0;
		} else { //this doesnt work
			double semesters = this.credits / 15.0;
			this.tuition += semesters * costPerCredit;
			double remainder = this.credits - semesters;
			this.tuition += remainder * costPerCredit;
			this.tuition = Math.round(this.tuition * 100.0) / 100.0;
		}
//		this.tuition = Math.round((this.credits * costPerCredit) * 100.0) / 100.0;
		return this.tuition;
	}
	
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		double courseQscore = grade * (double) credits; 
		this.qScore += courseQscore;
		this.gpa = Math.round((this.qScore / this.credits) * 1000.0) / 1000.0;
	}
	
	public Student createLegacy(Student mother, Student father) {
		String fName = mother.getName();
		String lName = father.getName();
		int sID = mother.sID + father.sID;
		Student legacy = new Student(fName, lName, sID);
		legacy.gpa = Math.round(((mother.gpa + father.gpa) / 2.0) * 1000.0) / 1000.0;
		legacy.credits = Math.max(mother.credits, father.credits);
		return legacy;
	}
	
	public String toString() {
		return this.fName + " " + this.lName + " has a Student ID of " + this.sID + ", a " + this.gpa + " GPA, and " + this.credits + " credits";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
