/**
*This class creates an officer object and provides methods for accessing the information.
*@author Paul Armstrong 3537294
**/
public class Officer{
  /**
  *The name of the officer.
  **/
  private String name;
  /**
  *The rank of the officer.
  **/
  private String rank;
  /**
  *The strength value of the officer.
  **/
  private int strength;
  
  /**
  *Constructs a new officer object by taking in a name, rank, and strength value.
  *@param nameIn The name of the officer.
  *@param rankIn The rank of the officer.
  *@param strengthIn The strength value of the officer.
  **/
  public Officer(String nameIn, String rankIn, int strengthIn){
    name = nameIn;
    rank = rankIn;
    strength = strengthIn;
  }
  
  /**
  *Accessor to get the strength of the officer alone.
  *@return The strength value fo the officer.
  **/
  public int getStrength(){
	  return strength;
  }
  
  /**
  *Accessor to get all of the officers recorded info.
  @return The officers name, rank and strength value.
  **/
  public String toString(){
    return rank + " " + name + "(" + strength + ")";
  }
}