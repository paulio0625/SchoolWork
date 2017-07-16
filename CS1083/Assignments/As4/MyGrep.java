/**
*@author Paul Armstrong, 3537294
**/
import java.util.Scanner;
import java.io.*;

public class MyGrep{
	public static void main(String[]args){
		String file;
		String search;
		Scanner sc = new Scanner(System.in);
		
		if(args.length < 2){
			System.out.println("You need a string to look for and a file to look in.");
			System.out.println("String to look for.");
			
			search = sc.nextLine();
			
			System.out.println("The name of the file.");
			
			file = sc.nextLine();
		}//end if
		else{
			search = args[0];
			file = args[1];
		}//end else
		
		boolean done = false;
		int found = 0;
		while(!done){
			try{
				Scanner fileScan = new Scanner(new File(file));
				int lineNum = 0;
				String currentLine;
				String output = "";
				
				while(fileScan.hasNext()){
					currentLine = fileScan.nextLine();
					lineNum++;
					Scanner word = new Scanner(currentLine);
					
					if(currentLine.contains(search)){
						output += lineNum + ": " + currentLine + "\n";
						found++;
					}//end if
				}//end while
				
				System.out.println(output);
				done = true;
			}//end try
			catch(FileNotFoundException e){
				System.err.println(file + " does not exist or is located elsewhere.");
				System.err.println("Please specifiy the input file or enter Q to exit.");
				file = sc.nextLine();
				
				if(file.equalsIgnoreCase("Q")){
					done = true;
				}//end if
			}//end catch
		}//end while
		System.out.println("Lines containing " + search + ": " + found);
	}//end main
}//end class