public class Tenant{
	private String name;
	private String phoneNum;
	private int aptNum;
	private static int member = 10000;
	private final int memberNum;
	private LendingItem[] out;
	private int counter;
	
	public Tenant(String nameIn, int aptNumIn, String phoneNumIn){
		name = nameIn;
		phoneNum = phoneNumIn;
		aptNum = aptNumIn;
		memberNum = member;
		member++;
		out = new LendingItem[7];
		counter = 0;
	}
	
	public String getName(){
		return name;
	}
	public int getAptNumber(){
		return aptNum;
	}
	public String getPhoneNumber(){
		return phoneNum;
	}
	public int getMembershipNumber(){
		return memberNum;
	}
	public int getCounter(){
		return counter;
	}
	public LendingItem[] getSignedOutItems(){
		LendingItem[] temp = new LendingItem[counter];
		for(int i = 0; i < counter; i++){
			temp[i] = out[i];
		}
		return temp;
	}
	
	public void setPhoneNumber(String newNum){
		phoneNum = newNum;
	}
	
	public boolean signOut (LendingItem item){
		boolean complete = false;
		if(counter <= 6){
			out[counter] = item;
			counter++;
			complete = true;
		}
		return complete;
	}
	
	public boolean returnItem (LendingItem item){
		boolean complete = false;
		for(int i = 0; i < counter; i++){
			if(out[i].equals(item)){
				for(int x = i+1; x < counter; x++){
					out[x-1] = out[x];
				}
				counter--;
				complete = true;
			}
		}
		return complete;
	}
}