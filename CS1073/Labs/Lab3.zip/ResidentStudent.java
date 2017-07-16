/** @author Paul Churchill, Paul Armstrong
**/

public class ResidentStudent {
/** The name of the student.
**/
	private String name;
/** The tuition cost.
**/
	private double tuitionAmount;
/** The cost of activities.
**/
	private double activitiesAmount;
/** The amount of money from the student's scholarships.
**/
	private double scholarshipAmount;
/** The name of the Residence building, the room number and the cost of the room.
**/
	private DormRoom room;
	
	/** @param nameIn The name of the student
	    @param tuitionIn The cost of the tuition
	    @param activitiesAmountIn The cost of activities
	    @param scholarshipIn The amount of money from the student's scholarships.
	    @param roomIn The name of the Residence building, the room number and the cost of the room
	**/    
	public ResidentStudent (String nameIn, double tuitionIn, double activitiesAmountIn, 
	double scholarshipIn, DormRoom roomIn) {
		name = nameIn;
		tuitionAmount = tuitionIn;
		activitiesAmount = activitiesAmountIn;
		scholarshipAmount = scholarshipIn;
		room = roomIn;
	}
	/** @param nameIn Changes the name of the student
	 **/
	public void setName(String nameIn){
		name = nameIn;
	}
	/** @param tuitionIn Changes the cost of tuition
	**/
	public void setTuitionAmount(double tuitionIn){
		tuitionAmount = tuitionIn;
	}
	/** @param activitiesAmountIn Changes cost of activities
	**/
	public void setActivitiesAmount(double activitiesAmountIn){
		activitiesAmount = activitiesAmountIn;
	}
	/** @param scholarshipIn changes the amount of money given from scholarships
	**/
	public void setScholarshipAmount(double scholarshipIn){
		scholarshipAmount = scholarshipIn;
	}
	/** @param roomIn Changes the building name, room number and cost
	**/
	public void setRoom(DormRoom roomIn){
		room = roomIn;
	}
	/** @return Returns the total fees
	**/
	public double getTotalFeesOwing(){
		return (tuitionAmount + activitiesAmount + room.getRoomCost() - scholarshipAmount);
	}
	/** @return Returns the mail label of the student
	**/
	public String getOnSiteMailLabel(){
		return name + "\n" + room.getBuildingName() + ", room " + room.getRoomNumber();
	}
		
}
