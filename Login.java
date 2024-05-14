package bank.management.system;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;

public class Login extends JFrame implements ActionListener {//to create a folder click project folder click new click source and folder and paste images
	JButton login,clear,signup;
	JTextField cardtextfield;
	JPasswordField pintextfield;
	Login(){
		setSize(800,480);//(width,length)
		setVisible(true);
		setLocation(350,200);//from the left,from the top the frame appear(default the frame appears in top left corner)
		setTitle("Automated Teller Machine");//to set frame title
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo2.png"));
		Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);//to set image width ,height 
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		setLayout(null);
		//to change the background of the frame
		getContentPane().setBackground(Color.WHITE);
//to set custom layout make setLayout to null 		
		label.setBounds(120,15,80,80);	
		//to place the label in specific location (from left,from top,image wigth,image length)
		add(label);
		JLabel text = new JLabel("Welcome to ATM");//the layout is null so we have to set the bounds to make it visible
		text.setBounds(240,25,400,50);
		text.setFont(new Font("Osward",Font.BOLD,35));//(font style,font type,size)
		add(text);
		//Border border = BorderFactory.createLineBorder(Color.BLUE, 2); TO SET BORDER 
        // Set the border for the JLabel
      //  text.setBorder(border);
		JLabel cardno = new JLabel("Card No:");
		cardno.setBounds(130,120,160,50);
		cardno.setFont(new Font("Raleway",Font.BOLD,25));
		add(cardno);
		JLabel pin= new JLabel("PIN:");
		pin.setBounds(130,170,160,50);
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		add(pin);
		 cardtextfield = new JTextField();
		cardtextfield.setBounds(300,130,230,30);
		cardtextfield.setFont(new Font("Arial",Font.BOLD,15));
		add(cardtextfield);
		pintextfield = new JPasswordField();
		pintextfield.setBounds(300,180,230,30);
		pintextfield.setFont(new Font("Arial",Font.BOLD,15));
		add(pintextfield);
		
		 login = new JButton("SIGN IN");
		login.setBounds(300,245,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.white);
		add(login);
		login.addActionListener(this);
		 clear = new JButton("CLEAR");
		clear.setBounds(430,245,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.white);
		add(clear);
		clear.addActionListener(this);
		 signup = new JButton("SIGNUP");
		signup.setBounds(300,300,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.white);
		add(signup);
		signup.addActionListener(this);
		
		
		
		
		
		
	}
	//ActionEvent is a component it will have the componentbutton which was
			//pressed like signup,sign in,clear so based upon that we can do operation 
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardtextfield.setText("");
			pintextfield.setText("");
		}
		else if(ae.getSource() == login) {
			Conn con = new Conn();
			String cardnumber = cardtextfield.getText();
			String pinnumber = pintextfield.getText();
			String query = "select *from login where cardnumber ='"+cardnumber+"'and pin = '"+pinnumber+"'";
			try {
				ResultSet rs = con.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		else if(ae.getSource() == signup) {
			setVisible(false);
			new SignupOne();
			//.setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new Login();
		
		
		

	}

}
