// *******************************************************************
// Fib.java
//
// A utility class that provide methods to compute elements of the
// Fibonacci sequence.
// *******************************************************************

/**
* @author Paul Armstrong
* @author Anton Benfey
*/
public class Fib
{
   //------------------------------------------------------------------
   // Recursively computes fib(n)
   //------------------------------------------------------------------
   public static int fib1(int n)
   {
      int answer;
      if (n == 0){
	answer = 0;
      }
      else if (n == 1){
	answer = 1;
      } else {
	answer = (fib1(n-1) + fib1(n-2));
      }

     return answer;
   }

   public static int fib2(int n)
   {
     int[] args = new int[n];
     if (n == 0){
	return 0;
     }

     else if (n == 1){
	return 1;

     } else {
	args[0] = 0;
	args[1] = 1;
	for (int i = 2; i < n; i++){
           args[i] = (args[i-1]+args[i-2]);
	}
     }

     return (args[n-1]+args[n-2]);
   }
}
