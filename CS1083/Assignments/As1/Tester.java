public class Tester{
	public static void main(String[]args){
		/**
		*Creates four new product objects and assigns them each a name, quantity, oredered and
		*price value.
		**/
		Product scissors = new Product("Scissors", 20, 0, 5.25);
		Product pencil = new Product("Pencil", 40, 0, 0.25);
		Product eraser = new Product("Eraser", 30, 0, 0.65);
		Product pen = new Product("Pen", 4, 10, 0.65);
		
		/**
		*Creates a new Stock object called test1 and passes in a 4 as a parameter.
		**/
		Stock test1 = new Stock(4);
		
		/**
		*Adds the four above products to the Stock object test1.
		**/
		test1.addProduct(scissors);
		test1.addProduct(pencil);
		test1.addProduct(eraser);
		test1.addProduct(pen);
		
		/**
		*Outputs a textual representation of the current Stock object test1.
		**/
		System.out.println(test1.toString());
		
		/**
		*Changes the price of scissors and the quantity of pencils in stock.
		**/
		scissors.setPrice(6.75);
		pencil.setStock(30);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Creates a new product object called tape.
		**/
		Product tape = new Product("Tape", 15, 15, 0.25);
		
		/**
		*Attempts to add tape to the Stock object test1.
		**/
		test1.addProduct(tape);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Removes the product scissors from the stock object test1.
		**/
		test1.removeProduct(scissors);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());

		/**
		*Creates a new Product object named glue.
		**/
		Product glue = new Product("Glue", 20, 0, 1.75);
		
		/**
		*Attempts to remove the product glue from the stock object test1.
		**/
		test1.removeProduct(glue);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Calls the sellItem method from the Stock class to update the pen product.
		**/
		test1.sellItem(pen);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Sets the number of pens in stock to 0.
		**/
		pen.setStock(0);
		
		/**
		*Attempts to call the sellItem method on the pen object.
		**/
		test1.sellItem(pen);
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Calls the restock method from the Stock class to update the 
		*ordered field of any low items.
		**/
		test1.restock();
		
		/**
		*Outputs the updated representation of the stock.
		**/
		System.out.println(test1.toString());
		
		/**
		*Calls the calculate method to determine the total value of all products currently available,
		*then outputs it to the screen.
		**/
		System.out.println(test1.calculate());
	}
}