import java.util.Scanner;
import java.io.*;

public class Moderator{
	public static void main(String[] args)throws IOException{
		QuestionQueue queue = new QuestionQueue();
		Question q;
		Scanner in = new Scanner(System.in);

		String question = "No submitted questions pending.";
		String name ="";
		int i = 1;
		String choice;
	
		while(i != 0){
			System.out.println("");
			System.out.println(question);
			System.out.println("Moderator options:");
			System.out.println("N = Add a new question");
			System.out.println("A = Ask current question");
			System.out.println("P = Pass on current question");
			System.out.println("Q = Quit");
			System.out.print("Enter your choice: ");
			
			choice = in.nextLine();

			switch(choice){
				case "N": System.out.println("Enter question:");
						  question = in.nextLine();
						  System.out.println("Submitted by:");
						  name = in.nextLine();
						  q = new Question(question, name);
						  queue.enqueue(q);
						  question = ("Current question: " + queue.peek());
				break;
				case "A": 
						
						try{
								System.out.println("Question asked.");
								queue.dequeue();
								if(queue.peek() == null){
								 question = ("No submitted questions pending.");
								}										
						   		else {question = ("Current question: " + queue.peek());}
								
						  }
						catch (java.util.NoSuchElementException e) {
							 System.err.println("Error - No question pending");
						}
						
						
				break;
				case "P": System.out.println("Passed.");
						  queue.enqueue(queue.dequeue());
						  question = ("Current question: " + queue.peek());
				break;
				case "Q": System.out.println("Unused questions archived to: QuestionPool.dat");
						  
						  FileOutputStream out = new FileOutputStream("QuestionPool.dat");
						  BufferedOutputStream buf = new BufferedOutputStream(out);
						  ObjectOutputStream s = new ObjectOutputStream(buf);

						  s.writeObject(queue);
						  s.flush();
						  out.close();
						  
						  i = 0;
				break;
			}
		}
	}
}
