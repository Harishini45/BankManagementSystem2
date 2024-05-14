package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener{
	JTextField panfield,aadharfield;
	JButton next;
	JComboBox occupations,categories,qualifications,religions,incomes;
	JRadioButton seniorCitizenYes,seniorCitizenNo,existingAccountYes,existingAccountNo;
	String formno;
	SignupTwo(String formno){
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		setLayout(null);
		JLabel additionaldetails = new JLabel("Page 2: Additional Details");
		additionaldetails.setBounds(195,70,400,40);
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
		add(additionaldetails);
		JLabel religion = new JLabel("Religion:");
		 religion.setBounds(100,130,100,30);
		religion.setFont(new Font("Raleway",Font.BOLD,18));
		add(religion);
		String[] religionVal = {"Hindu","Muslim","Sikh","Christian","Other"};
		religions= new JComboBox(religionVal);
		religions.setBounds(280,130,300,30);
		religions.setBackground(Color.WHITE);
		add(religions);
		 
		JLabel category = new JLabel("Category:");
		category.setBounds(100,170,200,30);
		category.setFont(new Font("Raleway",Font.BOLD,18));
		add(category);
		String[] categoryval = {"General","BC","OC","SC","ST","Other"};
		categories = new JComboBox(categoryval);
		categories.setBounds(280,170,300,30);
		categories.setBackground(Color.WHITE);
		add(categories);
		JLabel income = new JLabel("Income:");
		income.setBounds(100,210,200,30);
		income.setFont(new Font("Raleway",Font.BOLD,18));
		add(income);
		
		String[] incomeval = {"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		incomes = new JComboBox(incomeval);
		incomes.setBounds(280,210,300,30);
		incomes.setBackground(Color.WHITE);
		add(incomes);
		JLabel educational = new JLabel("Educational");
		educational.setBounds(100,255,150,25);
		educational.setFont(new Font("Raleway",Font.BOLD,18));
		add(educational);
		JLabel qualification = new JLabel("Qualification:");
		qualification .setBounds(100,275,150,25);
		qualification .setFont(new Font("Raleway",Font.BOLD,18));
		add(qualification);
		String[] educationval = {"Non-Graduation","Graduate","Post-Graduation","Doctorate","Other"};
		qualifications= new JComboBox(educationval);
		qualifications.setBounds(280,260,300,30);
		qualifications.setBackground(Color.WHITE);
		add(qualifications);
		
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setBounds(100,300,200,30);
		occupation.setFont(new Font("Raleway",Font.BOLD,18));
		add(occupation);
		
		String[] occupationval = {"Salaried","Self-Employed","Retired","Student","Unemployed","Homemaker","Other"};
		occupations= new JComboBox(occupationval);
		occupations.setBounds(280,300,300,30);
		occupations.setBackground(Color.WHITE);
		add(occupations);
		
		JLabel panno = new JLabel("PAN Number:");
		panno.setBounds(100,340,200,30);
		panno.setFont(new Font("Raleway",Font.BOLD,18));
		add(panno);
		panfield= new JTextField();
		panfield.setFont(new Font("Arial",Font.BOLD,15));
		panfield.setBounds(280,340,300,25);
		add(panfield);
		 
		JLabel aadharno = new JLabel("Aadhar Number:");
		aadharno.setBounds(100,380,200,30);
		aadharno .setFont(new Font("Raleway",Font.BOLD,18));
		add(aadharno);
		aadharfield= new JTextField();
		aadharfield.setFont(new Font("Arial",Font.BOLD,15));
		aadharfield.setBounds(280,380,300,25);
		add(aadharfield);
		JLabel seniorcitizen = new JLabel("Senior Citizen:");
		seniorcitizen.setBounds(100,420,200,30);
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,18));
		add(seniorcitizen);
		seniorCitizenYes = new JRadioButton("Yes");
		seniorCitizenYes.setFont(new Font("Arial",Font.BOLD,15));
		seniorCitizenYes.setBounds(280,420,80,25);
		seniorCitizenYes.setBackground(Color.WHITE);
		add(seniorCitizenYes);
		
		seniorCitizenNo = new JRadioButton("No");
		seniorCitizenNo.setBounds(370,420,100,25);
		seniorCitizenNo.setFont(new Font("Arial",Font.BOLD,15));
		seniorCitizenNo.setBackground(Color.WHITE);
		add(seniorCitizenNo);
		
		ButtonGroup seniorgroup = new ButtonGroup();
		seniorgroup.add(seniorCitizenYes);
		seniorgroup.add(seniorCitizenNo);
		
		JLabel existingccount = new JLabel("Existing Account:");
		existingccount.setBounds(100,460,200,30);
		existingccount.setFont(new Font("Raleway",Font.BOLD,18));
		add(existingccount);
		existingAccountYes = new JRadioButton("Yes");
		existingAccountYes.setFont(new Font("Arial",Font.BOLD,15));
		existingAccountYes.setBounds(280,460,80,25);
		existingAccountYes.setBackground(Color.WHITE);
		add(existingAccountYes);
		
		existingAccountNo = new JRadioButton("No");
		existingAccountNo.setBounds(370,460,100,25);
		existingAccountNo.setFont(new Font("Arial",Font.BOLD,15));
		existingAccountNo.setBackground(Color.WHITE);
		add(existingAccountNo);
		ButtonGroup accgroup = new ButtonGroup();
		accgroup.add(existingAccountYes);
		accgroup.add(existingAccountNo);
		 next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setBounds(480,520,100,30);
		add(next);
		next.addActionListener(this);
		
		
		setSize(700,800);
		getContentPane().setBackground(Color.WHITE);
		setLocation(350,10);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String sreligion =(String) religions.getSelectedItem();
		String scategory = (String) categories.getSelectedItem();
		String sincome = (String) incomes.getSelectedItem();
		String education = (String) qualifications.getSelectedItem();
		String soccupation = (String)occupations.getSelectedItem();
		String seniorcitizen = null;
		if(seniorCitizenYes.isSelected()) {
			seniorcitizen = "Yes";
		}
		else if(seniorCitizenNo.isSelected()) {
			seniorcitizen = "No";
		}
		String existacc = "null";
		if(existingAccountYes.isSelected()) {
			existacc = "Yes";
		}
		else if(existingAccountNo.isSelected()) {
			existacc = "No";
		}
		String panno = panfield.getText();
		String aadharno = aadharfield.getText();
		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno+"', '"+sreligion+ "' ,'"+ scategory + "' ,'"+ sincome+ "' ,'"+education+"' , '"+ soccupation+"' , '"+panno+"' , '"+aadharno+"' , '"+seniorcitizen+"' , '"+existacc +"')";
			//System.out.println(query);
			 c.s.executeUpdate(query);
			 setVisible(false);
			 new SignupThree(formno);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	

}
