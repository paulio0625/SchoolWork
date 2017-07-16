import java.util.Scanner;

public class WishList {
	/**
	 The items on the customer's wish list, sorted by sku.
	*/
	private Item[] list;

	/**
	 Constructs a new WishList given a sorted array of Items.
	*/
	public WishList (Item[] listIn) {
		list = listIn;
	}
	
	/**
	 Constructs a new WishList by reading the number of items and then 
	 the sorted list of item information using a Scanner; input format 
	 consists of a line with the number of items, followed by a line for 
	 each item containing values separated by commas
	*/
	public WishList (Scanner scin) {
		int count = scin.nextInt();
		scin.nextLine(); //read newline following the first int
		list = new Item[count];
		for(int i=0; i < count; i++){
			String s = scin.nextLine();
			Scanner scline = new Scanner(s);
			scline.useDelimiter(",");
			long sku = scline.nextLong();
			String name = scline.next();
			int priority = scline.nextInt();
			list[i] = new Item(name, sku, priority);
		}
	}

	/**
	 Returns the number of items that appear in only one of the two
	 wish lists (this one and the other one that is passed in as a
	 parameter). 
	*/
	public int findUnique (WishList other){
		//TO DO: Complete this method
		int counter = 0;
		boolean unique = true;
		
		for (int i = 0; i < list.length; i++){
			for (int j = 0; j < other.list.length; j++){
				if (list[i].getSKU() == other.list[j].getSKU()){
					unique = false;
					break;
				}
			}
			if(unique){
				counter++;
			}
			
			if(!unique){
				unique = true;
			}
		}
		
		counter += (other.list.length - (list.length - counter));
		
		return (counter);
	}

	/**
	 Merges this wish list with another one (passed in as a parameter),
	 producing a new sorted wish list.
	*/ 
	public WishList merge (WishList other){
		//TO DO: Complete this method
		Item[] newList = new Item[list.length + other.list.length];
		int counter = 0;
		int counter2 = 0;
		
		for(int i = 0; i < newList.length; i++){
			if((counter < list.length) && (counter2 < other.list.length)){
				if(list[counter].getSKU() < other.list[counter2].getSKU()){
					newList[i] = list[counter];
					counter++;
				}
				else{
					newList[i] = other.list[counter2];
					counter2++;
				}
			} else if((counter < list.length) && (counter2 >= other.list.length)){
				newList[i] = list[counter];
				counter++;
			} else if((counter2 < other.list.length) && (counter >= list.length)){
				newList[i] = other.list[counter2];
				counter2++;
			} 
		}
		
		WishList finalList = new WishList(newList);
		return finalList;
	}

	public String toString(){
		String s = "";
		for(int i=0; i < list.length; i++){
			s += list[i].getSKU() + "\t" + list[i].getName() + "\t" 
				+ list[i].getPriority() + "\n";
		}
		return s;
	}

}
