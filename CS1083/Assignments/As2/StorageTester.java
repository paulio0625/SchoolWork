import java.util.Scanner;

public class StorageTester{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		GasStorage cave = new GasStorage(row, column);
		
		System.out.println("The area of the cavern is: " + cave.area());
	}
}