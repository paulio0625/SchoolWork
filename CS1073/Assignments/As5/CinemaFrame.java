/**
*This class creates a GUI containing several buttons and one text feild that allows the user to calculate the the price of going to the movies.
*@author Paul Armstrong 3537294
**/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class CinemaFrame extends JFrame implements ActionListener{
	/**
	*A special button for an adult ticket.
	**/
	private ProductButton aTicket;
	/**
	*A special button for a child ticket.
	**/
	private ProductButton cTicket;
	/**
	*A special button for a senior ticket.
	**/
	private ProductButton sTicket;
	/**
	*A special button for popcorn
	**/
	private ProductButton popcorn;
	/**
	*A special button for pop.
	**/
	private ProductButton pop;
	/**
	*A special button for candy.
	**/
	private ProductButton candy;
	private JLabel coupon;
	/**
	*A field to input the amount of the coupon.
	**/
	private JTextField couponAmount;
	/**
	*A button to redeem the coupon.
	**/
	private JButton redeem;
	/**
	*A label with the current price of the movie.
	**/
	private JLabel currentTotal;
	/**
	*A button to reset the GUI.
	**/
	private JButton next;
	/**
	*The cost of the movie.
	**/
	private double total;
	
	/**
	*This constructor creates the GUI with all of the buttons, labels and fields and the specifies which buttons the program has to watch for actions to occur.
	**/
	public CinemaFrame(){
		setSize(600,400);
		total = 0;
		
		JLabel instructions = new JLabel("Click on the products that the customer wishes to purchase:");
		JPanel topPanel = new JPanel();
		topPanel.add(instructions);
		
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		aTicket = new ProductButton("Adult Ticket", 12.50);
		aTicket.addActionListener(this);
		cTicket = new ProductButton("Child Ticket", 6.25);
		cTicket.addActionListener(this);
		sTicket = new ProductButton("Senior Ticket", 8.75);
		sTicket.addActionListener(this);
		popcorn = new ProductButton("Popcorn", 5.50);
		popcorn.addActionListener(this);
		pop = new ProductButton("Pop", 2.75);
		pop.addActionListener(this);
		candy = new ProductButton("Candy", 3.25);
		candy.addActionListener(this);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 3));
		centerPanel.add(aTicket);
		centerPanel.add(cTicket);
		centerPanel.add(sTicket);
		centerPanel.add(popcorn);
		centerPanel.add(pop);
		centerPanel.add(candy);
		
		coupon = new JLabel("Coupon: $ ");
		couponAmount = new JTextField(5);
		redeem = new JButton("Redeem");
		redeem.addActionListener(this);
		currentTotal = new JLabel("Current total: " + nf.format(total));
		next = new JButton("Next Customer");
		next.addActionListener(this);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(coupon);
		bottomPanel.add(couponAmount);
		bottomPanel.add(redeem);
		bottomPanel.add(currentTotal);
		bottomPanel.add(next);
		
		Container contentPane = getContentPane();
		contentPane.add(topPanel, BorderLayout.PAGE_START);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.PAGE_END);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	*This method specifies what each button does.
	**/
	public void actionPerformed(ActionEvent e){
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		if(e.getSource() == aTicket){
			total += aTicket.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == cTicket){
			total += cTicket.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == sTicket){
			total += sTicket.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == popcorn){
			total += popcorn.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == pop){
			total += pop.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == candy){
			total += candy.getPrice();
			currentTotal.setText("Current total: " + nf.format(total));
		}
		if(e.getSource() == redeem){
			total -= Double.parseDouble(couponAmount.getText());
			currentTotal.setText("Current total: " + nf.format(total));
			couponAmount.setText("");
		}
		if(e.getSource() == next){
			total = 0;
			currentTotal.setText("Current total: " + nf.format(total));
		}
	}
	
	public static void main(String[]args){
		new CinemaFrame().setVisible(true);
	}
}