/**
This class creates a line segment and offers methods to retreive information about the segment.
@author Paul Armstrong, 3537294
**/
public class LineSegment{
	/**
	The first endpoint of a line
	**/
	private CartesianPoint pointOne;
	/**
	The second endpoint of a line
	**/
	private CartesianPoint pointTwo;
	
	/**
	Constructs a new line segment by taking in two cartesian points for use as endpoints in a line.
	@param pointOneIn - The first endpoint.
	@param pointTwoIn - The second endpoint.
	**/
	public LineSegment(CartesianPoint pointOneIn, CartesianPoint pointTwoIn){
		pointOne = pointOneIn;
		pointTwo = pointTwoIn;
	}
	/**
	Constructs a new line segment by taking in four souble values to be used as endpoint for a line.
	@param xOneIn - The x coordinate of the first point.
	@param xTwoIn - The x coordinate of the second point.
	@param yOneIn - The y coordinate of the first point.
	@param yTwoIn - The y coordinate of the first point.
	**/
	public LineSegment(double xOneIn, double yOneIn, double xTwoIn, double yTwoIn){
		CartesianPoint a = new CartesianPoint(xOneIn, yOneIn);
		CartesianPoint b = new CartesianPoint(xTwoIn, yTwoIn);
		
		pointOne = a;
		pointTwo = b;
	}
	
	/**
	Accessor method for pointOne.
	@return The first point.
	**/
	public CartesianPoint getPointOne(){
		return pointOne;
	}
	
	/**
	Accessor method for pointTwo.
	@return The second point.
	**/
	public CartesianPoint getPointTwo(){
		return pointTwo;
	}
	
	/**
	Method to calculate the slope of a line and compare it to another line's slope.
	@return If the slopes are parallel.
	**/
	public boolean isParallelTo(LineSegment other){
		boolean parallel;
		if(pointTwo.getX() - pointOne.getX() == 0){
			if(other.getPointTwo().getX() - other.getPointOne().getX() == 0){
				parallel = true;
			}
			else{
				parallel = false;
			}
		}
		double slopeA = ((pointTwo.getY() - pointOne.getY()) / (pointTwo.getX() - 
		pointOne.getX()));
		
		double slopeB =((other.getPointTwo().getY() - other.getPointOne().getY()) / (other.getPointTwo().getX() - 
		other.getPointOne().getX()));
		
		if(slopeA == slopeB){
			parallel = true;
		}
		else{
			parallel = false;
		}
		return parallel;
	}
	
	/**
	Accessor to determine the length of the line.
	@return Length of the line.
	**/
	public double length(){
		return pointOne.distance(pointTwo);
	}
	
	/**
	Accessor to determine the midpoint of a line.
	@return The midpoint.
	**/
	public CartesianPoint midpoint(){
		CartesianPoint mid = new CartesianPoint(0.5 * (pointOne.getX() + pointTwo.getX()), 0.5 * (pointOne.getY() + pointTwo.getY()));
		return mid;
	}
}