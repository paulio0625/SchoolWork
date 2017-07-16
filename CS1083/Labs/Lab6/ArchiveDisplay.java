import java.io.*;

public class ArchiveDisplay{
	public static void main(String [] args){
		ObjectInputStream s = null;
			
		try{		
			FileInputStream in =  new FileInputStream("QuestionPool.dat"); 
			BufferedInputStream buf = new BufferedInputStream(in); 
			s = new ObjectInputStream(buf);

			System.out.println("Here are the archived questions...");

			for(int i = 1; i>-1; i++){
				System.out.println(s.readObject());
			}
		}
		catch(EOFException e){
			System.err.println("");
		}
		catch(FileNotFoundException e2){
			System.err.println("QuestionPool.dat is not found");
		}
		catch(IOException e3){
			System.err.println("There is an IOException");
		}
		catch(ClassNotFoundException e4){
			System.err.println("There is a ClassNotFoundException");
		}
		
		finally{
			try{
				s.close();
			}
			catch(IOException e5){
				System.err.println("There is an IOException");
			}
		}
	}
}
