/**
*This class creates a box object and offers methods to retrieve information about it.
*@author Paul Armstrong 3537294.
**/
public class Box{
	/**
	*The length of the cube.
	**/
	private double length;
	/**
	*The width of the cube.
	**/
	private double width;
	/**
	*The height of the cube.
	**/
	private double height;
	
	/**
	*Constructs a new box object using a length, width and height value.
	*@param lengthIn The length of the box.
	*@param widthIn The width of the box.
	*@param heightIn The height of the box.
	**/
	public Box(double lengthIn, double widthIn, double heightIn){
		length = lengthIn;
		width = widthIn;
		height = heightIn;
	}
	
	/**
	*Accessor method for the length of the box.
	*@return The length of the box.
	**/
	public double getLength(){
		return length;
	}
	
	/**
	*Accessor method for the width of the box.
	*@return The width of the box.
	**/
	public double getWidth(){
		return width;
	}
	
	/**
	*Accessor method for the height of the box.
	*@return The height of the box.
	**/
	public double getHeight(){
		return height;
	}
	
	/**
	*Accessor method to determine the volume of the cube.
	*@return The volume of the cube.
	**/
	public double volume(){
		return (length * width * height);
	}
	
	/**
	*Accessor method to determine the surface area of the cube.
	*@return The surface area of the cube.
	**/
	public double surfaceArea(){
		return ((2*(length * width)) + (2*(length * height)) + (2*(width * height)));
	}
}