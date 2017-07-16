/**
*Represents a cave that gas will be stored in.
*@author Paul Armstrong, 3537294
**/
import java.util.*;

public class GasStorage{
	/**
	*Holds the representation of the cave in 1 and 0 form
	**/
	private char[][] cave;
	
	/**
	*Creates the representation of the cave by taking in two ints and the layout of 
	*the cave one line at a time.
	*@param row The number of rows int the array.
	*@param column the number of columns in the array.
	**/
	public GasStorage(int row, int column){
		cave = new char[row][column];
		
		this.create();
	}
	
	/**
	*This method reads in the layout of the cave one line at a time picking the lines apart into the
	*individual 1s and 0s and putting them into the array.
	**/
	public void create(){
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < cave.length; i++){
			String num = sc.nextLine();
			for(int x = 0; x < num.length(); x++){
				cave[i][x] = num.charAt(x);
			}
		}
	}
	
	/**
	*This method outputs the string representation of the array in its current form.
	*@return The current representation of the table.
	**/
	public String table(){
		String message = "";
		
		for(int i = 0; i < cave.length; i++){
			for(int x = 0; x < cave[0].length; x++){
				message += cave[i][x];
			}
			message += "\n";
		}
		
		return message;
	}
	
	/**
	*This method calculates and returns the area of the cave by scanning for any 0s connected to the point
	*which the programm is assessing. After those points have been added to the total it changes them to 2s.
	*@return The area of the cave.
	**/
	public int area(){
		int size = 0;
		int xPos = 0;
		int yPos = 0;
		ArrayList<CartPoint> list = new ArrayList<CartPoint>(1); 
		
		for(int i = 0; i < cave[0].length; i++){
			if(cave[0][i] == '0'){
				size++;
				list.add(new CartPoint(i, yPos));
				cave[yPos][i] = '2';
			}
		}
		
		while(list.size() > 0){
			xPos = list.get(0).getX();
			yPos =  list.get(0).getY();
			list.remove(0);
			
			if((xPos < (cave[yPos].length-1)) && (cave[yPos][xPos+1] == '0')){
				size++;
				list.add(new CartPoint(xPos+1, yPos));
				cave[yPos][xPos+1] = '2';
			}
			if((xPos > 0) && (cave[yPos][xPos-1] == '0')){
				size++;
				list.add(new CartPoint(xPos-1, yPos));
				cave[yPos][xPos-1] = '2';
			}
			if((yPos > 0) && (cave[yPos-1][xPos] == '0')){
				size++;
				list.add(new CartPoint(xPos, yPos-1));
				cave[yPos-1][xPos] = '2';
			}
			if((yPos < (cave.length-1)) && (cave[yPos+1][xPos] == '0')){
				size++;
				list.add(new CartPoint(xPos, yPos+1));
				cave[yPos+1][xPos] = '2';
			}
		}
		
		return size;
	}
}