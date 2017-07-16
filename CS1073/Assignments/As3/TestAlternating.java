import java.util.Scanner;

public class TestAlternating{
	public static void main(String[]args){
		System.out.print("Enter four integers: ");
		Scanner sc = new Scanner(System.in);
		
		//Creates 4 int vaariables and assigns values input by the user
		int firstNum = sc.nextInt();
		int secondNum = sc.nextInt();
		int thirdNum = sc.nextInt();
		int fourthNum = sc.nextInt();
		
		//determines if firstNum is less than the secondNum
		if (firstNum < secondNum){
			//determines if secondNum is greater than thirdNum
			if (secondNum > thirdNum){
				//determines if thirdNum is less than fourthNum
				if (thirdNum < fourthNum){
					System.out.println ("Alternating.");
				}
				else{
					System.out.println("Not alternating.");
				}
			}
			else{
				System.out.println("Not alternating.");
			}
		}
		//determines if firstNum is greater than secondNum
		else if (firstNum > secondNum){
			//determines if secondNum is less than thirdNum
			if (secondNum < thirdNum){
				//determines if thirdNum is greater than fourthNum
				if (thirdNum > fourthNum){
					System.out.println ("Alternating.");
				}
				else{
					System.out.println("Not alternating.");
				}
			}
			else{
				System.out.println("Not alternating.");
			}
		}
		else{
			System.out.println("Not alternating.");
		}
	}
}