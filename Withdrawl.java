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

public class Withdrawl extends JFrame implements ActionListener {
	JTextField amount;
	JButton back,withdraw;
	String pinnumber;

	Withdrawl(String pinnumber){
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
			JLabel text = new JLabel("Enter the amount you want to withdraw");
			text.setBounds(190,280,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("System",Font.BOLD,16));
			image.add(text);
		    amount= new JTextField();
			amount .setBounds(200,330,290,30);
			amount.setBackground(Color.white);
			amount.setForeground(Color.black);
			amount .setFont(new Font("Arial",Font.BOLD,15));
			image.add(amount);
			withdraw = new JButton("Withdraw");
			withdraw.setForeground(Color.black);
			withdraw.setFont(new Font("Raleway",Font.BOLD,15));
			withdraw.setBounds(340,400,150,30);
			withdraw.addActionListener(this);
			image.add(withdraw);
			 back = new JButton("Back");
			back.setForeground(Color.black);
			back.setFont(new Font("Raleway",Font.BOLD,15));
			back.setBounds(340,435,150,30);
			back.addActionListener(this);
			image.add(back);
	}
	public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource() == withdraw) {
			 String number = amount.getText();
			 Date date = new Date();
			 String dtstr = date.toString();
			 String[] sep = dtstr.split(" ");
			 String datesep = sep[1]+" "+sep[2]+" "+sep[sep.length-1];
			 String timesep = sep[3];
			 System.out.println(datesep);
			 System.out.println(timesep);
			 
			 
			 System.out.println(date);
			 if(number.equals("")) {
				 JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
				 
			 }
			 else {
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
				 int withdrawalAmount = Integer.parseInt(number);
				 
				int balance1 = totalamount-totalwithdraw;
				 if(withdrawalAmount < balance1) {
					int newbalance = balance1-withdrawalAmount;
					 if(newbalance > 1000) {
						 String query = "insert into bank values('"+pinnumber+"','"+datesep+"','"+timesep+"','Withdraw','"+number+"')";
						 System.out.println(query);
						 con.s.executeUpdate(query);
						// String query2 = "update bank set amount = '"+newBalance+"'where type = 'Deposit'";
						 //System.out.println(query2);
						 //con.s.executeUpdate(query2);
						 JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw successfully");
						 //setVisible(false);
						 //new Transactions(pinnumber);
					 }
					 else {
						 JOptionPane.showMessageDialog(null,"Insufficient Balance");
						 
						 
						 
					 }
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Insufficient Balance");
					
					 
				 }
	
	    
	    
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }
			 }
		 }
		 else if(ae.getSource() == back) {
			 setVisible(false);
			 new Transactions(pinnumber);
		 }
		
	}

	public static void main(String[] args) {
		//new Withdrawl("");

	}

}
