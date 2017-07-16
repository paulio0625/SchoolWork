/** 
  * This is an example of a driver program; its purpose is 
  * to "try out" the InventoryItem class.
  * @author Paul Churchill, 3543007, Paul Armstrong, 3537294
  */

public class InventoryTest {
   public static void main (String[] args) {

      // Create a few InventoryItem objects:
      InventoryItem item1 = 
         new InventoryItem("Pancake Mix", "President's Choice",  "A");
      InventoryItem item2 = 
         new InventoryItem("Lime Kool-Aid", "Kraft Foods", "A+");
      InventoryItem item3 = 
         new InventoryItem("Frozen French Fries", "McCain Foods", "F");
      InventoryItem item4 =
         new InventoryItem("Pizza", "Delicio", "B");

      item3.addStock(48);
      item1.addStock(12);
      item1.addStock(6);
      item2.addStock(60);
 
      // Now I can print out my InventoryItems, to confirm 
      // they were created properly:
      System.out.println("item1: " + item1.toString());
      System.out.println("item2: " + item2.toString());
      System.out.println("item3: " + item3.toString());
      System.out.println("item4: " + item4.toString());

   } // end main
} // end of InventoryTest class definition
