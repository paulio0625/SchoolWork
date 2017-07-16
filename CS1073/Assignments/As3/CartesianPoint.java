/** Represents a point in a 2D plane, defined as (x,y).
*/
public class CartesianPoint { 
	/** The location of the point in the X direction. */
	private double x; 

	/** The location of the point in the Y direction. */
	private double y; 

	/** Constructs a point from given x and y values.
	@param xVal The location of the point in the X direction. 
	@param yVal The location of the point in the Y direction. 
	*/
	public CartesianPoint(double xVal, double yVal) { 
		x = xVal; 
		y = yVal; 
	}

	/** Returns the x value for this point.
	@return The x value for this point.
	*/
	public double getX() { 
		return x;
	}

	/** Returns the y value for this point.
	@return The y value for this point.
	*/
	public double getY() {
		return y;
	}

	/** Calculates the distance between this point and
	another point.
	@param other The other point.
	@return The distance between this point and
	another point.
	*/
	public double distance (CartesianPoint other) { 
		double dx = x - other.x; 
		double dy = y - other.y; 
		return Math.sqrt(dx*dx + dy*dy);
	}

	/** Returns a String representation of the x and y values
	for this point.
	@return A String representation of the x and y values
	for this point.
	*/
	public String toString() { 
		return "CartesianPoint[x=" + x + ", y=" + y + "]";
	}
}
