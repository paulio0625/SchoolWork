import java.util.LinkedList;
import java.io.Serializable;

public class QuestionQueue implements Serializable{
	LinkedList<Question> list = new LinkedList<Question>();	


	public QuestionQueue(){
		
	}

	public void enqueue(Question q){
		list.add(q);
	}

	public Question dequeue(){
		return list.pop();
	}

	public Question peek(){
		return list.peek();
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public String toString(){
		String print = "";
		
		for(int i = 0; i < list.size(); i++){
			print += (i+1 + ". " + list.get(i).toString() + "\n");
		}

		return print;
	}
}
