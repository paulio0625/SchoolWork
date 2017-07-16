/**
Represents the pizza availability of a particular flavor
@author Paul Armstrong
**/
public class Pizza{
	/**
	The cost in CAD for a single slice of pizza.
	**/
	private double costPerSlice;
	/**
	The flavor of pizza this object represents. 
	**/
	private String flavor;
	/**
	The number of pizza slices available for sale.
	**/
	private int slicesAvailable;
	/**
	The number of pizza slices already sold.
	**/
	private int slicesSold;
	
	/**
	Constructs a new instance by using the parameters for the flavor and cost per size and by setting 
	the slices available and slices sold to 0
	@param flavorIn - The flavore of this Pizza
	@param costPerSliceIn - The cost per slice of this Pizza
	**/
	public Pizza(String flavorIn, double costPerSliceIn)
	{
		flavor = flavorIn;
		costPerSlice = costPerSliceIn;
	}
	/**
	Method to reflect the availability of more pizza Increases the available number
	of slices by the number of new pizza slices
	@param numberOfNewPizzaSlices ­ The number of new pizzas just baked
	**/
	public void bake(int numberOfNewPizzaSlices)
	{
		slicesAvailable = slicesAvailable + numberOfNewPizzaSlices;
	}
	/**
	Method to calculate the total income of this flavor by multiplying the number
	of its sold slices by the cost per slice
	@return the total income this pizza flavor has produced so far
	**/
		public double calculateIncome()
	{
		double income = costPerSlice * slicesSold;
		return income;
	}
	/**
	Accessor method for costPerSlice
	@return the costPerSlice
	**/
	public double getCostPerSlice()
	{
		return costPerSlice;
	}
	/**
	Accessor method for flavor.
	@return The flavor of this Pizza.
	**/
	public String getFlavor()
	{
		return flavor;
	}
	/**
	Accessor method for slicesAvailable
	@return the slicesAvailable
	**/
	public int getSlicesAvailable()
	{
		return slicesAvailable;
	}
	/**
	Accessor method for slicesSold
	@return the slicesSold
	**/
	public int getSlicesSold()
	{
		return slicesSold;
	}
	/**
	Method to sell pizza slices
	@param numberOfSlicesSold ­ The number of slices sold
	**/
	public void sell(int numberOfSlicesSold)
	{
		slicesAvailable = slicesAvailable - numberOfSlicesSold;
		slicesSold = slicesSold + numberOfSlicesSold;
	}
}