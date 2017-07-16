import java.util.Scanner;
/**
* @author Paul Armstrong
* @author Anton Benfey
*/
public class Palindrome
{
    public static boolean isPal(String s)
    {
        if(s.length() == 0 || s.length() == 1){
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPal(s.substring(1, s.length()-1));
        }

        return false;
    }

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String input = sc.nextLine();
        if(isPal(input))
            System.out.println(input + " is a palindrome");
        else
            System.out.println(input + " is not a palindrome");
    }
}
