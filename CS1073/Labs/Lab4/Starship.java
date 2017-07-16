/**
*This class creates a Starship object and provides methods to retrieve and edit its information.
*@author Paul Armstrong 3537294
**/
public class Starship{
  /**
  *The name of the ship.
  **/
  private String shipName;
  /**
  *The number of HP the ship has.
  **/
  private int health;
  /**
  *The capitain of the ship.
  **/
  private Officer captain;
  /**
  *The first officer of the ship.
  **/
  private Officer firstOfficer;
  /**
  *The chief engineer of ship.
  **/
  private Officer chiefEng;
  
  /**
  *Constructs a new starship object by taking in a name, health value and 3 officers.
  *@param nameIn The ships name.
  *@param healthIn The ships HP.
  *@param captainIn The capitain of the ship.
  *@param firstOfficer The first officer of the ship.
  *@param chiefEng The chief engineer of the ship.
  **/
  public Starship(String nameIn, int healthIn, Officer captainIn, Officer firstOfficerIn, Officer chiefEngIn){
    shipName = nameIn;
    health = healthIn;
    captain = captainIn;
    firstOfficer = firstOfficerIn;
    chiefEng = chiefEngIn;
  }
  
  /**
  *Accessor method for the ships data.
  *@return Ships name, HP and crew.
  **/
  public String toString(){
    int strength = (captain.getStrength() * 3) + firstOfficer.getStrength() + (chiefEng.getStrength() * 2);
	return shipName + "(" + health + "HP): " + captain + ", " + firstOfficer + ", " + chiefEng + ", " + strength;
  }
  
  /**
  *Accessor to determine teh damage delt to the ship.
  *@param attackpoints The strength of the attcking ship.
  *@return Ships name, current HP value and damaged received.
  **/
  public String getsAttacked(int attackpoints){
    int strength = (captain.getStrength() * 3) + firstOfficer.getStrength() + (chiefEng.getStrength() * 2);
	if((strength/2) >= attackpoints){
    health -= 0;
    }
    else{
      health -= (attackpoints - (strength/2));
    }
    return shipName + "(" + health + "HP): " + "received " + (strength - (attackpoints/2)) + " damage";
  }
  
  /**
  *Accessor to determine whether or not a ship has been destroyed.
  *@return If the ship is destroyed.
  **/
  public boolean isDestroyed(){
    boolean destroyed;
    if(health <= 0){
      destroyed = true;
    }
    else{
      destroyed = false;
    }
    return destroyed;
  }
  
  /**
  *Accessor method to simulate a battle and then print out the results.
  *@param underAttack The ship under attack.
  *@return The outcome of the battle.
  **/
  public String attackShip(Starship underAttack){
    int strength = (captain.getStrength() * 3) + firstOfficer.getStrength() + (chiefEng.getStrength() * 2);
	return underAttack.getsAttacked(strength);
  }
}
