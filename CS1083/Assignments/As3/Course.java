/**
*Parent class for all types of course classes.
*@author Paul Armstrong, 3537294
**/
import java.text.NumberFormat;

public abstract class Course implements Comparable<Course>{
	/**
	*The number of credit hours that the course is worth.
	**/
	private int credit;
	/**
	*The letter grade recieved in the course
	**/
	private String grade;
	/**
	*The title of the course.
	**/
	private String title;
	
	/**
	*Constructs a Course.
	*@param t The title.
	*@param g The letter grade.
	*@param c The number of credit hours.
	**/
	public Course(String t, String g, int c){
		credit = c;
		grade = g;
		title = t;
	}
	
	/**
	*Compares courses based on their total grade points.
	*@return An integer value to indicate <, > or ==.
	**/
	public int compareTo(Course other){
		int num = 0;
		if(this.getPoints() > other.getPoints()){
			num = 1;
		}
		else if(this.getPoints() < other.getPoints()){
			num = -1;
		}
		else if(this.getPoints() == other.getPoints()){
			num = 0;
		}
		return num;
	}
	
	/**
	*Retrieves the credit hours.
	*@return The credit hours for this course.
	**/
	public int getCreditHours(){
		return credit;
	}
	
	/**
	*Retrieves the letter grade.
	*@return The letter grade for this course.
	**/
	public String getGrade(){
		return grade;
	}
	
	/**
	*Determines the total number of grade points earned in this course.
	*@return The total grade points earned.
	**/
	public abstract double getPoints();
	
	/**
	*Retrieves the course title.
	*@return The title for this course.
	**/
	public String getTitle(){
		return title;
	}
	
	/**
	*Converts a letter grade to the equivalent point value.
	*@param letterGrade The letter grade to convert.
	*@return The equivalent point value.
	**/
	public static double gradeConvert(String letterGrade){
		double num;
		
		switch(letterGrade){
			case "A+": num = 4.3;
			break;
			case "A": num = 4;
			break;
			case "A-": num = 3.7;
			break;
			case "B+": num = 3.3;
			break;
			case "B": num = 3;
			break;
			case "B-": num = 2.7;
			break;
			case "C+": num = 2.3;
			break;
			case "C": num = 2;
			break;
			case "D": num = 1;
			break;
			default: num = 0;
			break;
		}

		return num;
	}
	
	/**
	*Creates and returns a textual string containing the course title, letter grade, and total grade points
	*earned (formatted to include 2 decimal digits).
	*@return The textual string.
	**/
	public String toString(){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		String out = "";
		
		out += title + "\t" + grade + "\tpoints = " + nf.format(this.getPoints());
		
		return out;
	}
}