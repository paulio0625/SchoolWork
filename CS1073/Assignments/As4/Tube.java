/**
*This class creates a tube object and offers methods to retrieve information about it.
*@author Paul Armstrong 3537294.
**/
public class Tube{
	/**
	*The radius of the tube.
	**/
	private double radius;
	/**
	*The height of the tube.
	**/
	private double height;
	
	/**
	*Constructs a new tube object using a radius and height value.
	*@param radiusIn The radius of the tube.
	*@param heightIn The height of the tube.
	**/
	public Tube(double radiusIn, double heightIn){
		radius = radiusIn;
		height = heightIn;
	}
	
	/**
	*Accessor method for the radius of the tube.
	*@return The radius of the tube.
	**/
	public double getRadius(){
		return radius;
	}
	
	/**
	*Accessor method for the height of the tube.
	*@return The height of the tube.
	**/
	public double getHeight(){
		return height;
	}
	
	/**
	*Accessor method for determining the volume of the cube.
	*@return The volume of the cube.
	**/
	public double volume(){
		return (Math.PI * (radius * radius) * height);
	}
	
	/**
	*Accessor method for determining the surface area of the tube.
	*@return The surface area of the tube.
	**/
	public double surfaceArea(){
		return ((2 * Math.PI * radius * height) + (2 * Math.PI * (radius * radius)));
	}
}