import java.util.Scanner;
import java.text.NumberFormat;
import java.io.*;

public class Charity{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String file1;
		String file2;
		
		if(args.length < 2){
			System.out.println("You require two input files.");
			System.out.println("Your first input file.");
			
			file1 = sc.nextLine();
			
			System.out.println("Your second input file.");
			
			file2 = sc.nextLine();
		}//end if
		else{
			file1 = args[0];
			file2 = args[1];
		}//end else
		
		boolean done = false;
		
		double csaTotal = 0;
		double edsocTotal = 0;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		try{
			FileOutputStream out = new FileOutputStream("Merged.dat");
			BufferedOutputStream bufOut = new BufferedOutputStream(out);
			ObjectOutputStream objOut = new ObjectOutputStream(bufOut);
			
			Scanner fileImport1 = new Scanner(new File(file1));
			Scanner fileImport2 = new Scanner(new File(file2));
			
			String currentLine1 = fileImport1.nextLine();
			String currentLine2 = fileImport2.nextLine();
			
			Fundraiser obj1 = createObject(currentLine1);
			Fundraiser obj2 = createObject(currentLine2);
			Fundraiser temp;
			
			if(obj1.compareTo(obj2) > 0){
				objOut.writeObject(obj1);
				temp = obj2;
				csaTotal += obj1.getMoneyRaised();
				edsocTotal += obj2.getMoneyRaised();
			}//end if
			else{
				objOut.writeObject(obj2);
				temp = obj1;
				csaTotal += obj1.getMoneyRaised();
				edsocTotal += obj2.getMoneyRaised();
			}
			
			while(!done){
				if(fileImport1.hasNext() && fileImport2.hasNext()){
					currentLine1 = fileImport1.nextLine();
					currentLine2 = fileImport2.nextLine();
					
					obj1 = createObject(currentLine1);
					obj2 = createObject(currentLine2);
					
					if(obj1.compareTo(obj2) > 0){
						if(temp.compareTo(obj1) > 0){
							objOut.writeObject(temp);
							objOut.writeObject(obj1);
							temp = obj2;
						}//end if
						
						else if(temp.compareTo(obj1) < 0){
							if(temp.compareTo(obj2) > 0){
								objOut.writeObject(obj1);
								objOut.writeObject(temp);
								temp = obj2;
							}//end if
							else{
								objOut.writeObject(obj1);
								objOut.writeObject(obj2);
							}//end else
						}//end else if
					}//end if
					
					else if(obj1.compareTo(obj2) < 0){
						if(temp.compareTo(obj2) > 0){
							objOut.writeObject(temp);
							objOut.writeObject(obj2);
							temp = obj1;
						}//end if
						else if(temp.compareTo(obj2) < 0){
							if(temp.compareTo(obj1) > 0){
								objOut.writeObject(obj2);
								objOut.writeObject(temp);
								temp = obj1;
							}//end if
							else{
								objOut.writeObject(obj2);
								objOut.writeObject(obj1);
							}//end else
						}//end else if
					}//end else if
					csaTotal += obj1.getMoneyRaised();
					edsocTotal += obj2.getMoneyRaised();
				}//end if
				
				if(fileImport1.hasNext() && !(fileImport2.hasNext())){
					objOut.writeObject(temp);
					
					currentLine1 = fileImport1.nextLine();
					temp = createObject(currentLine1);
					
					csaTotal += temp.getMoneyRaised();
				}//end if
				
				if(!(fileImport1.hasNext()) && fileImport2.hasNext()){
					objOut.writeObject(temp);
					
					currentLine2 = fileImport2.nextLine();
					temp = createObject(currentLine2);
					
					edsocTotal += temp.getMoneyRaised();
				}//end if
				
				if(!(fileImport1.hasNext()) && !(fileImport2.hasNext())){
					objOut.writeObject(temp);
					done = true;
				}//end if
			}//end while
			
			System.out.println("All done!");
			System.out.println("The first group raised: " + nf.format(csaTotal));
			System.out.println("The second group raised: " + nf.format(edsocTotal));
			objOut.close();
		}//end try
		catch(FileNotFoundException e1){
			System.err.println();
			System.err.println("File not found:" + e1.getMessage());
			System.err.println("Please specifiy the input file or enter Q to exit.");
			file1 = sc.nextLine();
			
			if(file1.equalsIgnoreCase("Q")){
				done = true;
			}//end if
		}//end catch
		catch(IOException e2){
			System.out.println("Error using files: " + e2.getMessage());
		}
	}//end main
	
	public static Fundraiser createObject(String line){
		Scanner lineSplicer = new Scanner(line).useDelimiter(";");
		
		double value = Double.parseDouble(lineSplicer.next().substring(1));
		String lName = lineSplicer.next();
		String fName = lineSplicer.next();
		
		Fundraiser fund = new Fundraiser(fName + " " + lName);
		fund.addFundraisingMoney(value);
		
		return fund;
	}
}//end class