// *******************************************************************
// TestFib.java
//
// A simple driver that uses the Fib class to compute the
// nth element of the Fibonacci sequence.
// *******************************************************************

/**
* @author Paul Armstrong
* @author Anton Benfey
*/
import java.util.Scanner;
public class TestFib
{
   public static void main(String[] args)
   {
      int n, fib;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter an integer: ");
      n = scan.nextInt();
      fib = Fib.fib2(n);
      System.out.println("Fib(" + n + ") is " + fib);
      fib = Fib.fib1(n);
      System.out.println("Fib(" + n + ") is " + fib);
   }
}
