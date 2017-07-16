/** @author Paul Churchill, Paul Armstrong
**/	
public class DormRoom  {
	/** The name of the building
	**/
	private String buildingName;
	/** The room number
	**/
	private int roomNumber;
	/** The cost of the room per year
	**/
	private double roomCost;
	/** @param nameIn The name of the building
	    @param roomIn The room number
	    @param costIn The cost of the room per year 
	**/
	public DormRoom(String nameIn, int roomIn,double costIn) {
		buildingName = nameIn;
		roomNumber = roomIn;
		roomCost = costIn;
	}
	/** @return Returns the name of the building
	**/
	
	public String getBuildingName() {
	return buildingName;
	}
	/** @return Returns the room number
	**/
	public int getRoomNumber() {
	return roomNumber;
	}
	/** @return Returns the cost of the room per year
	**/
	public double getRoomCost() { 
	return roomCost;
	}
	
}
