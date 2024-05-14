package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	JButton exit,change;
	String pinnumber;
     //JTextField p1field,p2field;
     JPasswordField p1field,p2field;
	PinChange(String pinnumber){
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
			JLabel p1 = new JLabel("New Pin");
			p1.setBounds(200,280,150,35);
			p1.setForeground(Color.white);
			p1.setFont(new Font("System",Font.BOLD,18));
			image.add(p1);
			 p1field= new JPasswordField();
			 p1field .setBounds(320,280,150,30);
			 p1field.setBackground(Color.white);
			 p1field.setForeground(Color.black);
			 p1field.setFont(new Font("Arial",Font.BOLD,15));
				image.add(p1field);
				
			JLabel p2 = new JLabel("Confirm Pin");
			p2.setBounds(200,350,150,35);
			p2.setForeground(Color.white);
			p2.setFont(new Font("System",Font.BOLD,18));
			image.add(p2);
			
			p2field= new JPasswordField();
			 p2field .setBounds(320,350,150,30);
			 p2field.setBackground(Color.white);
			 p2field.setForeground(Color.black);
			 p2field.setFont(new Font("Arial",Font.BOLD,15));
				image.add(p2field);
				exit= new JButton("Exit");
				 exit.setForeground(Color.black);
				 exit.setBackground(Color.white);
				 exit.setFont(new Font("Raleway",Font.BOLD,15));
				 exit.setBounds(350,400,150,30);
				 exit.addActionListener(this);
				image.add(exit);
				change= new JButton("Change");
				change.setForeground(Color.black);
				change.setBackground(Color.white);
				change.setFont(new Font("Raleway",Font.BOLD,15));
				change.setBounds(180,400,150,30);
				change.addActionListener(this);
				image.add(change);
				
				
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			setVisible(false);
			new Transactions(pinnumber);
		}
		else if(ae.getSource()== change) {
			String pin1 = p1field.getText();
			String pin2 = p2field.getText();
			if(pin1.equals(pin2)) {
				try {
					Conn con = new Conn();
					String query = "update bank set pin = '"+pin1+"' where pin ='"+pinnumber+"'";
					con.s.executeUpdate(query);
					
					String q2 = "update login set pin = '"+pin1+"' where pin ='"+pinnumber+"'";
					//String q2 = "update login set pin = '"+pin1+"' where pin ='"+pinnumber+"'";
                        pinnumber = pin1;
					System.out.println(query);
					System.out.println(q2);
					con.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null,"PIN changed Successfully");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
			}
			else {
			JOptionPane.showMessageDialog(null,"PIN unmatched");
			}
			
		}
	}
		public static void main(String[] args) {
			//new PinChange("");
	}
				
				
}


	

