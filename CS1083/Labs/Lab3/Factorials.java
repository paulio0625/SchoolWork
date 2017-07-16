import java.util.Scanner;

// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************

/**
* @author Anton Benfey
* @author Paul Armstrong
*/

public class Factorials {

	public static void main(String[] args) throws IllegalArgumentException {
		String keepGoing = "y";
		Scanner scan = new Scanner(System.in);

		while (keepGoing.equals("y") || keepGoing.equals("Y")) {
			System.out.print("Enter an integer: ");
			int val = scan.nextInt();
			try {
				if (val < 0) {
					throw new IllegalArgumentException("Value entered was negative");
				}

				if (val > 16) {
					throw new IllegalArgumentException("Arithmetic overflow - Number too large");
				}
				System.out.println("Factorial(" + val + ") = "
									+ MathUtils.factorial(val));
			} catch (IllegalArgumentException e){
				System.err.println(e.getMessage());
			}
			System.out.print("Another factorial? (y/n) ");
			keepGoing = scan.next();
		}
	}

}
