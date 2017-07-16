/**
 *@author Paul Armstrong, 3537294
 **/

import java.util.Scanner;

public class BinaryTester{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a binary number.");
        System.out.println(binToDecimal(sc.nextLine()));
    }//end main.

    public static int binToDecimal(String input){
        int size = input.length();
        if (size == 0) return 0;
        String now = input.substring(0,1);
        String later = input.substring(1);
        return Integer.parseInt(now) * (int)Math.pow(2, size-1) + binToDecimal(later);
    }
}//end class.