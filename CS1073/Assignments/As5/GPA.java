/**
*This program creates a GUI that calculates a students GPA by reading in values from the user.
*@author Paul Armstrong 3537294.
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class GPA extends JFrame implements ActionListener{
	/**
	*Button that is pressed to calculate the GPA.
	**/
	private JButton gpaButton;
	/**
	*Button that is pressed to reset teh GUI.
	**/
	private JButton clearGPA;
	private JLabel labelOne;
	private JLabel labelTwo;
	private JLabel labelThree;
	private JLabel labelFour;
	/**
	*Field for the number of credit hours given by a course.
	**/
	private JTextField hours;
	/**
	*Field for the letter grade achieved in the course.
	**/
	private JTextField letterGrade;
	/**
	*The number of credit hours given by the course.
	**/
	private double creditHours;
	/**
	*The total points achieved in the course.
	**/
	private double totalpoints;
	/**
	*The current cumulative GPA.
	**/
	private double cumulativeGPA;
	
	/**
	*This constructor creates the GUI and sets the default total points and credit hours of a student.
	**/
	public GPA(){
		setSize(300,200);
		
		labelOne = new JLabel("Course letter grade: ");
		letterGrade = new JTextField(2);
		labelTwo = new JLabel("Course credit hours: ");
		hours = new JTextField(2);
		gpaButton = new JButton("Add to GPA");
		gpaButton.addActionListener(this);
		clearGPA = new JButton("Clear GPA");
		clearGPA.addActionListener(this);
		labelThree = new JLabel("Welcome to my GPA calculator!");
		labelFour = new JLabel("Enter your 1st grade & credit hrs.");
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(labelOne);
		contentPane.add(letterGrade);
		contentPane.add(labelTwo);
		contentPane.add(hours);
		contentPane.add(gpaButton);
		contentPane.add(clearGPA);
		contentPane.add(labelThree);
		contentPane.add(labelFour);
		
		totalpoints = 0.0;
		creditHours = 0.0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	*This method specified what is to happen as each button is pressed.
	**/
	public void actionPerformed(ActionEvent e){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		nf.setGroupingUsed(true);
		
		String gp = "0";
		double points;
		
		if(e.getSource() == gpaButton){
			String grade = letterGrade.getText();
			switch(grade.toUpperCase()){
				case "A+": gp = "4.3";
				break;
				case "A": gp = "4";
				break;
				case "A-": gp = "3.7";
				break;
				case "B+": gp = "3.3";
				break;
				case "B": gp = "3.0";
				break;
				case "B-": gp = "2.7";
				break;
				case "C+": gp = "2.3";
				break;
				case "C": gp = "2.0";
				break;
				case "D": gp = "1.0";
				break;
				case "F": gp = "0.0";
				break;
				case "WF": gp = "0.0";
				break;
				default: gp = "Invalid";
				break;
			}
			
			if(gp.equals("Invalid")){
				labelThree.setText("Invalid grade - GPA not changed");
				labelFour.setText("Your cumulative GPA is: " + nf.format((cumulativeGPA)));
			}
			else{
				creditHours +=  Double.parseDouble(hours.getText());
				points = (Double.parseDouble(gp) * Double.parseDouble(hours.getText()));
				totalpoints += points;
				cumulativeGPA = totalpoints / creditHours;
				
				labelThree.setText("Points for this course: " + nf.format(points));
				labelFour.setText("Your cumulative GPA is: " + nf.format(cumulativeGPA));
			}
		}
		else{
			creditHours = 0.0;
			totalpoints = 0.0;
			labelThree.setText("Totals have been reset.");
			labelFour.setText("Enter your 1st grade & credit hrs.");
		}
	}
	
	public static void main(String[]args){
		new GPA().setVisible(true);
	}
}