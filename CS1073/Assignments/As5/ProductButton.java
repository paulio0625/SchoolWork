import java.awt.*;
import javax.swing.*;
import java.text.NumberFormat;

/**
 A ProductButton is a special kind of JButton,
 used to display products for sale.
 @author Natalie Webber
 @author Paul Armstrong 3537294
*/
public class ProductButton extends JButton {

   /**
    The name of the product.
   */
   private String productName;
   
   /**
    The price for which we will sell the product
   */
   private double productPrice;

   /**
    Creates a button that will display an image of the product
    (assumed to be stored in a file starting with the specified
    name and ending with ".jpg"), the specified product name,
    and the specified price (formatted properly); the text is 
    displayed below the image and is centered.
    @param name The product name.
    @param price The selling price for this product.
   */
   public ProductButton (String name, double price){
      super(name);
	  productName = name;
	  productPrice = price;
	  
	  NumberFormat nf = NumberFormat.getCurrencyInstance();
	  
	  ImageIcon productIcon = new ImageIcon(productName + ".jpg");
	  super.setIcon(productIcon);
	  super.setText(name + ": " + nf.format(price));
	  
	  this.setVerticalTextPosition(AbstractButton.BOTTOM);
	  this.setHorizontalTextPosition(AbstractButton.CENTER);
   }

   /**
    Retrieves the product name.
    @return The product name.
   */
   public String getName() { 
      return productName; 
   }

   /**
    Retrieves the selling price.
    @return The price for which we will sell the product.
   */
   public double getPrice() { 
      return productPrice; 
   }
}