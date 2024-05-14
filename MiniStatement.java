package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
	String pinnumber;
	JButton exit;
	 int startboundtop;
	MiniStatement(String pinnumber){
		startboundtop = 70;
		this.pinnumber = pinnumber;
	setSize(800,800);//(width,length)
	setVisible(true);
	setLocation(350,0);
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	JLabel text = new JLabel("Mini-Statements");//the layout is null so we have to set the bounds to make it visible
	text.setBounds(240,25,400,50);
	text.setFont(new Font("Osward",Font.BOLD,35));//(font style,font type,size)
	add(text);
	Conn con = new Conn();
	 exit= new JButton("Exit");
	 exit.setForeground(Color.white);
	 exit.setBackground(Color.BLACK);
	 exit.setFont(new Font("Raleway",Font.BOLD,15));
	 exit.setBounds(670,620,100,30);
	 exit.addActionListener(this);
	add(exit);
	
	try {
		String query = "select *from bank where pin = '"+ pinnumber+"'";
		ResultSet rs = con.s.executeQuery(query);
		
		
		while(rs.next()) {
			String statement = rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
			JLabel stmts = new JLabel(statement);
			stmts.setForeground(Color.black);
			stmts.setFont(new Font("Raleway",Font.BOLD,15));
			stmts.setBounds(200,startboundtop,800,25);
			startboundtop+=30;
			add(stmts);
			
		}
		
		
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
		new MiniStatement("");

	}

}
