/**
*This class holds the information for CSStudent objects which are a subclass of the Student class.
*@author Anton Benfey, Paul Armstrong
**/

public class CSStudent extends Student{
	/**
	*Creates a CSStudent object by taking in a name, ID, year of study and days since registration and passing them to the supper class.
	*@param name The name of the student.
	*@param ID The student's ID number.
	*@param yearOfStudy The year of study the student is in.
	*@param daysSinceRegistration The number of days since the student registered for the course.
	**/
	public CSStudent(String name, String ID, int yearOfStudy, int daysSinceRegistration){

		super(name, ID, yearOfStudy, daysSinceRegistration);

	}

	/**
	*Calculates the priority of the student.
	*@return teh priority of the student.
	**/
	public int priority(){
		return ((yearOfStudy() * 3)+(daysSinceRegistration() * 2));
	}
}
