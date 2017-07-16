public class LendingItem{
	private final String desc;
	private final double price;
	private final boolean collector;
	
	public LendingItem(String descIn, double priceIn, boolean collectorIn){
		desc = descIn;
		price = priceIn;
		collector = collectorIn;
	}
	
	public String getDescription(){
		return desc;
	}
	
	public double getPrice(){
		return price;
	}
	
	public boolean isCollectorsCopy(){
		return collector;
	}
	
	public boolean equals(LendingItem item){
		boolean equal = false;
		boolean descComp = false;
		boolean priceComp = false;
		boolean collectable = false;
		
		if(collectable == item.isCollectorsCopy()){
			collectable = true;
		}
		if(desc == item.getDescription()){
			descComp = true;
		}
		if(price == item.getPrice()){
			priceComp = true;
		}
		if(descComp && priceComp && collectable){
			equal = true;
		}
		return equal;
	}
}