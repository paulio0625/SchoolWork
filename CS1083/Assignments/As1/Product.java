import java.text.NumberFormat;

public class Product{
	private String name;
	private static int id = 10001;
	private int quantity;
	private int ordered;
	private double price;
	private int idNum;
	NumberFormat nf = NumberFormat.getCurrencyInstance(); 
	
	public Product(String nameIn, int quantityIn, int orderedIn, double priceIn){
		name = nameIn;
		quantity = quantityIn;
		ordered = orderedIn;
		price = priceIn;
		idNum = id;
		id++;
	}
	
	public String getName(){
		return name;
	}
	public int getQuantity(){
		return quantity;
	}
	public int getOrdered(){
		return ordered;
	}
	public int getId(){
		return idNum;
	}
	public double getPrice(){
		return price;
	}
	
	public void setStock(int x){
		quantity = x;
	}
	public void order(int x){
		ordered += x;
	}
	public void setPrice(double x){
		price = x;
	}
	
	public void orderReceived(){
		quantity += ordered;
		ordered = 0;
	} 
	public double getTotalValue(){
		return (quantity * price);
	}
	public boolean sellProduct(){
		boolean success = false;
		if(quantity > 0){
			quantity -= 1;
			success = true;
		}
		return success;
	}
}