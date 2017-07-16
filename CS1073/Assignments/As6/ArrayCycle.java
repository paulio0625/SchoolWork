import java.util.Random;

public class ArrayCycle{
	private int array[];
	private Random num;
	
	public ArrayCycle(int lengthIn, long seedIn){
		array = new int[lengthIn];
		for(int i = 0; i < lengthIn; i++){
			array[i] = i;
		}
		
		num = new Random(seedIn);
	}
	
	public void shuffle(int times){
		for(int x = 0; x < times; x++){
			int index1 = num.nextInt(array.length);
			int index2 = num.nextInt(array.length);
			
			int temp = array[index1];
			
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}
	
	private int cycleLength(int index){
		int original = index;
		int counter = 0;
		
		do{
			index = array[index];
			counter++;
		}while(index != original);
		return counter;
	}
	
	private String cycleString(int index){
		String cycle = "";
		int original = index;
		
		do{
			cycle += (index + " -> ");
			index = array[index];
		}while(original != index);
		cycle += original;
		return cycle;
	}
	
	
	public String getLongestCycle(){
		int currentLargest = 0;
		int largestIndex = 0;
		for(int index = 0; index < array.length; index++){
			if(currentLargest < this.cycleLength(index)){
				currentLargest = this.cycleLength(index);
				largestIndex = index;
			}
		}
		
		return this.cycleLength(largestIndex) + "\n" + this.cycleString(largestIndex);
	}
}