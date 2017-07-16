public class ShortTermTenant extends Tenant{
	private String leaving;
	
	public ShortTermTenant(String nameIn, int aptNumIn, String phoneNumIn, String leavingIn){
		super(nameIn, aptNumIn, phoneNumIn);
		leaving = leavingIn;
	}
	
	public boolean signOut(LendingItem item){
		boolean success = false;
		if((super.getCounter() <= 6) && (!item.isCollectorsCopy())){
			super.signOut(item);
			success = true;
		}
		return success;
	}
	
	public String getDeparts(){
		return leaving;
	}
}