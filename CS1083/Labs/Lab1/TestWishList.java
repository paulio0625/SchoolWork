import java.util.Scanner;

public class TestWishList{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		WishList bridesList = new WishList(sc);
		System.out.println(bridesList);
		WishList groomsList = new WishList(sc);
		System.out.println(groomsList);
		System.out.println("There are " + bridesList.findUnique(groomsList) 
			+ " items found in one wish list but not the other");
		System.out.println("Merged wish lists:" );
		System.out.println(bridesList.merge(groomsList));
	}
}
