import java.util.Scanner;

public class EqualPart{
	public static void main(String[]args){
	
		Scanner sc = new Scanner(System.in);
		boolean equal = false;
		int arrayOne[];
		int length = 0;
		
		while(length >= 0){
			System.out.println("Please specify the amount of numbers that will be entered");
			System.out.println("or enter a negative number to exit.");
			length = sc.nextInt();
			if(length < 0){
				break;
			}
			else{
				arrayOne = new int[length];
			}
			
			System.out.println("Please begin entering numbers");
			for(int i = 0; i < length; i++){
				arrayOne[i]= sc.nextInt();
			}
			
			for(int counter = 0; counter < length; counter++){
				int left = 0;
				int right = 0;
				int x;
				equal = false;
				
				for(x = 0; x <= counter; x++){
					left += arrayOne[x];
				}
				for(int y = (counter + 1); y < length; y++){
					right += arrayOne[y];
				}
				if(right == left){
					equal = true;
					break;
				}
			}
			System.out.println(equal);
		}
	}
}