/**
*This driver program reads inputs from the user and creates either a box or tube compares the areas and volumes of them and outputs the biggest volume and smallest surface area.
*@author Paul Armstrong 3537294
**/
import java.util.Scanner;
import java.text.NumberFormat;

public class Container{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		nf.setMinimumFractionDigits(3);
		nf.setGroupingUsed(true);
		
		System.out.println("What would you like to do?");
		System.out.println("1 - Get info for a box");
		System.out.println("2 - Get info for a tube");
		System.out.println("3 - Quit");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		double largestV = 0;
		double smallestSA = 0;
		String lastGreatV = "box";
		String lastsmallSA = "box";
		
		while(choice != 3){
			if(choice == 1){
				System.out.print("Length (in cm): ");
				double length = sc.nextDouble();
				System.out.print("Width (in cm): ");
				double width = sc.nextDouble();
				System.out.print("Height (in cm): ");
				double height = sc.nextDouble();
				
				Box box1 = new Box(length, width, height);
				
				System.out.println("The volume is: " + nf.format(box1.volume()) + " cubic centimeters.");
				System.out.println("The surface area is: " + nf.format(box1.surfaceArea()) + " square centimeters.");
				
				if(largestV < box1.volume()){
					largestV = box1.volume();
					lastGreatV = "box";
				}
				if((smallestSA > box1.surfaceArea()) || (smallestSA == 0)){
					smallestSA = box1.surfaceArea();
					lastsmallSA = "box";
				}
			}
			if(choice == 2){
				System.out.print("Radius (in cm): ");
				double radius = sc.nextDouble();
				System.out.print("Height (in cm): ");
				double height = sc.nextDouble();
				
				Tube tube1 = new Tube(radius, height);
				
				System.out.println("The volume is: " + nf.format(tube1.volume()) + " cubic centimeters.");
				System.out.println("The surface area is: " + nf.format(tube1.surfaceArea()) + " square centimeters.");
				
				if(largestV < tube1.volume()){
					largestV = tube1.volume();
					lastGreatV = "tube";
				}
				if((smallestSA > tube1.surfaceArea()) || (smallestSA == 0)){
					smallestSA = tube1.surfaceArea();
					lastsmallSA = "tube";
				}
			}
						
			System.out.println("What would you like to do?");
			System.out.println("1 - Get info for a box");
			System.out.println("2 - Get info for a tube");
			System.out.println("3 - Quit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
		}
		
		System.out.println("The container with the largest volume is a " + lastGreatV);
		System.out.println("It's volume is: " + nf.format(largestV) + " cubic centimeters");
		System.out.println("The container with the smallest surface area is a " + lastsmallSA);
		System.out.println("It's surface area is: " + nf.format(smallestSA) + " square centimeters");
		
	}
}