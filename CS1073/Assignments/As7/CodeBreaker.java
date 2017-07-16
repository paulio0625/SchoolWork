import java.util.Scanner;

public class CodeBreaker{	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int rows = 0;
		if(sc.hasNextInt()){
			rows = sc.nextInt();
		}
		
		String message = "";
		if(sc.hasNextLine()){
			message = sc.nextLine();
		}
		
		String finalMessage = "";
		
		while(rows != 0){
			int pos = 0;
			
			int columns = message.length() / rows;
			char array[][] = new char[rows][columns];
			
			for(int i = 0; i < rows; i++){
				for(int x = columns - 1; x >= 0; x--){
					array[i][x] = message.charAt(pos);
					pos++;
				}
			
				i++;
			
				if(i < rows){
					for(int y = 0; y < columns; y++){
						array[i][y] = message.charAt(pos);
						pos++;
					}
				}
			
			}
		
			for(int i = 0; i < columns; i++){
				for(int x = 0; x < rows; x++){
					finalMessage += array[x][i];
				}
			}
			finalMessage += "\n";
			
			if(sc.hasNextInt()){
				rows = sc.nextInt();
			}
			if(sc.hasNextLine()){
				message = sc.nextLine();
			}
		}
		
		System.out.println(finalMessage);
		
	}
}