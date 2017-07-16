import java.util.Scanner;

public class RomanNumerals{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a number between 1 and 3999: ");
		int toConvert = sc.nextInt();
		
		while((toConvert < 1) || (toConvert > 3999)){
			System.out.println("Invalid input. You must enter a number between 1 and 3999.");
			System.out.print("Please enter another number now: ");
			toConvert = sc.nextInt();
		}
		
		int counter = 0;
		String romanForm = "";
		String firstNum = "";
		String secondNum = "";
		String thirdNum = "";
		String fourthNum = "";
		
		while(counter < 4){
			int temp = toConvert;
			if(counter == 0){
				switch(temp % 10){
					case 1: firstNum = "I";
						break;
					case 2: firstNum = "II";
						break;
					case 3: firstNum = "III";
						break;
					case 4: firstNum = "IV";
						break;
					case 5: firstNum = "V";
						break;
					case 6: firstNum = "VI";
						break;
					case 7: firstNum = "VII";
						break;
					case 8: firstNum = "VIII";
						break;
					case 9: firstNum = "IX";
						break;
					default:;
						break;
				}
			}
			
			if(counter == 1){
				switch((temp / 10) % 10){
					case 1: secondNum = "X";
						break;
					case 2: secondNum = "XX";
						break;
					case 3: secondNum = "XXX";
						break;
					case 4: secondNum = "XL";
						break;
					case 5: secondNum = "L";
						break;
					case 6: secondNum = "LX";
						break;
					case 7: secondNum = "LXX";
						break;
					case 8: secondNum = "LXXX";
						break;
					case 9: secondNum = "XC";
						break;
					default:;
						break;
				}
			}
			
			if(counter == 2){
				switch((temp / 100) % 10){
					case 1: thirdNum = "C";
						break;
					case 2: thirdNum = "CC";
						break;
					case 3: thirdNum = "CCC";
						break;
					case 4: thirdNum = "CD";
						break;
					case 5: thirdNum = "D";
						break;
					case 6: thirdNum = "DC";
						break;
					case 7: thirdNum = "DCC";
						break;
					case 8: thirdNum = "DCCC";
						break;
					case 9: thirdNum = "CM";
						break;
					default:;
						break;
				}
			}
			
			if(counter == 3){
				switch(temp / 1000){
					case 1: fourthNum = "M";
						break;
					case 2: fourthNum = "MM";
						break;
					case 3: fourthNum = "MMM";
						break;
					default:;
						break;
				}
			}
			
			romanForm = fourthNum + thirdNum + secondNum + firstNum;
			counter++;
		}
		System.out.println(toConvert + " in roman numerals is " + romanForm);
	}
}