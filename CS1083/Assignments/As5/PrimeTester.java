/**
 *@author Paul Armstrong, 3537294
 **/

import java.util.Scanner;

public class PrimeTester{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a positive integer.");
        System.out.println(isPrimeLoop(sc.nextInt()));

        System.out.println("Please enter a positive integer.");
        System.out.println(isPrimeRecursive(sc.nextInt(), 2));
    }//end main.

    public static boolean isPrimeLoop(int num){
        boolean answer = true;

        if(num == 1) {
            answer = false;
        }//end if.
        else if(num < 1){
            throw new IllegalArgumentException();
        }//end else if.
        else{
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    answer = false;
                    break;
                }//end if.
            }//end for.
        }//end else.

        return answer;
    }//end isPrimeLoop.

    private static boolean answer = true;
    public static boolean isPrimeRecursive(int num, int i){
        if(num == 1) {
            answer = false;
        }//end if.
        else if(num < 1){
            throw new IllegalArgumentException();
        }//end else if.
        else{
            if(i < num){
                if(num % i == 0){
                    answer = false;
                }//end if.
                else{
                    isPrimeRecursive(num, i+1);
                }//end else.
            }//end if.
        }//end else.

        return answer;
    }//end isPrimeRecursive.
}//end class.