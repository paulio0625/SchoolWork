/** This program creates three new students, creates their on site mail labels and calculates their total fees
    @author Paul Churchill, Paul Armstrong
    **/

public class Lab3TestDriver{
	public static void main(String[] args){
	
	DormRoom room1 = new DormRoom("Ethel Merman Hall", 116, 9625.00);
	ResidentStudent student1 = new ResidentStudent("Juliette Price", 5850.00, 248.00, 2500.00, room1);

	DormRoom room2 = new DormRoom("Arthur Asher Miller Hall",1017, 10750.00);
	ResidentStudent student2 = new ResidentStudent("Porter Smith", 5200.00, 675.00, 0, room2);

	DormRoom room3 = new DormRoom("Josephine Baker Hall", 63, 8750.00);
	ResidentStudent student3 = new ResidentStudent("Katherine Doucet", 5565.00, 0, 3750, room3);
	
	room2 = new DormRoom("Jason Robert Brown Hall", 620, 11500.00);
	student1.setActivitiesAmount(338.00);
	student2.setRoom(room2);
	student3.setTuitionAmount(5250.00);
	
	System.out.println(student1.getOnSiteMailLabel() + "\n" + student1.getTotalFeesOwing());
	System.out.println(student2.getOnSiteMailLabel() + "\n" + student2.getTotalFeesOwing());
	System.out.println(student3.getOnSiteMailLabel() + "\n" + student3.getTotalFeesOwing());
	}
	
}



