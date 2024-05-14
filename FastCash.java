package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	JButton rs100,rs300,rs500,rs1000,rs2000,rs9000,rs10000,exit;
	String pinnumber;
	FastCash(String pinnumber){
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
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(205,280,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		rs100 = new JButton("RS 100");
		rs100.setForeground(Color.black);
		rs100.setFont(new Font("Raleway",Font.BOLD,15));
		rs100.setBounds(180,320,150,30);
		rs100.addActionListener(this);
		image.add(rs100);
		rs300 = new JButton("RS 300");
		rs300.setForeground(Color.black);
		rs300.setFont(new Font("Raleway",Font.BOLD,15));
		rs300.setBounds(340,320,150,30);
		rs300.addActionListener(this);
		image.add(rs300);
		rs500 = new JButton("RS 500");
		rs500.setForeground(Color.black);
		rs500.setFont(new Font("Raleway",Font.BOLD,15));
		rs500.setBounds(180,360,150,30);
		rs500.addActionListener(this);
		image.add(rs500);
		 rs2000 = new JButton("RS 2000");
		 rs2000.setForeground(Color.black);
		 rs2000.setFont(new Font("Raleway",Font.BOLD,15));
		 rs2000.setBounds(340,360,150,30);
		 rs2000.addActionListener(this);
		image.add(rs2000);
		 rs1000= new JButton("RS 1000");
		 rs1000.setForeground(Color.black);
		 rs1000.setFont(new Font("Raleway",Font.BOLD,15));
		 rs1000.setBounds(180,400,150,30);
		 rs1000.addActionListener(this);
		image.add(rs1000);
		 rs9000= new JButton("RS 9000");
		 rs9000.setForeground(Color.black);
		 rs9000.setFont(new Font("Raleway",Font.BOLD,15));
		 rs9000.setBounds(340,400,150,30);
		 rs9000.addActionListener(this);
		image.add(rs9000);
		 rs10000= new JButton("RS 10000");
		 rs10000.setForeground(Color.black);
		 rs10000.setFont(new Font("Raleway",Font.BOLD,15));
		 rs10000.setBounds(180,435,150,30);
		 rs10000.addActionListener(this);
		image.add(rs10000);
		 exit= new JButton("Exit");
		 exit.setForeground(Color.black);
		 exit.setFont(new Font("Raleway",Font.BOLD,15));
		 exit.setBounds(340,435,150,30);
		 exit.addActionListener(this);
		image.add(exit);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			setVisible(false);
			new Transactions(pinnumber);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText();
			String cash = amount.substring(3);
			//int cashWithdraw = Integer.parseInt(cash);
			Conn con = new Conn();
			try {
				String balance = "select * from bank where pin = '"+pinnumber+"'";
				System.out.println(balance);
				 ResultSet rs = con.s.executeQuery(balance);
				 //String bal = "";
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
				 int withdrawalAmount = Integer.parseInt(cash);
				 Date date = new Date();
				 String dtstr = date.toString();
				 String[] sep = dtstr.split(" ");
				 String datesep = sep[1]+" "+sep[2]+" "+sep[sep.length-1];
				 String timesep = sep[3];
				int balance1 = totalamount-totalwithdraw;
				 if(withdrawalAmount < balance1) {
					int newbalance = balance1-withdrawalAmount;
					 if(newbalance > 1000) {
						 String query = "insert into bank values('"+ pinnumber +"','"+datesep+"','"+timesep+"','Withdraw','"+cash+"')";
						 System.out.println(query);
						 con.s.executeUpdate(query);
						// String query2 = "update bank set amount = '"+newBalance+"'where type = 'Deposit'";
						 //System.out.println(query2);
						 //con.s.executeUpdate(query2);
						 JOptionPane.showMessageDialog(null,"Rs "+cash+" Withdraw successfully");
						 
						 //new Transactions(pinnumber);
					 }
					 else {
						 JOptionPane.showMessageDialog(null,"Rs "+" Insufficient Balance");
						 setVisible(false);
						 new Transactions(pinnumber);
						 
						 
					 }
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Rs "+" Insufficient Balance");
					 setVisible(false);
					 new Transactions(pinnumber);
					 
				 }
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		//new FastCash("");

	}

}
