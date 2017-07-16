/**
*A class for creating free elective course objects.
*@author Paul Armstrong, 3537294
**/

public class FECourse extends Course{
	/**
	*Constructs an FECourse by taking in a title grade and credit hour vlaue and passing them to the super class.
	*@param title The title of the course.
	*@param grade The grade obtained in the course.
	*@param credit The credit hours of the course.
	**/
	public FECourse(String title, String grade, int credit){
		super(title, grade, credit);
	}
	
	/**
	*Calculates the point value for a BrCourse
	*@return The points for the course.
	**/
	public double getPoints(){
		double points = 0;
		
		points = 0.8 * this.getCreditHours() * this.gradeConvert(this.getGrade());
		
		return points;
	}
}