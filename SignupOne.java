package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
	JTextField namefield,fnamefield,mailfield,addressfield,pinfield,cityfield,statefield;
	JButton next;
	JDateChooser dateChooser;
	JRadioButton male,female,married,unmarried,other;
	Long appno;
	SignupOne(){
		Random ran = new Random();
		//ran.nextLong()%9000L  gives 0 to 8999 in -ve or +ve so +1000L
		appno = Math.abs((ran.nextLong()%9000L)+1000L);
		JLabel formno = new JLabel("APPLICATION FORM NO: "+ appno);
		formno.setBounds(110,20,600,30);
		formno.setFont(new Font("Raleway",Font.BOLD,30));
		add(formno);
		setLayout(null);
		JLabel personaldetails = new JLabel("Page 1: Personal Details");
		personaldetails.setBounds(195,70,400,40);
		personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
		add(personaldetails);
		JLabel name = new JLabel("Name:");
		 name.setBounds(100,130,100,30);
		name.setFont(new Font("Raleway",Font.BOLD,18));
		add(name);
		 namefield = new JTextField();
		namefield.setFont(new Font("Arial",Font.BOLD,15));
		namefield.setBounds(280,135,300,25);
		add(namefield);
		JLabel fname = new JLabel("Father's Name:");
		fname.setBounds(100,170,200,30);
		fname.setFont(new Font("Raleway",Font.BOLD,18));
		add(fname);
		fnamefield = new JTextField();
		fnamefield.setFont(new Font("Arial",Font.BOLD,15));
		fnamefield.setBounds(280,170,300,25);
		add(fnamefield);
		JLabel dob = new JLabel("Date of Birth:");
		dob.setBounds(100,210,200,30);
		dob.setFont(new Font("Raleway",Font.BOLD,18));
		add(dob);
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(280,210,300,25);
		dateChooser.setFont(new Font("Arial",Font.BOLD,15));
		add(dateChooser);
		JLabel gender = new JLabel("Gender:");
		gender.setBounds(100,250,100,30);
		gender.setFont(new Font("Raleway",Font.BOLD,18));
		add(gender);
		 male = new JRadioButton("Male");
		male.setFont(new Font("Arial",Font.BOLD,15));
		male.setBounds(280,250,100,25);
		male.setBackground(Color.WHITE);
		add(male);
		
		 female = new JRadioButton("Female");
		female.setBounds(400,250,100,25);
		female.setFont(new Font("Arial",Font.BOLD,15));
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel mail = new JLabel("Email Address:");
		mail.setBounds(100,290,200,30);
		mail.setFont(new Font("Raleway",Font.BOLD,18));
		add(mail);
		mailfield = new JTextField();
		mailfield.setFont(new Font("Arial",Font.BOLD,15));
		mailfield.setBounds(280,290,300,25);
		add(mailfield);
		JLabel maritalstatus = new JLabel("Marital Status:");
		maritalstatus.setBounds(100,330,200,30);
		maritalstatus.setFont(new Font("Raleway",Font.BOLD,18));
		add(maritalstatus);
		 married = new JRadioButton("Married");
		married.setBounds(280,330,90,25);
		married.setFont(new Font("Arial",Font.BOLD,15));
		married.setBackground(Color.WHITE);
		add(married);
		 unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(370,330,100,25);
		unmarried.setFont(new Font("Arial",Font.BOLD,15));
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		 other = new JRadioButton("Other");
		other.setBounds(480,330,100,25);
		other.setFont(new Font("Arial",Font.BOLD,15));
		other.setBackground(Color.WHITE);
		add(other);
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(100,370,200,30);
		address.setFont(new Font("Raleway",Font.BOLD,18));
		add(address);
		addressfield = new JTextField();
		addressfield.setFont(new Font("Arial",Font.BOLD,15));
		addressfield.setBounds(280,370,300,25);
		add(addressfield);
		JLabel city = new JLabel("City:");
		city.setBounds(100,410,200,30);
		city.setFont(new Font("Raleway",Font.BOLD,18));
		add(city);
		cityfield = new JTextField();
		cityfield.setFont(new Font("Arial",Font.BOLD,15));
		cityfield.setBounds(280,410,300,25);
		add(cityfield);
		JLabel state = new JLabel("State:");
		state.setBounds(100,450,200,30);
		state.setFont(new Font("Raleway",Font.BOLD,18));
		add(state);
		statefield = new JTextField();
		statefield.setFont(new Font("Arial",Font.BOLD,15));
		statefield.setBounds(280,450,300,25);
		add(statefield);
		JLabel pincode = new JLabel("Pin Code:");
		pincode.setBounds(100,490,200,30);
		pincode.setFont(new Font("Raleway",Font.BOLD,18));
		add(pincode);
		pinfield = new JTextField();
		pinfield.setFont(new Font("Arial",Font.BOLD,15));
		pinfield.setBounds(280,490,300,25);
		add(pinfield);
		 next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setBounds(480,550,100,30);
		add(next);
		next.addActionListener(this);
		
		
		setSize(700,800);
		getContentPane().setBackground(Color.WHITE);
		setLocation(350,10);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String formno = appno.toString();
		String name = namefield.getText();
		String fname = fnamefield.getText();
		String email = mailfield.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		String marital = null;
		if(married.isSelected()){
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if(other.isSelected()) {
			marital = "Other";
		}
		String address = addressfield.getText();
		String city = cityfield.getText();
		String state = statefield.getText();
		String pincode = pinfield.getText();
		try {
			if(name.equals("")) {
					JOptionPane.showMessageDialog(null,"Name is Required");
				
			}
			else {
				Conn c = new Conn();
String query = "insert into signup values('"+formno+"', '"+name+ "' ,'"+ fname + "' ,'"+ dob+ "' ,'"+gender+"' , '"+ email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+pincode+"')";
//System.out.println(query);
 c.s.executeUpdate(query);
 setVisible(false);
 new SignupTwo(formno);


				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//new SignupOne();

	}  

}
