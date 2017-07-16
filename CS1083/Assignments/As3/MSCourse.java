/**
*A class for creating math and stat course objects.
*@author Paul Armstrong, 3537294
**/

public class MSCourse extends Course{
	/**
	*Constructs an MSCourse by taking in a title grade and credit hour vlaue and passing them to the super class.
	*@param title The title of the course.
	*@param grade The grade obtained in the course.
	*@param credit The credit hours of the course.
	**/
	public MSCourse(String title, String grade, int credit){
		super(title, grade, credit);
	}
	
	/**
	*Calculates the point value for a BrCourse
	*@return The points for the course.
	**/
	public double getPoints(){
		double points = 0;
		
		points = 1.2 * this.getCreditHours() * this.gradeConvert(this.getGrade());
		
		return points;
	}
}