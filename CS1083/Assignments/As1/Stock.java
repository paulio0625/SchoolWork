import java.text.NumberFormat;

public class Stock{
	private Product items[];
	private static int item = 0;
	
	public Stock(int x){
		items = new Product[x];
	}
	
	public boolean addProduct(Product x){
		boolean success = false;
		if(item < items.length){
			success = true;
			items[item] = x;
			item++;
		}
		return success;
	}
	
	public boolean sellItem(Product x){
		boolean success = false;
		for(int i = 0; i < item; i++){
			if(x == items[i]){
				success = true;
				x.sellProduct();
				break;
			}
		}
		return success;
	}
	
	public boolean removeProduct(Product x){
		boolean success = false;
		for(int i = 0; i < item; i++){
			if(x == items[i]){
				items[i] = items[(item - 1)];
				item--;
				success = true;
				break;
			}
		}
		return success;
	}
	
	public void restock(){
		for(int i = 0; i < item; i++){
			if(items[i].getQuantity() < 5){
				items[i].order(10);
			}
		}
	}
	
	public String calculate(){
		double total = 0;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		for(int i = 0; i < item; i++){
			total += items[i].getTotalValue();
		}
		return ("" + nf.format(total));
	}
	
	public String toString(){
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String output = "";
		
		for(int i = 0; i < item; i++){
			output = output + items[i].getName() + "\t id: (" + items[i].getId() + ") qty: " + items[i].getQuantity() + "\t" + items[i].getOrdered() + " ordere\t" + nf.format(items[i].getPrice()) + "\n";
		}
		return output;
	}
}