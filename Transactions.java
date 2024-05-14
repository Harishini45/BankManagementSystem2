package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{
	JButton deposit,withdrawl,pinchange,ministatement,fastcash,balanceEnquiry,exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,750);
		add(image);
		setLayout(null);
		setUndecorated(true);
		setSize(900,750);
		setLocation(300,0);
		setVisible(true);
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(205,280,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		 deposit = new JButton("Deposit");
		deposit.setForeground(Color.black);
		deposit.setFont(new Font("Raleway",Font.BOLD,15));
		deposit.setBounds(180,320,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setForeground(Color.black);
		withdrawl.setFont(new Font("Raleway",Font.BOLD,15));
		withdrawl.setBounds(340,320,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		fastcash = new JButton("Fast Cash");
		fastcash.setForeground(Color.black);
		fastcash.setFont(new Font("Raleway",Font.BOLD,15));
		fastcash.setBounds(180,360,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		 ministatement = new JButton("Mini Statement");
		ministatement.setForeground(Color.black);
		ministatement.setFont(new Font("Raleway",Font.BOLD,15));
		ministatement.setBounds(340,360,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		 pinchange= new JButton("Pin Change");
		pinchange.setForeground(Color.black);
		pinchange.setFont(new Font("Raleway",Font.BOLD,15));
		pinchange.setBounds(180,400,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		 balanceEnquiry= new JButton("Balance Enquiry");
		balanceEnquiry.setForeground(Color.black);
		balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,15));
		balanceEnquiry.setBounds(340,400,150,30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		 exit= new JButton("Exit");
		exit.setForeground(Color.black);
		exit.setFont(new Font("Raleway",Font.BOLD,15));
		exit.setBounds(250,435,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber);
		}
		else if(ae.getSource() == exit) {
			System.exit(0);
		}
		else if(ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber);
			
		}
		else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber);
			
		}
		else if(ae.getSource() == ministatement) {
			setVisible(false);
			new MiniStatement(pinnumber);
		}
        else if(ae.getSource() == balanceEnquiry) {
        	setVisible(false);
			new BalanceEnquiry(pinnumber);
			
		}
       else if(ae.getSource() == pinchange) {
    	   setVisible(false);
    	   new PinChange(pinnumber);
			
		}
	}

	public static void main(String[] args) {
		//new Transactions("");

	}

}
