/**
*TrackableEnvelope is a child to Envelope.
*@author Daly Weeks, Paul Armstrong
**/
public class TrackableEnvelope extends Envelope{
  private String trackingCode;
  private String trackingState;
/** 
*This is the constructor method for TrackableEnvelopes. It takes in 4 parameters and sets the trackingState and the boolean sent to not yet sent.
*@param startIn is an Address that relates to the start.
*@param endIn is an Address that relates to the end.
*@param weightIn is a double that relates to weight.
*@param trackingCodeIn is a String that relates to trackingCode.
**/
  public TrackableEnvelope(Address startIn, Address endIn, double weightIn, String trackingCodeIn){
    super(startIn, endIn, weightIn);
    trackingCode = trackingCodeIn;
    trackingState = "Not sent yet";
  }
/**
*calculateCost returns the cost of mailing the TrackableEnvelope as a double.
*@return the cost in dollars to mail the TrackableEnvelope.
**/
  public double calculateCost(){
    return (super.calculateCost() + 10.0);
  }
/**
*Send sets the boolean sent to true and the trackingState to dispatched.
**/
  public void send(){
    super.send();
    trackingState = "Dispatched";
  }
/**
*arriveAtHub checks if the TrackableEnvelope is sent and returns a boolean to confirm if the TrackableEnvelope has arrived at the Hub or not and
*sets the trackingState to at mailing hub.
*@return boolean representing if the TrackableEnvelope has arrived at hub or not.
**/
  public boolean arriveAtHub(){
    if(super.isSent()){
      trackingState = "At mailing hub";
    }
    return super.isSent();
  }
/**
*hasArrivedAtHub checks if the TrackableEnvelope is at the hub or not and returns a boolean to show.
*@return a boolean representing if the mail is at the hub or not.
**/
  public boolean hasArrivedAtHub(){
    boolean atHub = false;
    if(trackingState == "At mailing hub"){
      atHub = true;
    }
    return atHub;
  }
/**
*deliver checks the trackingState to make sure it arrived at the hub first, then sets the trackingState
*to delivered or not. then, returns a boolean if it was delivered or not.
*@return a boolean representing if it has been delivered or not.
**/
  public boolean deliver(){
    boolean atDeliver = false;
    if(trackingState == "At mailing hub"){
    trackingState = "Delivered";
    atDeliver = true;
    }
    return atDeliver;
  }
/** 
*isDelivered checks if the TrackableEnvelope has been delivered yet and returns if it has or not.
*@return the boolean if the TrackableEnvelope has been deliered or not.
**/
  public boolean isDelivered(){
    boolean atDelivered = false;
    if(trackingState == "Delivered"){
      atDelivered = true;
    }
    return atDelivered;
  }
/** 
*toString returns a textual representation of the TrackableEnvelope.
*@return a String, a textual representation of the TrackableEnvelope.
**/
  public String toString(){
    return (trackingCode + "\n" + super.toString() + trackingState + "\n");
  }
}