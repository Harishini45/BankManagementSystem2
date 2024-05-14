package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton back,deposit;
	String pinnumber;
 Deposit(String pinnumber){
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
		JLabel text = new JLabel("Enter the amount you want to deposit");
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
	    deposit = new JButton("Deposit");
		deposit.setForeground(Color.black);
		deposit.setFont(new Font("Raleway",Font.BOLD,15));
		deposit.setBounds(340,400,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		 back = new JButton("Back");
		back.setForeground(Color.black);
		back.setFont(new Font("Raleway",Font.BOLD,15));
		back.setBounds(340,435,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
 }
 public void actionPerformed(ActionEvent ae) {
	 if(ae.getSource() == deposit) {
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
			 JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
			 
		 }
		 else {
			 try {
			 Conn con = new Conn();
String query = "insert into bank values('"+pinnumber+"','"+datesep+"','"+timesep+"','Deposit','"+number+"')";
 System.out.println(query);
 con.s.executeUpdate(query);
 JOptionPane.showMessageDialog(null,"Rs "+number+" deposited successfully!!!");
    setVisible(false);
    new Transactions(pinnumber);
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
		
		//new Deposit("");

	}

}
