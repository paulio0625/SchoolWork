/**
  *	This class represents an inventory item in a store.
  * @author Paul Churchill, 3543007, Paul Armstrong, 3537294
  */

public class InventoryItem {

   // Instance variables:
   // For each InventoryItem object stores
   // 	the product name,  
   // 	the number of items in stock
   //	and the manufacturer.
   private String name;
   private int numInStock;
   private String manufacturer;
   private String nutritionGrade; 

   // The constructor creates a new InventoryItem object
   // and initializes the instance variables.
   public InventoryItem(String nameIn, String manufacturerIn, String nutritionIn) {
      name = nameIn;
      numInStock = 0;
      manufacturer = manufacturerIn;
      nutritionGrade = nutritionIn;
   }

   // This is a method that we can call on a InventoryItem
   // object. (Specifically, it is an accessor method).
   // This method creates and returns a String containing
   // all the information about the state of the object.
   public String toString() {
      return ("Inventory[name="  + name +
             ",numInStock="  + numInStock +
             ",manufacturer=" + manufacturer +", nutritionGrade= " + nutritionGrade +"]");
   }
   public void addStock(int stockNum){
     numInStock = numInStock + stockNum;
   }

} // end of InventoryItem class definition
