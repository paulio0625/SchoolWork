import java.util.Scanner;

public class PizzaTest{
	
	public static void main(String[]args)
	{
		System.out.print("Enter the flavor of the first pizza: ");
		Scanner sc = new Scanner(System.in);
		String flavor = sc.nextLine();
		
		System.out.print("Enter the price per slice of the first pizza: ");
		double price = sc.nextDouble();
		
		Pizza firstPizza = new Pizza(flavor, price);
		
		System.out.print("Enter the flavor of the second pizza: ");
		flavor = sc.nextLine();
		flavor = sc.nextLine();
		
		System.out.print("Enter the price per slice of the second pizza: ");
		price = sc.nextDouble();
		
		Pizza secondPizza = new Pizza(flavor, price);
		
		System.out.println("Both Pizza objects have been created");
		
		System.out.print("How many slices of " + firstPizza.getFlavor() + " are we baking today? ");
		int numberOfSlices = sc.nextInt();
		firstPizza.bake(numberOfSlices);
		
		System.out.print("How many slices of " + secondPizza.getFlavor() + "? ");
		numberOfSlices = sc.nextInt();
		secondPizza.bake(numberOfSlices);
		
		System.out.println();
		System.out.println("Welcome to Paul's Pizza Palace!");
		System.out.println(firstPizza.getFlavor() + " ............. " + firstPizza.getCostPerSlice());
		System.out.println(secondPizza.getFlavor() + " ............. " + secondPizza.getCostPerSlice());
		System.out.println();
		
		System.out.print("How many people visited us so far? ");
		int numberOfPeople = sc.nextInt();
		firstPizza.sell((2 * numberOfPeople));
		secondPizza.sell(numberOfPeople);
		System.out.println("Ok then this is our current status:");
		System.out.print(firstPizza.getFlavor() + " sold " + firstPizza.getSlicesSold());
		System.out.println(" and " + secondPizza.getFlavor() + " sold " + secondPizza.getSlicesSold());
		System.out.print(firstPizza.getFlavor() + " sold $" + firstPizza.calculateIncome());
		System.out.println(" and " + secondPizza.getFlavor() + " sold $" + secondPizza.calculateIncome());
		System.out.println("Together, they sold $" + (firstPizza.calculateIncome() + secondPizza.calculateIncome()));
		System.out.println();
		
		System.out.println("Baked some more " + firstPizza.getFlavor() + "!");
		firstPizza.bake(numberOfPeople);
		System.out.println("Current slices available:");
		System.out.println(firstPizza.getFlavor() + ": " + firstPizza.getSlicesAvailable() + " slices");
		System.out.println(secondPizza.getFlavor() + ": " + secondPizza.getSlicesAvailable() + " slices");
	}
}