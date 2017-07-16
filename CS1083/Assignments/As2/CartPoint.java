/**
*This class holds to int values as x and y coordinates on a cartesian plane.
@author Paul Armstrong, 3537294
**/
public class CartPoint{
	/**
	*The x coordinate.
	**/
	private int x;
	/**
	*The y coordinate.
	**/
	private int y;
	
	/**
	*Creates the cartesian point by taking in two int values and assigning them to x and y.
	*@param xIn The x coordinate.
	*@param yIn The y coordinate.
	**/
	public CartPoint(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
	
	/**
	*Returns the x coordinate.
	*@return the x coordinate.
	**/
	public int getX(){
		return x;
	}
	
	/**
	*Returns the y coordinate.
	*@return the y coordinate.
	**/
	public int getY(){
		return y;
	}
	
	/**
	*This method sets a new x coordinate.
	*@param The new x coordinate.
	**/
	public void setX(int xIn){
		x = xIn;
	}
	
	/**
	*This method sets a new y coordinate.
	*@param The new y coordinate.
	**/
	public void setY(int yIn){
		y = yIn;
	}
}