/**
*@author Paul Armstrong.
**/
import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;

public class Reader{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String outFile;
		
		if(args.length < 1){
			System.out.println("You need a name for the output file.");
			outFile = sc.nextLine();
		}//end if
		else{
			outFile = args[0];
		}//end else
		
		boolean done = false;
		Fundraiser obj;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		try{
			FileInputStream in = new FileInputStream("Merged.dat");
			BufferedInputStream buf = new BufferedInputStream(in);
			ObjectInputStream objIn = new ObjectInputStream(buf);
			
			FileWriter fw = new FileWriter (outFile);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter out = new PrintWriter (bw);
			
			while(!done){
				try{
					obj = (Fundraiser) objIn.readObject();
				
					out.println(nf.format(obj.getMoneyRaised()) + " - " + obj.getName());
				}//end try
				catch(EOFException e1){
					done = true;
				}//end catch
			}//end while
			out.close();
		}//end try
		catch(FileNotFoundException e2){
			
		}
		catch(ClassNotFoundException e3){
			
		}
		catch(IOException e4){
			
		}//end catch
	}//end main
}//end class