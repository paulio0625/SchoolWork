import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ModeratorGUI extends JFrame implements ActionListener {

	private JTextArea questionField;
	private JTextField inputField;
	private JTextField nameField;
	private JLabel currentQuestionLabel;
	private JLabel statusLabel;	
	private JLabel inputLabel;
	private JButton addButton, askButton,passButton,quitButton;

	QuestionQueue queue = new QuestionQueue();
	Question q;
	Scanner in = new Scanner(System.in);

	String question = "No submitted questions pending.";
	String name ="";
	
	public ModeratorGUI(){
		setSize (600, 300);

		currentQuestionLabel = new JLabel("Current question");
		questionField = new JTextArea(4,40);

		//questionField.setText(question);
		statusLabel = new JLabel(question);
		inputLabel = new JLabel("Input a new question and the submitter, then click Add button");
		inputField = new JTextField(40);
		nameField = new JTextField(40);
		inputField.setText("Enter a new question in this field");
		nameField.setText("Enter the submitter in this field");
		addButton = new JButton("Add a new question");
		askButton = new JButton("Ask current question");
		passButton = new JButton("Pass on current question");
		quitButton = new JButton("Quit(save unasked questions)");

		Dimension d = new Dimension(250,25);
		addButton.setPreferredSize(d);
		askButton.setPreferredSize(d);
		passButton.setPreferredSize(d);
		quitButton.setPreferredSize(d);
		
		addButton.addActionListener(this);
		askButton.addActionListener(this);
		passButton.addActionListener(this);
		quitButton.addActionListener(this);

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(currentQuestionLabel);
		contentPane.add(statusLabel);
		contentPane.add(questionField);
		
		contentPane.add(addButton);
		contentPane.add(askButton);
		contentPane.add(passButton);
		contentPane.add(quitButton);
		contentPane.add(inputLabel);
		contentPane.add(inputField);
		contentPane.add(nameField);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == addButton){
			question = inputField.getText();
			name = nameField.getText();
			q = new Question(question, name);
			queue.enqueue(q);
			questionField.setText(queue.peek().toString());
			statusLabel.setText("    New question added");
			
		}

		else if(event.getSource() == askButton){
	
			try{
				statusLabel.setText("       Question asked.");
				queue.dequeue();
				questionField.setText(queue.peek().toString());
			}
			catch (java.util.NoSuchElementException e) {
				statusLabel.setText("     Error - No question pending");
			}
			catch (NullPointerException e) {
				statusLabel.setText("     Error - No question pending");
				questionField.setText("No submitted questions pending.");
			}
			
		}
			
		else if(event.getSource() == passButton){
	
			statusLabel.setText("     Passed.");
			queue.enqueue(queue.dequeue());
			questionField.setText(queue.peek().toString());
						
		}
		else {
			try{
			statusLabel.setText("  Unused questions archived to: QuestionPool.dat");
			FileOutputStream out = new FileOutputStream("QuestionPool1.dat");
			BufferedOutputStream buf = new BufferedOutputStream(out);
			ObjectOutputStream s = new ObjectOutputStream(buf);

			s.writeObject(queue);
			s.flush();
			out.close();

			}
			catch (Exception e){
			}
			
		}

	}

	public static void main (String[] args) {
		new ModeratorGUI().setVisible(true);
	}

}
