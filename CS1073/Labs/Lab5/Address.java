/**
*Address is a class that represents an address
*@author Paul Armstrong, Daly Weeks
**/
public class Address{
  private int streetNum;
  private String streetName;
  private String postal;
/**
*This is the constructor method for addresses. it takes 3 parameters
*@param streetNumIn is a int that relates to StreetNum
*@param streetNameIn is a String that relates to the streetName
*@param postalIn is a String that relates to the postal
**/
  public Address(int streetNumIn, String streetNameIn, String postalIn){
    streetName = streetNameIn;
    streetNum = streetNumIn;
    postal = postalIn;
  }
/**
*toString is a method that returns a string representation of the address
*@return returns a string representation of the address
**/
  public String toString(){
    return (streetNum + " " + streetName + ", " + postal);
  }
}