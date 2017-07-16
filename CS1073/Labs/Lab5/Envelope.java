/**
*Envelope is a class representing an envelope
*@author Daly Weeks, Paul Armstrong
**/
public class Envelope{
  private Address start;
  private Address end;
  private double weight;
  private boolean sent;
/** 
*This is the constructor method for envelopes. It takes in 3 parameters and assigns the sent boolean to false. 
*@param startIn takes in an Address that represents the start.
*@param endIn takes in an Address that represents the end.
*@param weightIn takes in a double that represents weight.
**/
  public Envelope(Address startIn, Address endIn, double weightIn){
    start = startIn;
    end = endIn;
    weight = weightIn;
    sent = false;
  }
/**
*isSent returns the boolean sent.
*@return the boolean sent.
**/  
  public boolean isSent(){
    return sent;
  }
/**
*Send sets the sent boolean to true.
**/
  public void send(){
    sent = true;
  }
/**
*swapAddresses switches the values of start and end.
**/
  public void swapAddresses(){
    Address thing = start;
	start = end;
	end = thing;
  }
/**
*calculateCost returns the cost of mailing, calculated by the weight times $0.10.
*@return returns the cost of mailing as a double.
**/
  public double calculateCost(){
    double cost;
    cost = (weight * 0.1);
    return cost;
  }
/**
*toString returns a string representation of the Envelope and all its instance variables.
*@return a string representation of the envelope.
**/
  public String toString(){
    return ("From: " + start.toString() + "\nTo: " + end.toString() + "\n");
  }
}