/**
*An abstract class that defines Student objects and holds methods to access information about these objects.
*@author Anton Benfey, Paul Armstrong
**/

public abstract class Student implements Comparable<Student> {
	/**
	*The name of the student.
	**/
	private String name;
	/**
	*The student's ID number.
	**/
	private String ID;
	/**
	*The year of study the student is in.
	**/
	private int yearOfStudy;
	/**
	*The number of days since the student registered.
	**/
	private int daysSinceRegistration;

	/**
	*Creates a student object by taking in a name, ID, year of study and days since registration.
	*@param name The name of the student.
	*@param ID The student's ID number.
	*@param yearOfStudy The year of study the student is in.
	*@param daysSinceRegistration The number of days since the student registered for the course.
	**/
	public Student(String name, String ID, int yearOfStudy, int daysSinceRegistration){

		this.name = name;
		this.ID = ID;
		this.yearOfStudy = yearOfStudy;
		this.daysSinceRegistration = daysSinceRegistration;
		

	}

	/**
	*Method to access the name of the student.
	*@return The name of the student
	**/
	public String getName(){
		return name;	
	}	

	/**
	*Method to access the ID number of the student.
	*@return The ID number of the student.
	**/
	public String getID(){
		return ID;	
	}
	
	/**
	*Method to access the year of study the student is in.
	*@return The year of study the student is in.
	**/
	public int yearOfStudy(){
		return yearOfStudy;
	}

	/**
	*Method to access the number of days since the student has registered.
	*@return The number of days since the student has registered.
	**/
	public int daysSinceRegistration(){
		return daysSinceRegistration;
	}

	/**
	*An abstract method to be defined in any child classes.
	**/
	public abstract int priority();
	
	/**
	*Method to overwrite the old toString method provided by the object class.
	*@return A textual representation of the student.
	**/
	public String toString(){

		return (name + "\t(" + ID + "):\t" + this.priority());
		
	}	

	/**
	*A method that compares one students priority to another and
	*returns either a zero or a positive or negative number to represent whether or not the otherStudents priority is higher.
	*@return An int value based on whether the otherStudent has more, less or even priority in comparison to the main student.
	**/
	public int compareTo(Student otherStudent){

		int x = this.priority();
		int y = otherStudent.priority();

		return x-y;

	}
}
