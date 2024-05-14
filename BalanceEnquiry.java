package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JButton exit;
	String pinnumber;

	BalanceEnquiry(String pinnumber){
		this.pinnumber = pinnumber;
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmh.jpg"));
			Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(0,0,900,750);
			add(image);
			setLayout(null);
			//setUndecorated(true);
			setSize(900,750);
			setLocation(300,0);
			setVisible(true);
			JLabel text = new JLabel("Your Bank Balance");
			text.setBounds(230,280,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("System",Font.BOLD,18));
			image.add(text);
			exit= new JButton("Exit");
			 exit.setForeground(Color.black);
			 exit.setBackground(Color.white);
			 exit.setFont(new Font("Raleway",Font.BOLD,15));
			 exit.setBounds(250,435,150,30);
			 exit.addActionListener(this);
			image.add(exit);
			 try {
				 Conn con = new Conn();
				 String balance = "select * from bank where pin = '"+pinnumber+"'";
				 ResultSet rs = con.s.executeQuery(balance);
				// String bal = "";
				 int totalamount = 0;
				 int totalwithdraw = 0;
				 while(rs.next()) {
					String type = rs.getString(4);
					if(type.equals("Deposit")) {
						totalamount += Integer.parseInt(rs.getString(5));
					}
					if(type.equals("Withdraw")) {
						totalwithdraw += Integer.parseInt(rs.getString(5));
					}
				
				 }
				 int balance1 = totalamount-totalwithdraw;
					JLabel bal = new JLabel(""+balance1);
					bal.setBounds(270,320,200,35);
					bal.setForeground(Color.white);
					bal.setFont(new Font("System",Font.BOLD,18));
					image.add(bal);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
				 
				
				
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			setVisible(false);
			new Transactions(pinnumber);
		}
				
				
	    
	    
				
		
	}

	public static void main(String[] args) {
		//new BalanceEnquiry("");

	}

	

}
